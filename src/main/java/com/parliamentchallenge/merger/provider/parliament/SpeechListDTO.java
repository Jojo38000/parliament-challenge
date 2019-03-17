package com.parliamentchallenge.merger.provider.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

class SpeechListDTO {

  @JsonProperty("anforandelista")
  private SpeechList speeches;

  SpeechList getSpeeches() {
    return speeches;
  }

  static class SpeechList {

    @JsonProperty("@antal")
    private int size;

    @JsonProperty("anforande")
    private List<SpeechDTO> speechList;

    int getSize() {
      return size;
    }

    List<SpeechDTO> getSpeechList() {
      return speechList;
    }
  }
}
