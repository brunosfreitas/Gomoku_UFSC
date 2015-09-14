import java.util.Scanner;

public class Jogador {	
	
//	Tabuleiro tabuleiro;
    private Scanner inputJogada;
    private char peca;
    public int identificador = 111;

    public Jogador(){
    }
    
    public void setPeca(char simbolo){
        this.peca = simbolo;
    }
    
    public char getPeca(){
        return this.peca;
    }

    void fazerJogada(){	  
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        inputJogada = new Scanner(System.in);

        System.out.print("Digite o numero da linha:");	  
        String linhaString = inputJogada.nextLine();
        int linha = Integer.parseInt(linhaString);

        System.out.print("Digite o numero da coluna:");
        String colunaString = inputJogada.nextLine();
        int coluna = Integer.parseInt(colunaString);

        tabuleiro.inserePeca(linha, coluna, this);
      }
	
}
