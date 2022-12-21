package main.java.com.sistemaeleitoral;

public class Eleitor {

    public String nome;

    public Eleitor(String nome, String titulo) {
        this.nome = nome;
        this.titulo = titulo;
    }

    public String getNome() {
        return nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String titulo;


}
