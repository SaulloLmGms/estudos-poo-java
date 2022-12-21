package com.saullo;

public class ClienteNaoExisteException extends Exception {
  private String text;

  public String getText() {
    return this.text;
  }

  public ClienteNaoExisteException(String text) {
    super(text);
    this.text = text;
  }

}
