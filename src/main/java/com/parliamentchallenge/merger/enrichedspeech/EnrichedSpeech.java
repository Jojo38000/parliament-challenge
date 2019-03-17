package com.parliamentchallenge.merger.enrichedspeech;

import com.parliamentchallenge.merger.adapters.parliament.PersonDTO;
import com.parliamentchallenge.merger.adapters.parliament.SpeechDTO;
import java.net.URL;
import java.time.LocalDate;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class EnrichedSpeech extends ResourceSupport {

  private final String speechId;
  private final LocalDate date;
  private final String responseNo;
  private final String topic;
  private final String personId;
  private final String firstName;
  private final String lastName;
  private final String affiliation;
  private final String constituency;
  private final URL image;

  EnrichedSpeech(final SpeechDTO speech, final PersonDTO person) {
    speechId = speech.getSpeechId();
    date = speech.getDate();
    responseNo = speech.getResponseNo();
    topic = speech.getTopic();
    personId = speech.getPersonId();
    firstName = person.getFirstName();
    lastName = person.getLastName();
    affiliation = person.getAffiliation();
    constituency = person.getConstituency();
    image = person.getImage();

    this.add(new Link(speech.getProtocol().toString()));
  }

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
