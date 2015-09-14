import java.util.Arrays;
import java.util.Scanner;

public class Tabuleiro {
    
        //Singleton
        private static Tabuleiro instance;
	
	public char[][] tabuleiroPecas;
        public double[][] tabuleiroAmeacaJogador;
        public double[][] tabuleiroAmeacaIA;
	public final int dimensao = 15;
	
	private Tabuleiro(){
		this.tabuleiroPecas = new char[this.dimensao][this.dimensao];
                this.tabuleiroAmeacaJogador = new double[this.dimensao][this.dimensao];
                this.tabuleiroAmeacaIA = new double[this.dimensao][this.dimensao];
		
//		Iniciar o tabuleiroPecas com pontos que irao representar as interseccoes das linhas
		for(int li=0; li < this.dimensao; li++){
			for (int co = 0; co < this.dimensao; co++){
				this.tabuleiroPecas[li][co] = '.';
                                this.tabuleiroAmeacaJogador[li][co] = 0;
                                this.tabuleiroAmeacaIA[li][co] = 0;
			}
		}
	}
        
        public static Tabuleiro getInstance(){
            if(instance == null)
                instance = new Tabuleiro();
            return instance;
        }
	
	public void printTabuleiroPecas(){
		for (int i = 0; i < this.dimensao; i++) {
		    for (int j = 0; j < this.dimensao; j++) {
		        System.out.print(this.tabuleiroPecas[i][j] + " ");
		    }
		    System.out.print("\n");
		}
	}
        
        public void printTabuleiroAmeaca(){
            for (int i = 0; i < this.dimensao; i++) {
                for (int j = 0; j < this.dimensao; j++) {
                    System.out.print(this.tabuleiroAmeacaJogador[i][j] - this.tabuleiroAmeacaIA[i][j] + " ");
                }
                System.out.print("\n");
            }
	}
	
//	Insere a peça do jogador numa posicao do tabuleiroPecas
	public boolean inserePeca(int linha, int col, Jogador player){
            if(this.existePeca(linha, col)){
                System.out.println("\n-> Ja existe uma peca nesta posicao!");
                return false;
            }
            if(player.getPeca() == 'x')
                    this.tabuleiroPecas[linha][col] = 'x';
            else 
                    this.tabuleiroPecas[linha][col] = 'o';
            
            this.setAmeaca(linha, col, player);
            this.printTabuleiroAmeaca();
            return true;
	}
        
        
        public void setAmeaca(int linha, int coluna, Jogador player){
//          Dado o exemplo na planilha, n = li & m = co.
//          li e co sao as coordenadas da peca
            
            //Singleton
            Tabuleiro tabuleiro = Tabuleiro.getInstance();
            
//          deslocamento representa o numero de casas a percorrer. O numero eh 14 pois 15 - uma peca ja inserida.
            int deslocamento = 1;
            int pontuacaoLocal = 7;
            
            while (deslocamento<=7) {
                
                //Oeste
                try{
                   tabuleiro.adicionarAmeaça(linha, coluna-deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Leste
                try{
                   tabuleiro.adicionarAmeaça(linha, coluna+deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Norte
                try{
                   tabuleiro.adicionarAmeaça(linha-deslocamento, coluna, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Sul
                try{
                   tabuleiro.adicionarAmeaça(linha+deslocamento, coluna, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Norte - Oeste
                try{
                   tabuleiro.adicionarAmeaça(linha-deslocamento, coluna-deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Norte - Leste
                try{
                   tabuleiro.adicionarAmeaça(linha-deslocamento, coluna+deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Sul - Lestex
                try{
                   tabuleiro.adicionarAmeaça(linha+deslocamento, coluna+deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                //Sul - Oeste
                try{
                   tabuleiro.adicionarAmeaça(linha+deslocamento, coluna-deslocamento, player, pontuacaoLocal);
                }catch(Exception e){      
                }
                
                pontuacaoLocal--;
                deslocamento++;
            }
        }
        
        public void adicionarAmeaça(int linha, int coluna, Jogador player, double valor){
            //Singleton
            Tabuleiro tabuleiro = Tabuleiro.getInstance();
            
            if(player.identificador == EnumTabuleiro.IA){
                tabuleiro.tabuleiroAmeacaIA[linha][coluna] = tabuleiro.tabuleiroAmeacaIA[linha][coluna] + valor;
            }else{
                tabuleiro.tabuleiroAmeacaJogador[linha][coluna] = tabuleiro.tabuleiroAmeacaJogador[linha][coluna] + valor;
            }
            
        }
        
//      Retorna a soma total do tabuleiro de ameaca
        public double getSomaAmeaca(){
            double soma = 0;
            Tabuleiro tabuleiro = Tabuleiro.getInstance();

            for (int li = 0; li < 14; li++) {
                for (int co = 0; co < 14; co++) {
                    soma += tabuleiro.tabuleiroAmeacaIA[li][co] - tabuleiro.tabuleiroAmeacaJogador[li][co];
                }
            }
            return soma;
        }
          
        /*Métodos de verificacao*/
        
//      Verifica se tem uma peca na coordenada dada.
        public boolean existePeca(int li, int co){
            return this.tabuleiroPecas[li][co] != '.';
        }
}