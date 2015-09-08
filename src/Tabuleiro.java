import java.util.Arrays;

public class Tabuleiro {
	
	char[][] tabuleiro;
	final int dimensao = 15;
	
	public Tabuleiro(){
		this.tabuleiro = new char[this.dimensao][this.dimensao];
		
		// Iniciar o tabuleiro com pontos que irao representar as interseccoes das linhas
		for(int li=0; li < this.dimensao; li++){
			for (int co = 0; co < this.dimensao; co++){
				this.tabuleiro[li][co] = '.';
			}
		}
	}
	
	public void printTabuleiro(){
		for (int i = 0; i < this.dimensao; i++) {
		    for (int j = 0; j < this.dimensao; j++) {
		        System.out.print(this.tabuleiro[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
	
	//Insere a peça do 'jogador' numa posicao do tabuleiro
	//Nao esquecer de criar uma verificacao de ocupacao da casa
	public void inserePeca(int linha, int col, char jogador){
		if(jogador == 'x')
			this.tabuleiro[linha][col] = 'x';
		else 
			this.tabuleiro[linha][col] = 'o';
	}
}