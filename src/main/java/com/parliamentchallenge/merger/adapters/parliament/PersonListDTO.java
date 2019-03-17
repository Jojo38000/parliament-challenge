package com.parliamentchallenge.merger.adapters.parliament;

import com.fasterxml.jackson.annotation.JsonProperty;

class PersonListDTO {

  @JsonProperty("personlista")
  private PersonList personList;

  PersonList getPersonList() {
    return personList;
  }

  static class PersonList {

    @JsonProperty("person")
    private PersonDTO person;

    PersonDTO getPerson() {
      return person;
    }
  }
}
