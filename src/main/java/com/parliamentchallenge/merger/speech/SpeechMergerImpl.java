package com.parliamentchallenge.merger.speech;

import reactor.core.publisher.Flux;

public class SpeechMergerImpl implements SpeechMerger {

  private final ParliamentDataProvider parliamentDataProvider;

  public SpeechMergerImpl(
      final ParliamentDataProvider parliamentDataProvider) {
    this.parliamentDataProvider = parliamentDataProvider;
  }

  public Flux<MergedSpeech> getLatest(final int numberOfSpeeches) {
    parliamentDataProvider.getSpeeches(numberOfSpeeches)
        .subscribe(s -> s.getTopic());

    return Flux.empty();
  }

}
