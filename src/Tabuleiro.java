import java.util.ArrayList;

public class Tabuleiro {

    //Singleton
    private static Tabuleiro instance;

    public char[][] tabuleiroPecas;
    public double[][] tabuleiroAmeacaJogador;
    public double[][] tabuleiroAmeacaIA;
    public final int dimensao = 15;
    
    private Tabuleiro() {
        this.tabuleiroPecas = new char[this.dimensao][this.dimensao];
        this.tabuleiroAmeacaJogador = new double[this.dimensao][this.dimensao];
        this.tabuleiroAmeacaIA = new double[this.dimensao][this.dimensao];

//		Iniciar o tabuleiroPecas com pontos que irao representar as interseccoes das linhas
        for (int li = 0; li < this.dimensao; li++) {
            for (int co = 0; co < this.dimensao; co++) {
                this.tabuleiroPecas[li][co] = '.';
                this.tabuleiroAmeacaJogador[li][co] = 0;
                this.tabuleiroAmeacaIA[li][co] = 0;
            }
        }
    }

    public static Tabuleiro getInstance() {
        if (instance == null) {
            instance = new Tabuleiro();
        }
        return instance;
    }

    public void printTabuleiroPecas() {
        for (int i = 0; i < this.dimensao; i++) {
            for (int j = 0; j < this.dimensao; j++) {
                System.out.print(this.tabuleiroPecas[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void printTabuleiroAmeaca() {
        for (int i = 0; i < this.dimensao; i++) {
            for (int j = 0; j < this.dimensao; j++) {
                System.out.print(this.tabuleiroAmeacaIA[i][j] - this.tabuleiroAmeacaJogador[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

//	Insere a peça do jogador numa posicao do tabuleiroPecas
    public boolean inserePeca(int linha, int col, Jogador player) {
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        
        if (tabuleiro.existePeca(linha, col)) {
            System.out.println("\n-> Ja existe uma peca nesta posicao!");
            return false;
        }
        if (player.getPeca() == 'x') {
            tabuleiro.tabuleiroPecas[linha][col] = 'x';
        } else {
            tabuleiro.tabuleiroPecas[linha][col] = 'o';
        }

        this.setAmeaca(linha, col, player);
        this.printTabuleiroAmeaca();
        return true;
    }

    
    
    public void setAmeaca(int linha, int coluna, Jogador player) {

        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        //Peça do inimigo
        char pecaInimigo = (player.getPeca() == 'x') ? 'o' : 'x';

//      deslocamento representa o numero de casas a percorrer. O numero eh 14 pois 15 - uma peca ja inserida.
        int deslocamento = 1;
        int pontuacaoLocal = 7;

        // Se uma peça estiver bloqueando, a pontuacao nao se perpetua mais
        boolean caminhoLivreNorte = true;
        boolean caminhoLivreSul = true;
        boolean caminhoLivreLeste = true;
        boolean caminhoLivreOeste = true;

        boolean caminhoLivreNorteLeste = true;
        boolean caminhoLivreNorteOeste = true;
        boolean caminhoLivreSulLeste = true;
        boolean caminhoLivreSulOeste = true;
        
        // Além disto a pontuação da peça que já estava lá deve ser retirada. @TODO
//        int bloqueios = 0;
//        int[][][] pecasInimigasEncontradas = new int[8][1][]; 

        //Zera o local da peça colocada
        this.tabuleiroAmeacaJogador[linha][coluna] = 0;
        this.tabuleiroAmeacaIA[linha][coluna] = 0;

        while (deslocamento <= 7) {

            //Oeste
            try {
                System.out.println(tabuleiro.tabuleiroPecas[linha][coluna - deslocamento]);
                if (tabuleiro.tabuleiroPecas[linha][coluna - deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha][coluna - deslocamento] = pontuacaoLocal; 
                    caminhoLivreOeste = false;
                }

                if (caminhoLivreOeste) {
                    tabuleiro.adicionarAmeaça(linha, coluna - deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha][coluna + deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha][coluna + deslocamento] = pontuacaoLocal; 
                    caminhoLivreLeste = false;
                }

                if (caminhoLivreLeste) {
                    tabuleiro.adicionarAmeaça(linha, coluna + deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Norte
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha - deslocamento][coluna] = pontuacaoLocal; 
                    caminhoLivreNorte = false;
                }

                if (caminhoLivreNorte) {
                    tabuleiro.adicionarAmeaça(linha - deslocamento, coluna, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Sul
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha + deslocamento][coluna] = pontuacaoLocal; 
                    caminhoLivreSul = false;
                }

                if (caminhoLivreSul) {
                    tabuleiro.adicionarAmeaça(linha + deslocamento, coluna, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Norte - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna - deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha - deslocamento][coluna - deslocamento] = pontuacaoLocal; 
                    caminhoLivreNorteOeste = false;
                }

                if (caminhoLivreNorteOeste) {
                    tabuleiro.adicionarAmeaça(linha - deslocamento, coluna - deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Norte - Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna + deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha - deslocamento][coluna + deslocamento] = pontuacaoLocal; 
                    caminhoLivreNorteLeste = false;
                }

                if (caminhoLivreNorteLeste) {
                    tabuleiro.adicionarAmeaça(linha - deslocamento, coluna + deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Sul - Lestex
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna + deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha + deslocamento][coluna + deslocamento] = pontuacaoLocal; 
                    caminhoLivreSulLeste = false;
                }

                if (caminhoLivreSulLeste) {
                    tabuleiro.adicionarAmeaça(linha + deslocamento, coluna + deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            //Sul - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna - deslocamento] == pecaInimigo) {
                    //@TODO pecasInimigasEncontradas[bloqueios][linha + deslocamento][coluna - deslocamento] = pontuacaoLocal; 
                    caminhoLivreSulOeste = false;
                }

                if (caminhoLivreSulOeste) {
                    tabuleiro.adicionarAmeaça(linha + deslocamento, coluna - deslocamento, player, pontuacaoLocal);
                }
            } catch (Exception e) {
            }

            pontuacaoLocal--;
            deslocamento++;
        }
        
        
    }
    
    public boolean verificarVitoria(int linha, int coluna, Jogador player){
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        
        //Peça do inimigo
        char pecaAliada = player.getPeca();
        
        int deslocamento = 1;
        
        int alinhadoOeste = 0;
        int alinhadoLeste = 0;
        int alinhadoNorte = 0;
        int alinhadoSul = 0;
        
        int alinhadoNorteOeste = 0;
        int alinhadoNorteLeste = 0;
        int alinhadoSulOeste = 0;
        int alinhadoSulLeste = 0;
        
        while (deslocamento <= 4) {
            
            //Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha][coluna - deslocamento] == pecaAliada) {
                    alinhadoOeste++;
                }else{
                    alinhadoOeste=0;
                }
            } catch (Exception e) {
            }

            //Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha][coluna + deslocamento] == pecaAliada) {
                    alinhadoLeste++;
                }else{
                    alinhadoLeste=0;
                }
            } catch (Exception e) {
            }

            //Norte
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna] == pecaAliada) {
                    alinhadoNorte++;
                }else{
                    alinhadoNorte=0;
                }
            } catch (Exception e) {
            }

            //Sul
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna] == pecaAliada) {
                    alinhadoSul++;
                }else{
                    alinhadoSul=0;
                }
            } catch (Exception e) {
            }

            //Norte - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna - deslocamento] == pecaAliada) {
                    alinhadoNorteOeste++;
                }else{
                    alinhadoNorteOeste=0;
                }
            } catch (Exception e) {
            }

            //Norte - Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna + deslocamento] == pecaAliada) {
                    alinhadoNorteLeste++;
                }else{
                    alinhadoNorteLeste=0;
                }
            } catch (Exception e) {
            }

            //Sul - Lestex
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna + deslocamento] == pecaAliada) {
                    alinhadoSulLeste++;
                }else{
                    alinhadoSulLeste=0;
                }
            } catch (Exception e) {
            }

            //Sul - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna - deslocamento] == pecaAliada) {
                    alinhadoSulOeste++;
                }else{
                    alinhadoSulOeste=0;
                }
            } catch (Exception e) {
            }

            deslocamento++;
        
        }
        
        if(alinhadoNorte == 4 || alinhadoSul == 4 || alinhadoLeste == 4 || alinhadoOeste == 4 ||
                alinhadoNorteLeste == 4 || alinhadoNorteOeste == 4 || alinhadoSulLeste == 4 || alinhadoSulOeste == 4){
            return true;
        }
        return false;     
    }

    // Verifica qual o jogador e coloca a ameaca no seu respectivo tabuleiro
    public void adicionarAmeaça(int linha, int coluna, Jogador player, double valor) {
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        if (player.identificador == EnumTabuleiro.IA) {
            tabuleiro.tabuleiroAmeacaIA[linha][coluna] = tabuleiro.tabuleiroAmeacaIA[linha][coluna] + valor;
        } else {
            tabuleiro.tabuleiroAmeacaJogador[linha][coluna] = tabuleiro.tabuleiroAmeacaJogador[linha][coluna] + valor;
        }
    }

//    int[0] = linha; int[1] = coluna;
    public int[] getCoordMaiorValor(Tabuleiro board, Jogador player){
        double maiorValor = 0;
        int[] coord = {99, 99};
        
        if (player.identificador == EnumTabuleiro.IA) {
            for (int i = 0; i < this.dimensao; i++) {
                for (int j = 0; j < this.dimensao; j++) {
                    if (board.tabuleiroAmeacaIA[i][j] > maiorValor) {
                        maiorValor = board.tabuleiroAmeacaIA[i][j];
                        coord[0] = i;
                        coord[1] = j;
                    }
                }
            }
        } else {
            for (int i = 0; i < this.dimensao; i++) {
                for (int j = 0; j < this.dimensao; j++) {
                    if (board.tabuleiroAmeacaJogador[i][j] > maiorValor) {
                        maiorValor = board.tabuleiroAmeacaIA[i][j];
                        coord[0] = i;
                        coord[1] = j;
                    }
                }
            }  
        }
        
        return coord;
    }
    
    // Funcao de Utilidade - Retorna a soma total do tabuleiro de ameaca
    public double getSomaAmeaca() {
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
    public boolean existePeca(int li, int co) {
        return this.tabuleiroPecas[li][co] != '.';
    }
    
    
}
