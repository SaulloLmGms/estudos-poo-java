package com.filmes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFilmesMap implements SistemaFilmes {
  private Map<String, Filme> filmes;

  public SistemaFilmesMap() {
    this.filmes = new HashMap<String, Filme>();
  }

  public void cadastraFilme(Filme novoFilme) throws FilmeJaExisteException {
    if (this.filmes.containsKey(novoFilme.getCodigo())) {
      throw new FilmeJaExisteException("Já existe filme com este código");
    } else {
      this.filmes.put(novoFilme.getCodigo(), novoFilme);
    }
  }

  public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException {
    Filme filme = this.filmes.get(codigo);
    if (filme == null) {
      throw new FilmeNaoExisteException("filme não existe");
    }
    return filme;
  }

  public List<Filme> obterFilmesLancadosEm(int ano) {
    List<Filme> listaFilmes = new ArrayList<Filme>();
    for (Map.Entry<String, Filme> filme : this.filmes.entrySet()) {
      Filme item = filme.getValue();

      if (item.getAnoLancamento() == ano) {
        listaFilmes.add(item);
      }
    }
    return listaFilmes;
  }

  public List<Filme> obterFilmesComNome(String nome) {
    List<Filme> listaFilmes = new ArrayList<Filme>();
    for (Map.Entry<String, Filme> filme : this.filmes.entrySet()) {
      Filme item = filme.getValue();

      if (item.getNome() == nome) {
        listaFilmes.add(item);
      }
    }
    return listaFilmes;
  }

  public boolean existemFilmesDaCategoria(CategoriaFilme categoria) {
    for (Map.Entry<String, Filme> filme : this.filmes.entrySet()) {
      Filme item = filme.getValue();
      for (CategoriaFilme itemCategoria : item.getCategorias()) {
        if (itemCategoria == categoria) {
          return true;
        }
      }
    }
    return false;
  }

  public int contaFilmesDaCategoria(CategoriaFilme categoria) {
    int quantidade = 0;
    for (Map.Entry<String, Filme> filme : this.filmes.entrySet()) {
      Filme item = filme.getValue();
      for (CategoriaFilme itemCategoria : item.getCategorias()) {
        if (itemCategoria == categoria) {
          quantidade++;
        }
      }
    }
    return quantidade;
  }
}
