import java.util.Scanner;

public class Jogador {	
	
	Tabuleiro tabuleiro;
	private Scanner inputJogada;
	
	public Jogador(){
		tabuleiro = new Tabuleiro();
	}

	void fazerJogada(){	  
		  inputJogada = new Scanner(System.in);
		  
		  System.out.print("Digite o numero da linha:");	  
		  String linhaString = inputJogada.nextLine();
		  int linha = Integer.parseInt(linhaString);
		  
		  System.out.print("Digite o numero da coluna:");
		  String colunaString = inputJogada.nextLine();
		  int coluna = Integer.parseInt(colunaString);
		  
		  tabuleiro.inserePeca(linha, coluna, 'x'); 
	  }
	
}
