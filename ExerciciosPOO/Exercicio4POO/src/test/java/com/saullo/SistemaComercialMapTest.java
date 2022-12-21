package com.saullo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaComercialMapTest {
  SistemaComercialMap sistema;

  @BeforeEach
  public void setUp() {
    this.sistema = new SistemaComercialMap();
  }

  @Test
  public void testaCadastroProdutos() {
    Produto produto = new Produto("2233", "any-product", 10, 1, CategoriaProduto.ALIMENTO);
    this.sistema.cadastraProduto(produto);

    Collection<Produto> alimentos = this.sistema.pesquisaProdutosDaCategoria(CategoriaProduto.ALIMENTO);
    assertTrue(alimentos.contains(produto));
    assertTrue(alimentos.size() == 1);
  }
}