import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class SistemaAmigo {

    private List<Mensagem> mensagens = new ArrayList<>();
    private List<Amigo> amigos = new ArrayList<>();

    public List<Amigo> getAmigos(){
        return this.amigos;
    }

    public List<Mensagem> getMensagens(){
        return this.mensagens;
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = mensagens.stream().filter(msg -> msg.ehAnonima()).toList();
        return mensagensAnonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        Optional<Amigo> amigoFiltrado = amigos.stream().filter(amigo -> Objects.equals(amigo.getEmail(), emailDaPessoa)).findFirst();
        if(amigoFiltrado.isEmpty()){
            throw new AmigoInexistenteException("Amigo Inexistente");
        }
        amigoFiltrado.get().setAmigoSorteado(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }
    public List<Amigo> cadastrarAmigo(Amigo amigo) {
        this.amigos.add(amigo);
        return amigos;
    }

    public void salvarMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        Optional<Amigo> amigoFiltrado = amigos.stream().filter(amigo -> Objects.equals(amigo.getEmail(), emailDaPessoa)).findFirst();
        if(amigoFiltrado.isEmpty()){
            throw new AmigoInexistenteException("Amigo Inexistente");
        }
        if(amigoFiltrado.get().getEmailAmigoSorteado() == null){
            throw new AmigoNaoSorteadoException("Amigo Não Configurado");
        }
        Optional<Amigo> amigoSecreto = amigos.stream().filter(amigo -> Objects.equals(amigo.getEmail(), amigoFiltrado.get().getEmailAmigoSorteado())).findFirst();
        if(amigoSecreto.isEmpty()){
            throw new AmigoInexistenteException("Amigo Secreto Inexistente");
        }
        return amigoSecreto.get().getNome();
    }

    public void sortear(){

        
    }
}
