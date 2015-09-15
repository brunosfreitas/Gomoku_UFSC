import java.util.Scanner;

public class IA extends Jogador{

    private Scanner inputJogada;
    private char peca;
    private Minimax minimax;
    
    
    public IA(){
        identificador = EnumTabuleiro.IA;
        minimax = new Minimax();
    }
    
    @Override
    boolean fazerJogada(){
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        inputJogada = new Scanner(System.in);

//        System.out.print("Digite o numero da linha:");	  
//        String linhaString = inputJogada.nextLine();
//        int linha = Integer.parseInt(linhaString);
//
//        System.out.print("Digite o numero da coluna:");
//        String colunaString = inputJogada.nextLine();
//        int coluna = Integer.parseInt(colunaString);
        double[] coord = minimax.minimax(tabuleiro, Integer.MAX_VALUE, Integer.MIN_VALUE, 5, identificador);


        tabuleiro.inserePeca((int)coord[1], (int)coord[2], this);
        return tabuleiro.verificarVitoria((int)coord[1], (int)coord[2], this);
      }
    
        
    @Override
    public void setPeca(char simbolo){
        this.peca = simbolo;
    }
    
    @Override
    public char getPeca(){
        return this.peca;
    }
}
