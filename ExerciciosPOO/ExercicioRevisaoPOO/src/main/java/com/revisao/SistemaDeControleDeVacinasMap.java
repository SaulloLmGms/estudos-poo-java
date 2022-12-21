package com.revisao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaDeControleDeVacinasMap implements SistemaDeControleDeVacinas {
  private Map<String, Pessoa> listaDePessoas;

  public SistemaDeControleDeVacinasMap() {
    this.listaDePessoas = new HashMap<>();
  }

  @Override
  public void cadastraPessoa(Pessoa pessoa) throws PessoaJaExisteException {
    if (this.listaDePessoas.containsKey(pessoa.getCpf())) {
      throw new PessoaJaExisteException("Já existe pessoa com o CPF "
          + pessoa.getCpf());
    } else {
      this.listaDePessoas.put(pessoa.getCpf(), pessoa);
    }
  }
  // Demais métodos da classe considerando que implementa a interface e que lança
  // exceção
  // também no método da interface que lança exceção…

  @Override
  public boolean existePessoaComCpf(String cpf) {
    Pessoa pessoa = listaDePessoas.get(cpf);
    if (pessoa != null) {
      return true;
    }
    return false;
  }

  @Override
  public boolean cadastraPrimeiraDoseDePessoa(String cpf, String tipoVacinaPrimeiraDose, String dataVacinaPrimeiraDose)
      throws PessoaNaoExisteException {
    Pessoa vacinado = this.listaDePessoas.get(cpf);
    if (vacinado == null) {
      throw new PessoaNaoExisteException("Not found");
    }
    if (!vacinado.recebeuPrimeiraDose()) {
      return false;
    }
    vacinado.setDataPrimeiraDose(dataVacinaPrimeiraDose);
    vacinado.setTipoVacinaPrimeiraDose(tipoVacinaPrimeiraDose);
    return true;
  }

  @Override
  public boolean cadastraSegundaDoseDePessoa(String cpf, String tipoVacinaSegundaDose, String dataVacinaSegundaDose)
      throws PessoaNaoExisteException {

    return false;
  }

  @Override
  public int pesquisaQuantidadeDeVacinadosComPrimeiraDose() {

    return 0;
  }

  @Override
  public int pesquisaQuantidadeDeVacinadosComSegundaDose() {

    return 0;
  }

  @Override
  public int pesquisaQuantidadeDeVacinadosComVacinaDoTipo(String tipoVacina) {
    int quantidade = 0;

    for (Map.Entry<String, Pessoa> entry : listaDePessoas.entrySet()) {
      Pessoa vacinado = entry.getValue();
      if (vacinado.getTipoVacinaPrimeiraDose() == tipoVacina || vacinado.getTipoVacinaSegundaDose() == tipoVacina) {
        quantidade++;
      }
    }
    return quantidade;
  }
}