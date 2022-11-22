package com.saullo;

abstract class Mensagem {

    private String texto;
    private String emailRemetente;
    private boolean anonima;

    public abstract String getTextoCompletoAExibir();

    public String getTexto() {
        return this.texto;
    }

    public String getEmailRemetente() {
        return this.emailRemetente;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }

    public boolean ehAnonima() {
        return this.anonima;
    }

    public Mensagem(String texto, String emailRemetente, boolean anonima) {
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonima = anonima;
    }
}
