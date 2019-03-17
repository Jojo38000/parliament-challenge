package com.parliamentchallenge.merger.speech;

import com.parliamentchallenge.merger.provider.parliament.PersonDTO;
import com.parliamentchallenge.merger.provider.parliament.SpeechDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SpeechMergerImpl implements SpeechMerger {

  private final ParliamentDataProvider parliamentDataProvider;

  public SpeechMergerImpl(final ParliamentDataProvider parliamentDataProvider) {
    this.parliamentDataProvider = parliamentDataProvider;
  }

  public Flux<EnrichedSpeech> getLatest(final int numberOfSpeeches) {
    return parliamentDataProvider.getSpeeches(numberOfSpeeches)
        .flatMap(speech -> Flux.concat(enrichWithPersonData(speech)));
  }

  private Mono<EnrichedSpeech> enrichWithPersonData(final SpeechDTO speechDTO) {
    if (speechDTO.getPersonId() == null) {
      return Mono.just(new EnrichedSpeech(speechDTO, new PersonDTO()));
    }

    return parliamentDataProvider.getMember(speechDTO.getPersonId())
        .map(personDTO -> new EnrichedSpeech(speechDTO, personDTO));
  }
}
