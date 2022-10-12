package Exercicio3POO.src;
public class AmigoInexistenteException extends Exception {
    private String text;
    public String getText(){
        return this.text;
    }

    public AmigoInexistenteException(String text){
        super(text);
        this.text = text;
    }

}
