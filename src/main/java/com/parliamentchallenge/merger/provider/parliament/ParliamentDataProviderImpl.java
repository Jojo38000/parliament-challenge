package com.parliamentchallenge.merger.provider.parliament;

import com.parliamentchallenge.merger.speech.ParliamentDataProvider;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ParliamentDataProviderImpl implements ParliamentDataProvider {

  private final WebClient webClient;

  public ParliamentDataProviderImpl(final WebClient.Builder webClientBuilder) {
    webClient = webClientBuilder.baseUrl("http://data.riksdagen.se").build();
  }

  @Override
  public Flux<SpeechDTO> getSpeeches(final int numberOfSpeeches) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("anforandelista/")
            .queryParam("anftyp", "Nej")
            .queryParam("utformat", "json")
            .queryParam("sz", numberOfSpeeches)
            .build())
        .retrieve()
        .bodyToMono(SpeechListDTO.class)
        .flatMapIterable(speechListDTO -> speechListDTO.getSpeeches().getSpeechList());
  }

  @Override
  public Mono<PersonDTO> getMember(final String id) {
    return webClient.get()
        .uri(uriBuilder -> uriBuilder.path("personlista/")
            .queryParam("utformat", "json")
            .queryParam("iid", id)
            .build())
        .retrieve()
        .bodyToMono(PersonListDTO.class)
        .map(personListDTO -> personListDTO.getPersonList().getPerson());
  }
}
