import java.util.ArrayList;

public class Tabuleiro {

    //Singleton
    private static Tabuleiro instance;
    private boolean primeiraJogada;
    public char[][] tabuleiroPecas;
    public double[][] tabuleiroAmeacaJogador;
    public double[][] tabuleiroAmeacaIA;
    
    public double[][] tabuleiroExpoenteJogador;
    public double[][] tabuleiroExpoenteIA;
    
    public final int dimensao = 15;
    
    
    /*
        Construtor privado de classe necessário para a implementação correta de um singleton.
    */
    private Tabuleiro() {
        this.primeiraJogada = true;
        this.tabuleiroPecas = new char[this.dimensao][this.dimensao];
        this.tabuleiroAmeacaJogador = new double[this.dimensao][this.dimensao];
        this.tabuleiroAmeacaIA = new double[this.dimensao][this.dimensao];
        
        this.tabuleiroExpoenteJogador = new double[this.dimensao][this.dimensao];
        this.tabuleiroExpoenteIA = new double[this.dimensao][this.dimensao];

//		Iniciar o tabuleiroPecas com pontos que irao representar as interseccoes das linhas
        for (int li = 0; li < this.dimensao; li++) {
            for (int co = 0; co < this.dimensao; co++) {
                this.tabuleiroPecas[li][co] = '.';
                this.tabuleiroAmeacaJogador[li][co] = 0;
                this.tabuleiroAmeacaIA[li][co] = 0;
                
                this.tabuleiroExpoenteJogador[li][co] = 1;
                this.tabuleiroExpoenteIA[li][co] = 1;
            }
        }
    }

    /*
    Singleton: em todo o programa só existe uma única classe tabuleiro, se ela não existir cria-se uma nova, se já existir retorna a existente.
    */
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
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();       
        
        for (int i = 0; i < this.dimensao; i++) {
            for (int j = 0; j < this.dimensao; j++) {
                System.out.print(Math.pow(tabuleiro.tabuleiroAmeacaJogador[i][j], tabuleiroExpoenteJogador[i][j]) - Math.pow(tabuleiro.tabuleiroAmeacaIA[i][j], tabuleiroExpoenteIA[i][j]) + " ");
            }
            System.out.print("\n");
        }
    }

