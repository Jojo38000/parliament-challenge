package com.parliamentchallenge.merger.speech;

import reactor.core.publisher.Flux;

public interface SpeechMerger {

  Flux<MergedSpeech> getLatest(final int numberOfSpeeches);

}
