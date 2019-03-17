package com.parliamentchallenge.merger.provider.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;

public class SpeechDTO {

  @JsonProperty("anforande_id")
  private String speechId;

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
