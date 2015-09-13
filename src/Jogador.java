import java.util.Scanner;

public class Jogador {	
	
//	Tabuleiro tabuleiro;
    Tabuleiro tabuleiroAmeaca;
    private Scanner inputJogada;
    private char peca;

    public Jogador(){
        tabuleiroAmeaca = new Tabuleiro();
    }
    
    public void setPeca(char simbolo){
        this.peca = simbolo;
    }

    void fazerJogada(Tabuleiro tabuleiroDoJogo){	  
        inputJogada = new Scanner(System.in);

        System.out.print("Digite o numero da linha:");	  
        String linhaString = inputJogada.nextLine();
        int linha = Integer.parseInt(linhaString);

        System.out.print("Digite o numero da coluna:");
        String colunaString = inputJogada.nextLine();
        int coluna = Integer.parseInt(colunaString);

        tabuleiroDoJogo.inserePeca(linha, coluna, this.peca);
//      tabuleiro.inserePeca(linha, coluna, 'x'); 
      }
	
}
