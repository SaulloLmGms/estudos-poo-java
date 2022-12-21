
1 - Resposta: 

  `Polimorfismo — As responsabilidades devem ser atribuídas a abstrações e não a objetos concretos, permitindo que eles possam variar conforme a necessidade.`

2 - Resposta: 

  ```java
  public Filme pesquisaFilme(String codigo) throws FilmeNaoExisteException {
    Filme filme = this.filmes.get(codigo);
    if (filme == null) {
      throw new FilmeNaoExisteException("filme não existe");
    }
    return filme;
  }
  ```
3 - Resposta: 
  ```java
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
  ```

4 - Resposta: 
  ```java
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
  ```
5 - Resposta:
  ```java
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
  ```