package com.filmes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SistemaFilmesMapTest {
    SistemaFilmesMap sistema;

    @BeforeEach
    public void init() {
        this.sistema = new SistemaFilmesMap();
    }

    @Test
    void testaCadastroEPesquisa() {
        this.sistema = new SistemaFilmesMap();
        List<CategoriaFilme> categorias = new ArrayList<CategoriaFilme>();
        categorias.add(CategoriaFilme.ACAO);
        try {
            sistema.cadastraFilme(new Filme("001", "Matrix", 1999, 136, categorias));
            Filme f = sistema.pesquisaFilme("001");
            assertEquals("Matrix", f.getNome());
        } catch (Exception e) {
            fail("Não deveria lançar exceção ao cadastrar e pesquisar depois");
        }
    }

    @Test
    public void testarContaFilmesDaCategoria() throws FilmeJaExisteException {
        List<CategoriaFilme> categorias = new ArrayList<CategoriaFilme>();
        categorias.add(CategoriaFilme.ROMANCE);
        sistema.cadastraFilme(new Filme("002", "Um amor para recordar", 2012, 136, categorias));

        int result = this.sistema.contaFilmesDaCategoria(CategoriaFilme.ROMANCE);
        int deveSerZero = this.sistema.contaFilmesDaCategoria(CategoriaFilme.TERROR);

        assertEquals(1, result);
        assertEquals(0, deveSerZero);
    }
}