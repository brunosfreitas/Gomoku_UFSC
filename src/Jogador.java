import java.util.Scanner;

public class Jogador {	
	
//	Tabuleiro tabuleiro;
    private Scanner inputJogada;
    private char peca;
    public EnumTabuleiro identificador = EnumTabuleiro.JOGADOR;

    public Jogador(){
    }
    
    public void setPeca(char simbolo){
        this.peca = simbolo;
    }
    
    public char getPeca(){
        return this.peca;
    }
    
    public char getPecaInimigo(){
        return (this.getPeca() == 'x') ? 'o' : 'x';
    }

    boolean fazerJogada(){	  
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        inputJogada = new Scanner(System.in);
        boolean jogadaValida = false;
        int linha = 0, coluna = 0;
        
        while (!jogadaValida) {
            System.out.print("Digite o numero da linha:");	  
            String linhaString = inputJogada.nextLine();
            linha = Integer.parseInt(linhaString);

            System.out.print("Digite o numero da coluna:");
            String colunaString = inputJogada.nextLine();
            coluna = Integer.parseInt(colunaString);
            
            if (tabuleiro.existePeca(linha, coluna)) {
                System.out.println("\n Já existe uma peça nesta posição! \n Selecione outra coordenada.");
            } else
                jogadaValida = true;
        }

        tabuleiro.inserePeca(linha, coluna, this);
        return tabuleiro.verificarVitoria(linha, coluna, this);
    }
	
}
