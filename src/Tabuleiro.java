import java.util.Arrays;

public class Tabuleiro {
	
	char[][] tabuleiroPecas;
        double[][] tabuleiroAmeaca;
	final int dimensao = 15;
	
	public Tabuleiro(){
		this.tabuleiroPecas = new char[this.dimensao][this.dimensao];
		
//		Iniciar o tabuleiroPecas com pontos que irao representar as interseccoes das linhas
		for(int li=0; li < this.dimensao; li++){
			for (int co = 0; co < this.dimensao; co++){
				this.tabuleiroPecas[li][co] = '.';
			}
		}
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
                    System.out.print(this.tabuleiroAmeaca[i][j] + " ");
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
        
        
        public void setAmeaca(int li, int co, Jogador player){
//          Dado o exemplo na planilha, n = li & m = co.
//          li e co sao as coordenadas da peca
            
//          i representa o numero de casas a percorrer. O numero eh 14 pois 15 - uma peca ja inserida.
            int i = 0;
            int var = 1;
            
            while (i<7) {
                
//                Pra cima
                if ((li - var) > 0) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co] = player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co] + (5-var);
                }
                
//                Pra baixo
                if ((li + var) < 14) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li+var][co] = player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co+var] + (5-var);
                }
                
//                pra esquerda
                if ((co - var) > 0) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li][co-var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li][co-var] + (5-var);
                }
                
//                pra direita
                if ((co + var) < 14) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li][co+var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li][co+var] + (5-var);
                }
                
//                diagonal superior esquerda
                if ((li - var) > 0 && (co - var) > 0) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co-var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co-var] + (5-var);
                }
                
//                diagonal superior direita
                if ((li - var) > 0 && (co + var) < 14) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co+var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li-var][co+var] + (5-var);
                }
                
//                diagonal inferior esquerda
                if ((li + var) < 14 && (co - var) > 0) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li+var][co-var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li+var][co-var] + (5-var);
                }
                
//                diagonal inferior direita
                if ((li + var) < 14 && (co + var) < 14) {
                    player.tabuleiroAmeaca.tabuleiroAmeaca[li+var][co+var] = player.tabuleiroAmeaca.tabuleiroAmeaca[li+var][co+var] + (5-var);
                }                
                
                var++;
                i++;
            }
        }
        
//      Retorna a soma total do tabuleiro de ameaca
        public double getSomaAmeaca(Tabuleiro board){
            double soma = 0;
            for (int li = 0; li < 14; li++) {
                for (int co = 0; co < 14; co++) {
                    soma += board.tabuleiroAmeaca[li][co];
                }
            }
            return soma;
        }
        
//      Método retorna a soma total dos campos de ameaça (n sei se vai ser util pra algo rsrs)
        public double getSomaAmbasAmeacas(Tabuleiro um, Tabuleiro dois){
            return um.getSomaAmeaca(um) + dois.getSomaAmeaca(dois);
        }
        
        /*Métodos de verificacao*/
        
//      Verifica se tem uma peca na coordenada dada.
        public boolean existePeca(int li, int co){
            return this.tabuleiroPecas[li][co] != '.';
        }
}