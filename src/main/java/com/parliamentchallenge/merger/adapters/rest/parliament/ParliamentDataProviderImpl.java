package com.parliamentchallenge.merger.adapters.rest.parliament;

import com.parliamentchallenge.merger.speech.ParliamentDataProvider;
import com.parliamentchallenge.merger.speech.Speech;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

public class ParliamentDataProviderImpl implements ParliamentDataProvider {

  private final WebClient webClient;

  public ParliamentDataProviderImpl(final WebClient.Builder webClientBuilder) {
    webClient = webClientBuilder.baseUrl("http://data.riksdagen.se").build();
  }

  @Override
  public Flux<Speech> getSpeeches(final int numberOfSpeeches) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("anforandelista/")
            .queryParam("anftyp", "Nej")
            .queryParam("utformat", "json")
            .queryParam("sz", numberOfSpeeches)
            .build())
        .retrieve()
        .bodyToMono(SpeechListDTO.class)
        .flatMapIterable(speechListDTO -> speechListDTO.getSpeeches().getSpeechList())
        .map(this::createSpeech);
  }

  private Speech createSpeech(final SpeechDTO speechDTO) {
    final Speech speech = new Speech();
    speech.setSpeechId(speechDTO.getSpeechId());
    speech.setTopic(speechDTO.getTopic());
    speech.setResponseNo(speechDTO.getResponseNo());
    speech.setLink(speechDTO.getProtocol());
    speech.setMemberId(speechDTO.getPersonId());

    return speech;
  }

  @Override
  public void getMember(final String id) {

  }
}
