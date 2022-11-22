package com.saullo;

public class AmigoNaoSorteadoException extends Exception {
    private String text;

    public String getText() {
        return this.text;
    }

    public AmigoNaoSorteadoException(String text) {
        super(text);
        this.text = text;
    }

}
