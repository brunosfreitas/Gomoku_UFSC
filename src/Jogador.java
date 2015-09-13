import java.util.Scanner;

public class Jogador {	
	
//	Tabuleiro tabuleiro;
    Tabuleiro tabuleiroAmeaca;
    private Scanner inputJogada;

    public Jogador(){
        tabuleiroAmeaca = new Tabuleiro();
    }

    void fazerJogada(Tabuleiro tabuleiroDoJogo){	  
        inputJogada = new Scanner(System.in);

        System.out.print("Digite o numero da linha:");	  
        String linhaString = inputJogada.nextLine();
        int linha = Integer.parseInt(linhaString);

        System.out.print("Digite o numero da coluna:");
        String colunaString = inputJogada.nextLine();
        int coluna = Integer.parseInt(colunaString);

        tabuleiroDoJogo.inserePeca(linha, coluna, 'x');
//      tabuleiro.inserePeca(linha, coluna, 'x'); 
      }
	
}
