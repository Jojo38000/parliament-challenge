package com.parliamentchallenge.merger.speech;

import com.parliamentchallenge.merger.provider.parliament.PersonDTO;
import com.parliamentchallenge.merger.provider.parliament.SpeechDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParliamentDataProvider {

  Flux<SpeechDTO> getSpeeches(final int numberOfSpeeches);

  Mono<PersonDTO> getMember(final String id);
}
