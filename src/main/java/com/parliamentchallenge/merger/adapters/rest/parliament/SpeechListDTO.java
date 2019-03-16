package com.parliamentchallenge.merger.adapters.rest.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class SpeechListDTO {

  @JsonProperty("anforandelista")
  private SpeechList speeches;

  public SpeechList getSpeeches() {
    return speeches;
  }

  public static class SpeechList {

    @JsonProperty("@antal")
    private int size;

    @JsonProperty("anforande")
    private List<SpeechDTO> speechList;

    public int getSize() {
      return size;
    }

    public List<SpeechDTO> getSpeechList() {
      return speechList;
    }
  }
}
