import java.util.Scanner;

public class IA extends Jogador{
	
//	Tabuleiro tabuleiro;
    Tabuleiro tabuleiroAmeaca;
    private Scanner inputJogada;

    public IA(){
        tabuleiroAmeaca = new Tabuleiro();
    }

    @Override
    void fazerJogada(Tabuleiro tabuleiroDoJogo){		  
        inputJogada = new Scanner(System.in);

          System.out.print("Digite o numero da linha:");	  
          String linhaString = inputJogada.nextLine();
          int linha = Integer.parseInt(linhaString);

          System.out.print("Digite o numero da coluna:");
          String colunaString = inputJogada.nextLine();
          int coluna = Integer.parseInt(colunaString);

          tabuleiroDoJogo.inserePeca(linha, coluna, 'o');
//		  tabuleiro.inserePeca(linha, coluna, 'o');
      }
}
