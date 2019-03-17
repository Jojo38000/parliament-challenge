package com.parliamentchallenge.merger.enrichedspeech;

import com.parliamentchallenge.merger.adapters.parliament.PersonDTO;
import com.parliamentchallenge.merger.adapters.parliament.SpeechDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class SpeechEnricherImpl implements SpeechEnricher {

  private final ParliamentDataProvider parliamentDataProvider;

  public SpeechEnricherImpl(final ParliamentDataProvider parliamentDataProvider) {
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
