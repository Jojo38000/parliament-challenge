package com.parliamentchallenge.merger.adapters.rest;

import com.parliamentchallenge.merger.speech.EnrichedSpeech;
import com.parliamentchallenge.merger.speech.SpeechMerger;
import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;

@ResponseBody
@RequestMapping("/speeches")
public class EnrichedSpeechesController {

  private final SpeechMerger speechMerger;

  public EnrichedSpeechesController(final SpeechMerger speechMerger) {
    this.speechMerger = speechMerger;
  }

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<EnrichedSpeech> getAllMergedSpeeches(
      @RequestParam(defaultValue = "10") final int size) {
    
    return speechMerger
        .getLatest(Math.abs(size))
        .delayElements(Duration.ofMillis(100)); // Fooling around with streams over HTTP
  }
}