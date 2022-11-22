package com.saullo;

public class AmigoInexistenteException extends Exception {
    private String text;

    public String getText() {
        return this.text;
    }

    public AmigoInexistenteException(String text) {
        super(text);
        this.text = text;
    }

}
