package com.parliamentchallenge.merger.speech;

import com.parliamentchallenge.merger.provider.parliament.PersonDTO;
import com.parliamentchallenge.merger.provider.parliament.SpeechDTO;
import java.net.URL;

public class EnrichedSpeech {

  private final String speechId;
  private final String responseNo;
  private final String topic;
  private final URL protocol;
  private final String personId;
  private final String firstName;
  private final String lastName;
  private final String affiliation;
  private final String constituency;
  private final URL image;

  EnrichedSpeech(final SpeechDTO speech, final PersonDTO person) {
    speechId = speech.getSpeechId();
    responseNo = speech.getResponseNo();
    topic = speech.getTopic();
    protocol = speech.getProtocol();
    personId = speech.getPersonId();
    firstName = person.getFirstName();
    lastName = person.getLastName();
    affiliation = person.getAffiliation();
    constituency = person.getConstituency();
    image = person.getImage();
  }

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
