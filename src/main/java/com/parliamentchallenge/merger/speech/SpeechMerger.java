package com.parliamentchallenge.merger.speech;

import reactor.core.publisher.Flux;

public interface SpeechMerger {

  Flux<EnrichedSpeech> getLatest(final int numberOfSpeeches);

}
