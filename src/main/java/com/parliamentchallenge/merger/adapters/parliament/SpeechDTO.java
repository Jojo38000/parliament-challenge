package com.parliamentchallenge.merger.adapters.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;
import java.time.LocalDate;

public class SpeechDTO {

  @JsonProperty("anforande_id")
  private String speechId;

  @JsonProperty("dok_datum")
  private LocalDate date;

  @JsonProperty("anforande_nummer")
  private String responseNo;

  @JsonProperty("avsnittsrubrik")
  private String topic;

  @JsonProperty("protokoll_url_www")
  private URL protocol;

  @JsonProperty("intressent_id")
  private String personId;

  public String getSpeechId() {
    return speechId;
  }

  public LocalDate getDate() {
    return date;
  }

  public String getResponseNo() {
    return responseNo;
  }

  public String getTopic() {
    return topic;
  }

  public URL getProtocol() {
    return protocol;
  }

  public String getPersonId() {
    return personId;
  }
}
