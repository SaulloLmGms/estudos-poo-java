package main.java.com.sistemaeleitoral;

public class Candidato {
    public String getNome() {
        return nome;
    }

    private String nome;

    public int getNumero() {
        return numero;
    }

    private int numero;
    private Partido partido;

    public Candidato(String nome, int numero, Partido partido) {
        this.nome = nome;
        this.numero = numero;
        this.partido = partido;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
} //…

