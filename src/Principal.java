
import java.util.Scanner;


/* Graduandos:
 * Bruno Freitas &
 * Rodrigo Pedro Marques.
 * 
 * Trabalho de Inteligência Artificial.
 * 
 * Este código é apenas um rascunho do trabalho.
 * A implementação aqui é mínima e com alguns bugs que serão corrigidos com o desenvolvimento do trabalho.
 */

public class Principal {

    public static void main(String[] args) {

        Tabuleiro tabuleiroDoJogo = new Tabuleiro();
        Jogador jogador = new Jogador();
        IA ia = new IA();
        Scanner input = new Scanner(System.in);
        boolean selecao = false;
        
        while (selecao == false) {
            System.out.print("Você quer ser 'x' ou 'o'?");	  
            String linhaString = input.nextLine();
            
            char peca = linhaString.charAt(0);
            if (peca == 'x') {
                jogador.setPeca('x');
                ia.setPeca('o');
                selecao = true;
            } else {
                if (peca == 'o'){
                    jogador.setPeca('o');
                    ia.setPeca('x');
                    selecao = true;
                }
            }
        }
        
        jogador.fazerJogada(tabuleiroDoJogo);
        tabuleiroDoJogo.printTabuleiroPecas();

        ia.fazerJogada(tabuleiroDoJogo);
        tabuleiroDoJogo.printTabuleiroPecas();
	}

}
