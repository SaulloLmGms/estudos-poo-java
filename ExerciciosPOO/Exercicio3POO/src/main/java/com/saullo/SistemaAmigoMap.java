package com.saullo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SistemaAmigoMap {

    private List<Mensagem> mensagens = new ArrayList<Mensagem>();
    private Map<Integer, Amigo> amigos = new HashMap<Integer, Amigo>();

    public Map<Integer, Amigo> getAmigos() {
        return this.amigos;
    }

    public List<Mensagem> getMensagens() {
        return this.mensagens;
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = mensagens.stream().filter(msg -> msg.ehAnonima()).toList();
        return mensagensAnonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado)
            throws AmigoInexistenteException {
        Optional<Map.Entry<Integer, Amigo>> amigoFiltrado = amigos.entrySet().stream()
                .filter(amigo -> Objects.equals(amigo.getValue().getEmail(), emailDaPessoa)).findFirst();
        if (amigoFiltrado.isEmpty()) {
            throw new AmigoInexistenteException("Amigo Inexistente");
        }
        amigoFiltrado.get().getValue().setAmigoSorteado(emailAmigoSorteado);
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return this.mensagens;
    }

    public Map<Integer, Amigo> cadastrarAmigo(Amigo amigo) {
        Random generate = new Random();
        this.amigos.put(generate.nextInt(), amigo);
        return amigos;
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        Optional<Map.Entry<Integer, Amigo>> amigoEncontrado = amigos.entrySet().stream()
                .filter(amigo -> Objects.equals(amigo.getValue().getEmail(), email)).findFirst();
        if (amigoEncontrado.isEmpty()) {
            throw new AmigoInexistenteException("Amigo Inexistente");
        }
        return amigoEncontrado.get().getValue();
    }

    public void salvarMensagem(Mensagem mensagem) {
        this.mensagens.add(mensagem);
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)
            throws AmigoInexistenteException, AmigoNaoSorteadoException {
        Optional<Map.Entry<Integer, Amigo>> amigoFiltrado = amigos.entrySet().stream()
                .filter(amigo -> Objects.equals(amigo.getValue().getEmail(), emailDaPessoa)).findFirst();
        if (amigoFiltrado.isEmpty()) {
            throw new AmigoInexistenteException("Amigo Inexistente");
        }
        if (amigoFiltrado.get().getValue().getEmailAmigoSorteado() == null) {
            throw new AmigoNaoSorteadoException("Amigo Não Configurado");
        }
        Optional<Map.Entry<Integer, Amigo>> amigoSecreto = amigos.entrySet().stream().filter(amigo -> Objects
                .equals(amigo.getValue().getEmail(), amigoFiltrado.get().getValue().getEmailAmigoSorteado()))
                .findFirst();
        if (amigoSecreto.isEmpty()) {
            throw new AmigoInexistenteException("Amigo Secreto Inexistente");
        }
        return amigoSecreto.get().getValue().getNome();
    }

    public void sortear() {

    }
}
