package com.parliamentchallenge.merger.adapters.rest;

import com.parliamentchallenge.merger.speech.MergedSpeech;
import com.parliamentchallenge.merger.speech.SpeechMerger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@ResponseBody
@RequestMapping("/speeches")
public class MergedSpeechesController {

  private final SpeechMerger speechMerger;

  public MergedSpeechesController(final SpeechMerger speechMerger) {
    this.speechMerger = speechMerger;
  }

  @GetMapping
  public Flux<MergedSpeech> getAllMergedSpeeches() {
    return speechMerger.getLatest(10);
  }
}