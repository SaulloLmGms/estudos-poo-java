package com.saullo;

public class Produto {
  public String codigo;
  public String descricao;
  public double precoVenda;
  public int quantidadeEmEstoque;
  public CategoriaProduto categoria;

  public Produto(String codigo, String descricao, double precoVenda, int quantidadeEmEstoque,
      CategoriaProduto categoria) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.precoVenda = precoVenda;
    this.quantidadeEmEstoque = quantidadeEmEstoque;
    this.categoria = categoria;
  }

  public String getCodigo() {
    return this.codigo;
  }

  public CategoriaProduto getCategoria() {
    return this.categoria;
  }
}
