package com.saullo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaAmigoMapTest {
  SistemaAmigoMap sistema;

  @BeforeEach
  public void setUp() {
    this.sistema = new SistemaAmigoMap();
  }

  @Test
  public void testPesquisarMensagens() {
    assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
    assertThrows(AmigoInexistenteException.class,
        () -> sistema.pesquisaAmigoSecretoDe("saullo@teste.com"));
  }

  @Test
  public void testPesquisaECadastraAmigo() {
    try {
      sistema.pesquisaAmigo("saullo@teste.com");
      fail("Deveria falhar pois não existe ainda");
    } catch (AmigoInexistenteException e) {
      // Ok
    }
    try {
      Amigo saullo = new Amigo();
      saullo.setNome("Saullo");
      saullo.setEmail("saullo@teste.com");

      sistema.cadastrarAmigo(saullo);

      Amigo a = sistema.pesquisaAmigo("saullo@teste.com");
      assertEquals("Saullo", a.getNome());
      assertEquals("saullo@teste.com", a.getEmail());
    } catch (AmigoInexistenteException e) {
      fail("Não deveria lançar exceção");
    }
  }

  @Test
  public void testConfiguraAmigoSecretoDe() {
    try {
      sistema.configuraAmigoSecretoDe("saullo@teste.com", "invalid-email@test.com");
    } catch (AmigoInexistenteException e) {
      assertEquals("Amigo Inexistente", e.getText());
    }
  }

  @Test
  public void testTesquisaAmigoSecretoDe() {
    Amigo saullo = new Amigo();
    saullo.setNome("Saullo");
    saullo.setEmail("saullo@teste.com");

    sistema.cadastrarAmigo(saullo);
    try {
      sistema.pesquisaAmigoSecretoDe("saullo@teste.com");
    } catch (Exception e) {
      assertEquals("Amigo Não Configurado", e.getMessage());
    }
  }

}
