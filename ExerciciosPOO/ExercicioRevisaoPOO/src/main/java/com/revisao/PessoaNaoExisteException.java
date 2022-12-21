package com.revisao;

public class PessoaNaoExisteException extends Exception {
  public PessoaNaoExisteException(String text) {
    super(text);
  }
}
