
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

//        Por algum diabo ele esta saindo do while mesmo colocando algo invalido
        while (selecao == false) {
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

        boolean vitoria5emLinha = false;

        while (!vitoria5emLinha) {
            vitoria5emLinha = jogador.fazerJogada();
            tabuleiroDoJogo.printTabuleiroPecas();
            System.out.println("Utilidade - Pontuacao Total = " + tabuleiroDoJogo.getSomaAmeaca());
            
            if(vitoria5emLinha){
                System.out.println("Vitoria do Jogador!");
                
            }
            
            vitoria5emLinha = ia.fazerJogada();
            tabuleiroDoJogo.printTabuleiroPecas();
            tabuleiroDoJogo.getSomaAmeaca();
            System.out.println("Utilidade - Pontuacao Total = " + tabuleiroDoJogo.getSomaAmeaca());
            
            if(vitoria5emLinha){
                System.out.println("Vitoria da IA!");
                
            }

    }
}
}