//	Insere a peça do jogador numa posicao do tabuleiroPecas
    public boolean inserePeca(int linha, int coluna, Jogador player) {
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        
        if (tabuleiro.existePeca(linha, coluna)) {
            System.out.println("\n-> Ja existe uma peca nesta posicao!");
            return false;
        }
        if (player.getPeca() == 'x') {
            tabuleiro.tabuleiroPecas[linha][coluna] = 'x';
        } else {
            tabuleiro.tabuleiroPecas[linha][coluna] = 'o';
        }
        
        this.primeiraJogada = false;
        this.setAmeaca(linha, coluna, player);
        this.printTabuleiroAmeaca();
        System.out.println("Peça Inserida em: " + linha + " " + coluna);
        
        return true;
    }
    
    public boolean primeiraJogada(){
        return this.primeiraJogada;
    }
    
    public void setAmeaca(int linha, int coluna, Jogador player) {

        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        //Peça do inimigo
        char pecaInimigo = player.getPecaInimigo();

        int deslocamento = 1;
        double pontuacaoLocal = 10;

        // Se uma peça estiver bloqueando, a pontuacao nao se perpetua mais
        boolean caminhoLivreNorte = true;
        boolean caminhoLivreSul = true;
        boolean caminhoLivreLeste = true;
        boolean caminhoLivreOeste = true;

        boolean caminhoLivreNorteLeste = true;
        boolean caminhoLivreNorteOeste = true;
        boolean caminhoLivreSulLeste = true;
        boolean caminhoLivreSulOeste = true;
        

        //Zera o local da peça colocada
        this.tabuleiroAmeacaJogador[linha][coluna] = 0;
        this.tabuleiroAmeacaIA[linha][coluna] = 0;

        
        //Num raio de 7 casas a partir do ponto onde a peca foi inserida, a ameaca é gerada no formato de "estrela" como foi mostrado no relatório.
        //@TODO Ao tentar adicionar uma ameaça se a peça encontra uma peça inimiga no caminho toda a ameaça é bloquada naquela direção representadas pelas oito varíaveis "caminhoLivreX".
        //@TODO Ao encontrar uma peça inimiga, a ameaça gerada por aquela pela peça também deve ser bloqueada pela nova peça adicional (X bloqueia Y, Y bloqueia X).
        while (deslocamento <= 7) {

            //Oeste
            try {
                if(tabuleiro.tabuleiroPecas[linha][coluna - deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha, coluna - deslocamento, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Leste
            try {
                if(tabuleiro.tabuleiroPecas[linha][coluna + deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha, coluna + deslocamento, player, pontuacaoLocal);
                
            } catch (Exception e) {
            }

            //Norte
            try {
                if(tabuleiro.tabuleiroPecas[linha - deslocamento][coluna] == '.')
                    tabuleiro.adicionarAmeaca(linha - deslocamento, coluna, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Sul
            try {

                if(tabuleiro.tabuleiroPecas[linha + deslocamento][coluna] == '.')
                    tabuleiro.adicionarAmeaca(linha + deslocamento, coluna, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Norte - Oeste
            try {

                if(tabuleiro.tabuleiroPecas[linha - deslocamento][coluna - deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha - deslocamento, coluna - deslocamento, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Norte - Leste
            try {

                if(tabuleiro.tabuleiroPecas[linha - deslocamento][coluna + deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha - deslocamento, coluna + deslocamento, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Sul - Lestex
            try {

                if(tabuleiro.tabuleiroPecas[linha + deslocamento][coluna + deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha + deslocamento, coluna + deslocamento, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            //Sul - Oeste
            try {

                if(tabuleiro.tabuleiroPecas[linha + deslocamento][coluna - deslocamento] == '.')
                    tabuleiro.adicionarAmeaca(linha + deslocamento, coluna - deslocamento, player, pontuacaoLocal);

            } catch (Exception e) {
            }

            pontuacaoLocal--;
            if(pontuacaoLocal < 7)
                pontuacaoLocal = 1;
            deslocamento++;
        }
        
        
    }
    
    public boolean verificarVitoria(int linha, int coluna, Jogador player){
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();
        
        //Peça do inimigo
        char pecaAliada = player.getPeca();
        char pecaInimiga = player.getPecaInimigo();
        
        int deslocamento = 5;
        
        int alinhadoOeste = 0;
        int alinhadoLeste = 0;
        int alinhadoNorte = 0;
        int alinhadoSul = 0;
        
        int alinhadoNorteOeste = 0;
        int alinhadoNorteLeste = 0;
        int alinhadoSulOeste = 0;
        int alinhadoSulLeste = 0;
        
        int maiorExpoenteOeste = 0;
        int maiorExpoenteLeste = 0;
        int maiorExpoenteNorte = 0;
        int maiorExpoenteSul = 0;
        
        int maiorExpoenteNorteOeste = 0;
        int maiorExpoenteNorteLeste = 0;
        int maiorExpoenteSulOeste = 0;
        int maiorExpoenteSulLeste = 0;
        
        while (deslocamento >= -5) {
            
            //Oeste->Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha][coluna - deslocamento] == pecaAliada) {
                    alinhadoOeste++;
                    
                    //Ao encontrar peças alinhadas, toda aquela fila deverá ter um expoente
                    if(alinhadoOeste > maiorExpoenteOeste)
                        maiorExpoenteOeste = alinhadoOeste;
                    
                    //Se tem 5 alinhado, vitoria!
                    if(alinhadoOeste == 5)
                        return true;
                }else{
                    alinhadoOeste=0;
                }
            } catch (Exception e) {
            }

            //Leste->Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha][coluna + deslocamento] == pecaAliada) {
                    alinhadoLeste++;
                    
                    if(alinhadoLeste > maiorExpoenteLeste)
                        maiorExpoenteLeste = alinhadoLeste;
                    
                    if(alinhadoLeste == 5)
                        return true;
                }else{
                    alinhadoLeste=0;
                }
            } catch (Exception e) {
            }

            //Norte->Sul
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna] == pecaAliada) {
                    alinhadoNorte++;
                    
                    if(alinhadoNorte > maiorExpoenteNorte)
                        maiorExpoenteNorte = alinhadoNorte;
                    
                    if(alinhadoNorte == 5)
                        return true;
                }else{
                    alinhadoNorte=0;
                }
            } catch (Exception e) {
            }

            //Sul->Norte
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna] == pecaAliada) {
                    alinhadoSul++;
                    
                    if(alinhadoSul > maiorExpoenteSul)
                        maiorExpoenteSul = alinhadoSul;
                    
                    if(alinhadoSul == 5)
                        return true;
                }else{
                    alinhadoSul=0;
                }
            } catch (Exception e) {
            }

            //Norte - Oeste -> Sul - Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna - deslocamento] == pecaAliada) {
                    alinhadoNorteOeste++;
                    
                    if(alinhadoNorteOeste > maiorExpoenteNorteOeste)
                        maiorExpoenteNorteOeste = alinhadoNorteOeste;
                    
                    if(alinhadoNorteOeste == 5)
                        return true;
                }else{
                    alinhadoNorteOeste=0;
                }
            } catch (Exception e) {
            }

            //Norte - Leste -> Sul - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha - deslocamento][coluna + deslocamento] == pecaAliada) {
                    alinhadoNorteLeste++;
                    
                    if(alinhadoNorteLeste > maiorExpoenteNorteLeste)
                        maiorExpoenteNorteLeste = alinhadoNorteLeste;
                    
                    if(alinhadoNorteLeste == 5)
                        return true;
                }else{
                    alinhadoNorteLeste=0;
                }
            } catch (Exception e) {
            }

            //Sul - Lestex -> Norte - Oeste
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna + deslocamento] == pecaAliada) {
                    alinhadoSulLeste++;
                    
                    if(alinhadoSulLeste > maiorExpoenteSulLeste)
                        maiorExpoenteSulLeste = alinhadoSulLeste;
                    
                    if(alinhadoSulLeste == 5)
                        return true;
                }else{
                    alinhadoSulLeste=0;
                }
            } catch (Exception e) {
            }

            //Sul - Oeste -> Norte - Leste
            try {
                if (tabuleiro.tabuleiroPecas[linha + deslocamento][coluna - deslocamento] == pecaAliada) {
                    alinhadoSulOeste++;
                    
                    if(alinhadoSulOeste > maiorExpoenteSulOeste)
                        maiorExpoenteSulOeste = alinhadoSulOeste;
                    
                    if(alinhadoSulOeste == 5)
                        return true;
                }else{
                    alinhadoSulOeste=0;
                }
            } catch (Exception e) {
            }

            deslocamento--;
        
        }
        
        // Agora que ele varreu todas as areas em torno da peca colocada num formato de estrela e verificou o 
        // maior numero de peças alinhadas em uma direção, devemos multiplicar a pontuacao daquela linha pelo expoente encontrado
        // Em teoria, o maior numero de pecas alinhadas Norte deve ser igual ao Sul
        
        deslocamento = 0;
           
        while (deslocamento < dimensao) {
            
           //Oeste
            try {
                
                tabuleiro.aplicarExponente(linha, coluna - deslocamento, player, maiorExpoenteOeste);
                
            } catch (Exception e) {
            }

            //Leste
            try {
                
                    tabuleiro.aplicarExponente(linha, coluna + deslocamento, player, maiorExpoenteLeste);
                
            } catch (Exception e) {
            }

            //Norte
            try {
                
                    tabuleiro.aplicarExponente(linha - deslocamento, coluna, player, maiorExpoenteNorte);

            } catch (Exception e) {
            }

            //Sul
            try {

                    tabuleiro.aplicarExponente(linha + deslocamento, coluna, player, maiorExpoenteSul);

            } catch (Exception e) {
            }

            //Norte - Oeste
            try {

                    tabuleiro.aplicarExponente(linha - deslocamento, coluna - deslocamento, player, maiorExpoenteNorteOeste);

            } catch (Exception e) {
            }

            //Norte - Leste
            try {

                    tabuleiro.aplicarExponente(linha - deslocamento, coluna + deslocamento, player, maiorExpoenteNorteLeste);

            } catch (Exception e) {
            }

            //Sul - Lestex
            try {

                    tabuleiro.aplicarExponente(linha + deslocamento, coluna + deslocamento, player, maiorExpoenteSulLeste);

            } catch (Exception e) {
            }

            //Sul - Oeste
            try {
                    tabuleiro.aplicarExponente(linha + deslocamento, coluna - deslocamento, player, maiorExpoenteSulOeste);

            } catch (Exception e) {
            }

            deslocamento++;
            
        
        }
        
        return false;     
    }

    // Verifica qual o jogador e coloca a ameaca no seu respectivo tabuleiro
    // Método necessário para setAmeaca
    public void adicionarAmeaca(int linha, int coluna, Jogador player, double valor) {
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        if (player.identificador == EnumTabuleiro.IA) {
            tabuleiro.tabuleiroAmeacaIA[linha][coluna] = tabuleiro.tabuleiroAmeacaIA[linha][coluna] + valor;
        } else {
            tabuleiro.tabuleiroAmeacaJogador[linha][coluna] = tabuleiro.tabuleiroAmeacaJogador[linha][coluna] + valor;
        }
    }
    
    // Verifica qual o jogador e coloca o expoente para pecas alinhadas
    // Método necessário para verificarVitoria
    public void aplicarExponente(int linha, int coluna, Jogador player, int expoente){
        //Singleton
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        if (player.identificador == EnumTabuleiro.IA) {
            if(tabuleiro.tabuleiroExpoenteIA[linha][coluna] <= expoente)
                tabuleiro.tabuleiroExpoenteIA[linha][coluna] = expoente;
        } else {
            if(tabuleiro.tabuleiroExpoenteJogador[linha][coluna] <= expoente)
                tabuleiro.tabuleiroExpoenteJogador[linha][coluna] = expoente;
        }
    }

