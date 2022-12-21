package com.thread;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

public class TATest {
  TA threadA;
  Contador cont;

  @Test
  public void verificarValorContador() throws InterruptedException {
    try {
      this.cont = new Contador();
      this.threadA = new TA(cont);
      this.threadA.start();
      this.threadA.join();
      assertTrue(cont.getValor() == 1);
      assertEquals(cont.getValor(), 1);
    } catch (InterruptedException error) {
      fail("Não deveria lançar exceção");
    }
  }
}
