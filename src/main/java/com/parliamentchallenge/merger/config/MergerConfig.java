package com.parliamentchallenge.merger.config;

import com.parliamentchallenge.merger.adapters.parliament.ParliamentDataProviderImpl;
import com.parliamentchallenge.merger.adapters.rest.EnrichedSpeechesController;
import com.parliamentchallenge.merger.enrichedspeech.ParliamentDataProvider;
import com.parliamentchallenge.merger.enrichedspeech.SpeechEnricher;
import com.parliamentchallenge.merger.enrichedspeech.SpeechEnricherImpl;
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
  SpeechEnricher buildSpeechMergerService(final ParliamentDataProvider parliamentDataProvider) {
    return new SpeechEnricherImpl(parliamentDataProvider);
  }

  @Bean
  EnrichedSpeechesController buildSpeechesController(final SpeechEnricher speechEnricher) {
    return new EnrichedSpeechesController(speechEnricher);
  }

}
