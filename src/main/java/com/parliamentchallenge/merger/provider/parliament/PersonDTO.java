package com.parliamentchallenge.merger.provider.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.net.URL;

public class PersonDTO {

  @JsonProperty("intressent_id")
  private String personId;

  @JsonProperty("tilltalsnamn")
  private String firstName;

  @JsonProperty("efternamn")
  private String lastName;

  @JsonProperty("parti")
  private String affiliation;

  @JsonProperty("valkrets")
  private String constituency;

  @JsonProperty("bild_url_192")
  private URL image;

  public String getPersonId() {
    return personId;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAffiliation() {
    return affiliation;
  }

  public String getConstituency() {
    return constituency;
  }

  public URL getImage() {
    return image;
  }
}
