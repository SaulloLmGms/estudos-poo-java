package com.revisao;

public interface SistemaDeControleDeVacinas {
  void cadastraPessoa(Pessoa pessoa) throws PessoaJaExisteException;

  boolean existePessoaComCpf(String cpf);

  boolean cadastraPrimeiraDoseDePessoa(String cpf, String tipoVacinaPrimeiraDose,
      String dataVacinaPrimeiraDose) throws PessoaNaoExisteException;

  boolean cadastraSegundaDoseDePessoa(String cpf, String tipoVacinaSegundaDose,
      String dataVacinaSegundaDose) throws PessoaNaoExisteException;

  int pesquisaQuantidadeDeVacinadosComPrimeiraDose();

  int pesquisaQuantidadeDeVacinadosComSegundaDose();

  int pesquisaQuantidadeDeVacinadosComVacinaDoTipo(String tipoVacina);
}