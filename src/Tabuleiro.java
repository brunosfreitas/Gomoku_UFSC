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
	
//	Insere a peça do 'jogador' numa posicao do tabuleiroPecas
	public boolean inserePeca(int linha, int col, char jogador){
            if(this.existePeca(linha, col)){
                System.out.println("-> Ja existe uma peca nesta posicao!");
                return false;
            }
            if(jogador == 'x')
                    this.tabuleiroPecas[linha][col] = 'x';
            else 
                    this.tabuleiroPecas[linha][col] = 'o';
            
            this.setAmeaca(linha, col, this);
            this.printTabuleiroAmeaca();
            return true;
	}
        
//      Dado o exemplo na planilha, li = n & co = m.
//      Li e co sao as coordenadas da peca
        public void setAmeaca(int li, int co, Tabuleiro board){
            
//          i representa o numero de casas, ou seja, nao nao iremos
//          realizar o looping mais de 14x. O numero eh 14 pois 15 - uma peca ja inserida.
            int i = 1;
            int pos = 1;
            int neg = 1;
            while (i<14) {
//              Incrementacao Positiva
                if((co+pos) < 14){
                    if((4-pos) > 0)
                        board.tabuleiroAmeaca[li][co+pos] = 4-pos;
                    else
                        board.tabuleiroAmeaca[li][co+pos] = 0.1;
                }
                pos++;
                
//              Incrementacao Negativa
                if(co-neg > 0){
                    if((4-neg) > 0)
                        board.tabuleiroAmeaca[li][co-neg] = 4-neg;
                    else
                        board.tabuleiroAmeaca[li][co-neg] = 0.1;
                }
                neg--;
                
//              Incrementacao Horizontal
                   
                i++;
            }
        }
        
        
//      Método retorna a soma total dos campos de ameaça
        
        public double retornaEstado(Tabuleiro um, Tabuleiro dois){
            
            return 0;
        }
        
        
        /*Métodos de verificacao*/
        
//      Verifica se tem uma peca na coordenada dada.
        public boolean existePeca(int li, int co){
            return this.tabuleiroPecas[li][co] != '.';
        }
}