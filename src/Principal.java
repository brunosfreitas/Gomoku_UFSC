
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
		jogador.fazerJogada(tabuleiroDoJogo);
                tabuleiroDoJogo.printTabuleiroPecas();
//		jogador.tabuleiro.printTabuleiroPecas();
		//tabuleiro.printTabuleiro();
		ia.fazerJogada(tabuleiroDoJogo);
                tabuleiroDoJogo.printTabuleiroPecas();
//		ia.tabuleiro.printTabuleiroPecas();
		//tabuleiro.printTabuleiro();
	}

}
