
public class Gomoku {

	public static void main(String[] args) {
			
		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.printTabuleiro();
		
		
		
		Jogador jogador = new Jogador();
		IA ia = new IA();
		
		jogador.jogada();
		tabuleiro.printTabuleiro();
		ia.jogada();
		tabuleiro.printTabuleiro();
		//tabuleiro.printTabuleiro();		
		//tabuleiro.verifica5DiagonalSentido1();	
		/*
		while(tabuleiro.fimDeJogo()){
			//tabuleiro.jogadaJogador1();
			//tabuleiro.verifica5Verticall();
			//tabuleiro.verifica5Horizontal();
			//tabuleiro.jogadaJogador2();
			//tabuleiro.verifica5Verticall();
			//tabuleiro.verifica5Horizontal();
			
		}*/
	}

}
