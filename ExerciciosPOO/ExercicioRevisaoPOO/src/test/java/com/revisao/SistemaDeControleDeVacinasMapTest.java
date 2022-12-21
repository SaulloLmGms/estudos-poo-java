package com.revisao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class SistemaDeControleDeVacinasMapTest {
  @Test
  void testCadastraPessoa() {
    SistemaDeControleDeVacinasMap sistema = new SistemaDeControleDeVacinasMap();
    try {
      sistema.cadastraPessoa(new Pessoa("Maria José", "222.222.222-22"));
      assertTrue(sistema.existePessoaComCpf("222.222.222-22"));
    } catch (PessoaJaExisteException e) {
      fail("Não deveria lançar exceção");
    }
  }

  @Test
  void testPesquisaQuantidadeDeVacinadosComVacinaDoTipo() {
    SistemaDeControleDeVacinasMap sistema = new SistemaDeControleDeVacinasMap();
    try {
      sistema.cadastraPessoa(
          new Pessoa("Maria Paula Nunes", "333.333.333-33", "20-10-2022", "fyzer", "30-11-2022", "fyzer"));
      sistema.cadastraPessoa(new Pessoa("josé", "000.000.00-01", "20-10-2022", "fyzer", "30-11-2022", "fyzer"));
      assertEquals(2, sistema.pesquisaQuantidadeDeVacinadosComVacinaDoTipo("fyzer"));
    } catch (PessoaJaExisteException e) {
      fail("Não deveria lançar exceção");
    }
  }
}