import java.util.Scanner;

public class IA extends Jogador{
	
	Tabuleiro tabuleiro;
	private Scanner inputJogada;
	
	public IA(){
		tabuleiro = new Tabuleiro();
	}
	/*
	void jogada(){		  
		inputJogada = new Scanner(System.in);
		  System.out.print("Digite o numero da linha:");	  
		  String linhaString = inputJogada.nextLine();
		  int linha = Integer.parseInt(linhaString);
		  System.out.print("Digite o numero da coluna:");
		  String colunaString = inputJogada.nextLine();
		  int coluna = Integer.parseInt(colunaString);
		  
		  tabuleiro.marcaJogadaO(linha, coluna);
	  }
	  */
	
	void jogada(){		  
		inputJogada = new Scanner(System.in);
		  System.out.print("Digite o numero da linha:");	  
		  String linhaString = inputJogada.nextLine();
		  int linha = Integer.parseInt(linhaString);
		  System.out.print("Digite o numero da coluna:");
		  String colunaString = inputJogada.nextLine();
		  int coluna = Integer.parseInt(colunaString);
		  
		  tabuleiro.set(linha, coluna, 'o');
	  }
}
