package com.parliamentchallenge.merger.config;

import com.parliamentchallenge.merger.adapters.rest.MergedSpeechesController;
import com.parliamentchallenge.merger.adapters.rest.parliament.ParliamentDataProviderImpl;
import com.parliamentchallenge.merger.speech.ParliamentDataProvider;
import com.parliamentchallenge.merger.speech.SpeechMerger;
import com.parliamentchallenge.merger.speech.SpeechMergerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MergerConfig {

  @Bean
  ParliamentDataProvider buildParliamentDataProvider() {
    return new ParliamentDataProviderImpl(WebClient.builder());
  }

  @Bean
  SpeechMerger buildSpeechMergerService(final ParliamentDataProvider parliamentDataProvider) {
    return new SpeechMergerImpl(parliamentDataProvider);
  }

  @Bean
  MergedSpeechesController buildSpeechesController(final SpeechMerger speechMerger) {
    return new MergedSpeechesController(speechMerger);
  }

}
