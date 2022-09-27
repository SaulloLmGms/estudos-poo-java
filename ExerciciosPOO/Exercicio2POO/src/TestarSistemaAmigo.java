public class TestarSistemaAmigo {
  public static void main(String[] args) {
    //a) Cadastre dois amigos José e Maria com seus e-mails.
    Amigo jose = new Amigo();
    jose.setEmail("jose@email.com");
    jose.setNome("José");

    Amigo maria = new Amigo();
    maria.setEmail("maria@email.com");
    maria.setNome("Maria");

    SistemaAmigo sistemaAmigo = new SistemaAmigo();
    sistemaAmigo.cadastrarAmigo(jose);
    sistemaAmigo.cadastrarAmigo(maria);


    //b) Configure o amigo secreto de José como sendo Maria e o amigo secreto de Maria como sendo José. Obs: Lembre de tratar a exceção que pode ser lançada.
    try {
      sistemaAmigo.configuraAmigoSecretoDe(jose.getEmail(), maria.getEmail());
      sistemaAmigo.configuraAmigoSecretoDe(maria.getEmail(), jose.getEmail());
    } catch(Exception error) {
      System.out.println(error);
    }
    // c) Envie uma mensagem anônima de Maria para José.
    MensagemParaAlguem enviParaAlguem = new MensagemParaAlguem("Olá José. Case comigo!", jose.getEmail(), maria.getEmail(), true);
    sistemaAmigo.salvarMensagem(enviParaAlguem);
    System.out.println(enviParaAlguem.getTextoCompletoAExibir());

    //d) Envie uma mensagem anônima de Maria para todos.
    for(Amigo amigo : sistemaAmigo.getAmigos()) {
      if (amigo.getEmail() != maria.getEmail()) {
        
        MensagemParaAlguem enviarParaTodos = new MensagemParaAlguem("Olá meus amigos. Votem em mim!", amigo.getEmail(), maria.getEmail(), true);
        sistemaAmigo.salvarMensagem(enviarParaTodos);
        System.out.println(enviarParaTodos.getTextoCompletoAExibir());
      } else {
        System.out.println("Email remetente igual a destinatário. Operação inválida.");
      }
    }

    //e) Pesquise as mensagens anônimas e imprima o texto completo dessas mensagens através do método getTextoCompletoAExibir.
    for(Mensagem msg : sistemaAmigo.getMensagens()) {
      if (msg.ehAnonima()) {
        System.out.println(msg.getTextoCompletoAExibir());
      }
    }
    //f) Pesquise o e-mail do amigo secreto de José e veja se é o e-mail de Maria, imprimindo “Ok” caso seja.
    if(jose.getEmailAmigoSorteado() == maria.getEmail()) {
      System.out.println("Ok");
    }
  }
  
}
