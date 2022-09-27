import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class TestaSistemaAmigoGUI {
  
  public static void main(String[] args) {
    List<Amigo> amigos = new ArrayList<>();
    //a) Leia a quantidade máxima de mensagens que o sistema suporta (pode usar JOptionPane), inicializando com este valor a variável do tipo SistemaAmigo.
    SistemaAmigo sistemaAmigo = new SistemaAmigo();


    MensagemParaAlguem enviParaAlguem = new MensagemParaAlguem("Olá. Tudo bem?!", "meu@email.com", "outro@email.com", true);
    sistemaAmigo.salvarMensagem(enviParaAlguem);
    sistemaAmigo.salvarMensagem(enviParaAlguem);
    sistemaAmigo.salvarMensagem(enviParaAlguem);
    String mensagens = "";
    for(Mensagem msg : sistemaAmigo.getMensagens()) {
      mensagens += msg.getTexto() +  "\n";
    }
    JOptionPane.showMessageDialog(null, mensagens, "Lista de mensagens", 2);
    //b) Leia a quantidade total de amigos a participar da brincadeira
    Amigo jose = new Amigo();
    jose.setEmail("jose@email.com");
    jose.setNome("José");
    amigos.add((jose));

    Amigo maria = new Amigo();
    maria.setEmail("maria@email.com");
    maria.setNome("Maria");
    amigos.add(maria);

    JOptionPane.showMessageDialog(null, amigos.toArray().length, "Quantidade de amigos", 3);
    //c) Leia os dados (nome e e-mail) de cada um dos amigos e os cadastre.
    String infoAmigos = "";
    for(Amigo info : amigos) {
      infoAmigos += "Nome: " + info.getNome() + "  - Email: "  + info.getEmail() + "\n";
      sistemaAmigo.cadastrarAmigo(info);

    }
    JOptionPane.showMessageDialog(null, infoAmigos, "Informações de amigos", 3);

    //d) Cadastre os resultados do sorteio dos amigos secretos (diga quem pegou quem).

    //Confirgurar amigo secreto
     try {
      sistemaAmigo.configuraAmigoSecretoDe(jose.getEmail(), maria.getEmail());
      sistemaAmigo.configuraAmigoSecretoDe(maria.getEmail(), jose.getEmail());
    } catch(Exception error) {
      System.out.println(error);
    }
    String sorteio = "";
    try {
      for(Amigo friend : sistemaAmigo.getAmigos()) {
        String nomeAmigo = sistemaAmigo.pesquisaAmigoSecretoDe(friend.getEmail());
        sorteio += friend.getNome() + " pegou " + nomeAmigo + " como amigo secreto. \n";
      }
    } catch(Exception error) {
      System.out.println(error);
    }
    JOptionPane.showMessageDialog(null, sorteio, "Resultado do sorteio", 3);

    //e) Envie uma mensagem de algum dos amigos para todos, coletando para isso os dados necessários (ex: remetente, texto, se a mensagem é anônima ou não).

    int numeroSorteado = (int) (Math.random() * amigos.toArray().length);
    Amigo amigoSorteado = amigos.get(numeroSorteado);
    for(Amigo amigo : sistemaAmigo.getAmigos()) {
      if (amigo.getEmail() != amigoSorteado.getEmail()) {
        
        MensagemParaAlguem enviarParaTodos = new MensagemParaAlguem("Olá meu amigo. Votem em mim!", amigo.getEmail(), amigoSorteado.getEmail(), true);
        sistemaAmigo.salvarMensagem(enviarParaTodos);
        JOptionPane.showMessageDialog(null, enviarParaTodos.getTextoCompletoAExibir(), "Texto da mensagem enviada:", 2);

      } else {
        System.out.println("Email remetente igual a destinatário. Operação inválida.");
      }
    }
  }
  
}
