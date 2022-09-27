package eleicoes;

public class Pessoa {

    private String nome;
    private String cpf;
    private Titulo titulo;

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public Titulo getTitulo(){
        return this.titulo;
    }
}