//    int[0] = linha; int[1] = coluna;
    //Este método visa buscar a coordenada da casa com maior pontuação a se jogar.
    public int[] getCoordMaiorValorIA(Tabuleiro board){
        double maiorValor = 0;
        int[] coord = {99, 99};
        
        for (int i = 0; i < this.dimensao; i++) {
            for (int j = 0; j < this.dimensao; j++) {
                if (Math.pow(board.tabuleiroAmeacaIA[i][j], board.tabuleiroExpoenteIA[i][j]) > maiorValor) {
                    maiorValor = Math.pow(board.tabuleiroAmeacaIA[i][j], board.tabuleiroExpoenteIA[i][j]);
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        
        return coord;
    }
    
    //Este método visa buscar a coordenada da casa com maior pontuação a se jogar.
    public int[] getCoordMaiorValorJOGADOR(Tabuleiro board){
        double maiorValor = 0;
        int[] coord = {99, 99};
        
        for (int i = 0; i < this.dimensao; i++) {
            for (int j = 0; j < this.dimensao; j++) {
                if (Math.pow(board.tabuleiroAmeacaIA[i][j], tabuleiroExpoenteJogador[i][j]) > maiorValor) {
                    maiorValor = Math.pow(board.tabuleiroAmeacaIA[i][j], tabuleiroExpoenteJogador[i][j]);
                    coord[0] = i;
                    coord[1] = j;
                }
            }
        }
        
        return coord;
    }

    // Funcao de Utilidade - Retorna a soma total do tabuleiro de ameaca
    public double getSomaAmeaca() {
        double soma = 0;
        Tabuleiro tabuleiro = Tabuleiro.getInstance();

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                soma += Math.pow(tabuleiro.tabuleiroAmeacaJogador[i][j], tabuleiroExpoenteJogador[i][j]) - Math.pow(tabuleiro.tabuleiroAmeacaIA[i][j], tabuleiroExpoenteIA[i][j]);
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
