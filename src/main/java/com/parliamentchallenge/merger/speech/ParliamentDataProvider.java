package com.parliamentchallenge.merger.speech;

import reactor.core.publisher.Flux;

public interface ParliamentDataProvider {

  Flux<Speech> getSpeeches(final int numberOfSpeeches);

  void getMember(final String id);
}
