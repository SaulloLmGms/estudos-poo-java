## Questões

1. Quantas threads são iniciadas pelo programa mostrado na classe TestaConcorrencia? Quais variáveis
representam estas threads?
  - 3, as variáveis são t1, t2, t3

2. Considerando uma possível execução do main da classe TestaConcorrencia, transcreva o que será
impresso na tela nessa execução.
  ```shell
    O valor1 de cont é:0
    TA:Vou incrementar contador...
    TB:Vou decrementar contador...
    O valor2 de cont é:0
    TB:Valor do contador:0
    TA:Valor do contador:0
    TB:Vou decrementar contador...
    TB:Valor do contador:-1
    O valor final de cont é:-1
  ```

3. Os blocos synchronized da classe Contador são necessários? Justifique.
    - Sim, se os remover o contador irá seguir outra ordem de execução.
   
4. Faça um teste JUnit que crie uma thread TA com um contador e ao final verifique se o valor do
contador está correto após o fim da execução de TA. `Feito`

5. Qual seria uma implementação alternativa de TA ao invés de estender da classe Thread? Aponte uma
vantagem ou desvantagem dessa outra implementação?
  - Poderia usar uma classe anônima do tipo Runnable, passando-a como parametro no contrutor Thread.
  - Exemplo: 
    ```java 
    public class Programa {
      public static void main(String[] args) {
        
        Runnable buscandoArquivo = new Runnable() {			
          @Override
          public void run() {
            for(int i = 0 ; i < 2000; i++) {
              System.out.println("Buscando um arquivo");
            }				
          }
        };
        Thread th1 = new Thread(buscandoArquivo);
        th1.start();
        
        Runnable lendoArquivo = new Runnable() {			
          @Override
          public void run() {
            for(int i = 0 ; i < 2000; i++) {
              System.out.println("Lendo um arquivo");
            }				
          }
        };
        Thread th2 = new Thread(lendoArquivo);
        th2.start();
      }
    }
    ```
  - Vantagem: 
  - Desvantagem: 