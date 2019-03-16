package com.parliamentchallenge.merger.speech;

import java.net.URL;

public class Speech {

  private String speechId;
  private String responseNo;
  private String topic;
  private URL link;
  private String memberId;

  public String getSpeechId() {
    return speechId;
  }

  public void setSpeechId(final String speechId) {
    this.speechId = speechId;
  }

  public String getResponseNo() {
    return responseNo;
  }

  public void setResponseNo(final String responseNo) {
    this.responseNo = responseNo;
  }

  public String getTopic() {
    return topic;
  }

  public void setTopic(final String topic) {
    this.topic = topic;
  }

  public URL getLink() {
    return link;
  }

  public void setLink(final URL link) {
    this.link = link;
  }

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(final String memberId) {
    this.memberId = memberId;
  }
}
