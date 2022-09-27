public class MensagemParaAlguem extends Mensagem {
    private String emailDestinatario;

    public String getEmailDestinatario(){
        return this.emailDestinatario;
    }

    public MensagemParaAlguem(String texto, String emailDestinatario, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }
    public String getTextoCompletoAExibir() {
        return "Mensagem de: " + super.getEmailRemetente() + " Para: " + this.emailDestinatario + ". Texto: " + super.getTexto();
    }

}