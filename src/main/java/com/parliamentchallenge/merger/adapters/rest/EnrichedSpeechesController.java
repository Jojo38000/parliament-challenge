package com.parliamentchallenge.merger.adapters.rest;

import com.parliamentchallenge.merger.enrichedspeech.EnrichedSpeech;
import com.parliamentchallenge.merger.enrichedspeech.SpeechEnricher;
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

  private final SpeechEnricher speechEnricher;

  public EnrichedSpeechesController(final SpeechEnricher speechEnricher) {
    this.speechEnricher = speechEnricher;
  }

  @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
  public Flux<EnrichedSpeech> getAllMergedSpeeches(
      @RequestParam(defaultValue = "10") final int size) {

    return speechEnricher
        .getLatest(Math.abs(size))
        .delayElements(Duration.ofMillis(100)); // Fooling around with streams over HTTP
  }
}