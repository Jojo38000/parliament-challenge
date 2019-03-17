package com.parliamentchallenge.merger.enrichedspeech;

import reactor.core.publisher.Flux;

public interface SpeechEnricher {

  Flux<EnrichedSpeech> getLatest(final int numberOfSpeeches);

}
