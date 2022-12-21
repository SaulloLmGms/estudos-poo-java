package com.revisao;

public class Pessoa {
  private String nome;
  private String cpf;
  private String dataPrimeiraDose;
  private String tipoVacinaPrimeiraDose;
  private String dataSegundaDose;
  private String tipoVacinaSegundaDose;

  public Pessoa() {
    this("", "", "", "", "", "");
  }

  public Pessoa(String nome, String cpf) {
    this(nome, cpf, "", "", "", "");
  }

  public Pessoa(String nome, String cpf, String dataPrimeiraDose,
      String tipoVacinaPrimeiraDose, String dataSegundaDose,
      String tipoVacinaSegundaDose) {
    this.nome = nome;
    this.cpf = cpf;
    this.dataPrimeiraDose = dataPrimeiraDose;
    this.tipoVacinaPrimeiraDose = tipoVacinaPrimeiraDose;
    this.dataSegundaDose = dataSegundaDose;
    this.tipoVacinaSegundaDose = tipoVacinaSegundaDose;
  }

  public boolean recebeuPrimeiraDose() {
    return (!this.dataPrimeiraDose.equals(""));
    // Verifica se a data da primeira dose não está vazia. Estamos assumindo
    // que quando a pessoa não se vacinou o valor é "".
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getDataPrimeiraDose() {
    return dataPrimeiraDose;
  }

  public void setDataPrimeiraDose(String dataPrimeiraDose) {
    this.dataPrimeiraDose = dataPrimeiraDose;
  }

  public String getTipoVacinaPrimeiraDose() {
    return tipoVacinaPrimeiraDose;
  }

  public void setTipoVacinaPrimeiraDose(String tipoVacinaPrimeiraDose) {
    this.tipoVacinaPrimeiraDose = tipoVacinaPrimeiraDose;
  }

  public String getDataSegundaDose() {
    return dataSegundaDose;
  }

  public void setDataSegundaDose(String dataSegundaDose) {
    this.dataSegundaDose = dataSegundaDose;
  }

  public String getTipoVacinaSegundaDose() {
    return tipoVacinaSegundaDose;
  }

  public void setTipoVacinaSegundaDose(String tipoVacinaSegundaDose) {
    this.tipoVacinaSegundaDose = tipoVacinaSegundaDose;
  }
}