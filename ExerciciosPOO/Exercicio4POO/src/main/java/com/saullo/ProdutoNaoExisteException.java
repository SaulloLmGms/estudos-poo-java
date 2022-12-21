
package com.saullo;

public class ProdutoNaoExisteException extends Exception {
  private String text;

  public String getText() {
    return this.text;
  }

  public ProdutoNaoExisteException(String text) {
    super(text);
    this.text = text;
  }

}
