
import java.util.Scanner;


/* Graduandos:
 * Bruno Freitas 09232005&
 * Rodrigo Pedro Marques 12200660.
 * 
 * Trabalho de Inteligência Artificial.
 * 
 * Este código é apenas um rascunho do trabalho.
 * A implementação aqui é mínima e com alguns bugs que serão corrigidos com o desenvolvimento do trabalho.
 */

public class Principal {

    public static void main(String[] args) {

        Tabuleiro tabuleiroDoJogo = Tabuleiro.getInstance();
        Jogador jogador = new Jogador();
        IA ia = new IA();
        Scanner input = new Scanner(System.in);
        
        boolean selecao = false;
        boolean iaInicia = true;
        
        while (!selecao) {
            System.out.print("Você quer ser 'x' ou 'o'?");
            String linhaString = input.nextLine();

            char peca = linhaString.charAt(0);
            if (peca == 'x') {
                jogador.setPeca('x');
                ia.setPeca('o');
                selecao = true;
            } else {
                if (peca == 'o') {
                    jogador.setPeca('o');
                    ia.setPeca('x');
                    selecao = true;
                }
            }
        }

        selecao = false;
        int turnoDoJogador = 0;
        while (!selecao) {
            System.out.println("\nQuem começará:\n1) Computador. \n2) Eu.");
            String iniciacao_aux = input.nextLine();
            turnoDoJogador = Integer.parseInt(iniciacao_aux);
            
            if (turnoDoJogador == 1 || turnoDoJogador == 2) {
                selecao = true;
            } else{
                System.out.println("\nSelecione uma opção válida.");
            }
        }
        
        boolean vitoria5emLinha = false;
        
        while (!vitoria5emLinha) {
            if (turnoDoJogador == 1){
                vitoria5emLinha = ia.fazerJogada();
                tabuleiroDoJogo.printTabuleiroPecas();
                System.out.println("Utilidade - Pontuacao Total = " + tabuleiroDoJogo.getSomaAmeaca());

                if(vitoria5emLinha){
                    System.out.println("Vitoria da IA!");
                }
                
                turnoDoJogador = 2;
            }else{
                vitoria5emLinha = jogador.fazerJogada();
                tabuleiroDoJogo.printTabuleiroPecas();
                System.out.println("Utilidade - Pontuacao Total = " + tabuleiroDoJogo.getSomaAmeaca());

                if(vitoria5emLinha){
                    System.out.println("Vitoria do Jogador!");
                }
                
                turnoDoJogador = 1;
            }
        }
        
        
        System.out.println("\n ~~~~ Shutting down system ~~~~");
        System.exit(0);
}
}


