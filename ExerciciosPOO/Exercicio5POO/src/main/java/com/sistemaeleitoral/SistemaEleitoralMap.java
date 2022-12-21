package main.java.com.sistemaeleitoral;

import java.util.*;

public class SistemaEleitoralMap implements SistemaEleitoralInterface {

    private Map<String, Eleitor> eleitores;
    private final Map<String, Candidato> candidatos;
    private List<Voto> votos;

    public SistemaEleitoralMap() {
        this.eleitores = new HashMap<>();
        this.candidatos = new HashMap<>();
        this.votos = new ArrayList<>();
    }

    @Override
    public void votar(String numTitulo, int numeroVotado) throws TituloInexistenteException {

    }

    @Override
    public Candidato obterDadosDoCandidato(String nome) throws CandidatoInexistenteException {
        Candidato candidato = this.candidatos.get(nome);
        if (candidato == null) {
            throw new CandidatoInexistenteException("Não existe candidato com o nome " + nome);
        } else {
            return candidato;
        }
    }

    @Override
    public int contarVotosParaCandidato(int numeroDoCandidato) {
        int quantidade = 0;
        for (Voto voto: this.votos) {
            if(voto.getNumeroVotado() == numeroDoCandidato){
                quantidade ++;
            }
        }
        return quantidade;
    }

    @Override
    public boolean cadastraCandidato(String nome, int numero, Partido partido) {
        for (Map.Entry<String, Candidato> entry: this.candidatos.entrySet()) {
            Candidato candidato = entry.getValue();
            if (candidato.getNome() == nome){
                return false;
            }

        }
        Candidato candidato = new Candidato(nome, numero, partido);
        this.candidatos.put(nome, candidato);
        return true;
    }

    @Override
    public boolean cadastraEleitor(String nome, String titulo) {
        for (Map.Entry<String, Eleitor> entry: this.eleitores.entrySet()) {
             Eleitor eleitor = entry.getValue();
            if (eleitor.getNome() == nome){
                return false;
            }

        }
        Eleitor eleitor = new Eleitor (nome, titulo);
        this.eleitores.put(nome, eleitor);
        return true;
    }
}