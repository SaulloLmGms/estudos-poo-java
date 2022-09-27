package eleicoes;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class SistemaEleitoral implements SistemaEleitoralInterface {

    private List<Pessoa> eleitores;
    private List<Voto> votos;
    private List<Candidato> candidatos;


    public void votar(String numTitulo, int numeroVotado){
        Optional<Pessoa> eleitor = eleitores.stream().filter(el -> Objects.equals(el.getTitulo().getNumero(), numTitulo)).findFirst();
        if(eleitor.isEmpty()){
            System.out.println("Eleitor não existe.");
        }
        Voto voto = new Voto();
        voto.setNumeroVotado(numeroVotado);
        votos.add(voto);
    }

    public Candidato obterDadosDoCandidato(int numero){
        Optional<Candidato> candidato = candidatos.stream().filter(Cand -> Objects.equals(Cand.getNumero(), numero)).findFirst();
        if(candidato.isEmpty()){
            System.out.println("Candidato não existe.");
        }
        return candidato.get();
    }

    public long obterNumeroVotosEmBranco(){
        Stream<Voto> emBranco = votos.stream().filter(Vot -> Objects.equals(Vot.getNumeroVotado(), 0));
        if(votos.isEmpty()){
            System.out.println("Não existem votos em branco.");
        }
        return emBranco.toArray().length;
    }





}
