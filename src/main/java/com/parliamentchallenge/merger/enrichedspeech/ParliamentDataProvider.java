package com.parliamentchallenge.merger.enrichedspeech;

import com.parliamentchallenge.merger.adapters.parliament.PersonDTO;
import com.parliamentchallenge.merger.adapters.parliament.SpeechDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParliamentDataProvider {

  Flux<SpeechDTO> getSpeeches(final int numberOfSpeeches);

  Mono<PersonDTO> getMember(final String id);
}
