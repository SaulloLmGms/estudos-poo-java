package eleicoes;

public class Candidato {

    private String nome;
    private int numero;
    private String partido;

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNumero(){
        return this.numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getPartido(){
        return this.partido;
    }

    public void setPartido(String partido){
        this.partido = partido;
    }
}
