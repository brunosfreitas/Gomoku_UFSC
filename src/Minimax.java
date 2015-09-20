

/*
Links:
    MiniMax com poda alfa e beta:   https://www.ocf.berkeley.edu/~yosenl/extras/alphabeta/alphabeta.html
    Demonstracao do MiniMax:        http://www.ai.mit.edu/courses/6.034f/gamepair.html

*/

/*
Pseudo MiniMax (rascunho do professor):
    minimax(player,board)
    if(game over in current board position)
        return winner
    children = all legal moves for player from this board
    if(max's turn)
        return maximal score of calling minimax on all the children
    else (min's turn)
        return minimal score of calling minimax on all the children
*/
public class Minimax {
    
    private int melhorLinha;
    private int melhorColuna;
    double pontuacao;
    
    public Minimax(){
        this.melhorColuna = 7;
        this.melhorLinha = 7;
        this.pontuacao = 0;
    }
    /**
     * @param board     Tabuleiro
     * @param alfa      Melhor movimento do Max
     * @param beta      Melhor movimento do Min
     * @param depth     Profundidade a procurar
     * @param player    Jogador atual
     * @return a melhor pontuacao encontrada (double[0] = pontuacao; double[1] = linha; double[2] = coluna.)
     * @TODO Melhorar a implementação de acordo com as melhorias na classe tabuleiro.
     * IA é o Max
     * Jogador é o Min
     */
    
    public double[] minimax(Tabuleiro board, double alfa, double beta, int depth, EnumTabuleiro player){
        
        if (depth == 0) {
            if (board.primeiraJogada()) {
                System.out.println("\n Esta e minha primeira jogada!");
                melhorLinha = 7;
                melhorColuna = 7;
                return new double[] {board.getSomaAmeaca(), melhorLinha, melhorColuna};
            } else { //Se nao for a primeira jogada entao calcula-se a funcao de utilidade e entao busca-se e retorna a coord da melhor posicao a se jogar
                pontuacao = board.getSomaAmeaca();
                if (player.equals(EnumTabuleiro.IA)) {
                    int[] melhorJogada = board.getCoordMaiorValorIA(board);
                    melhorLinha = melhorJogada[0];
                    melhorColuna = melhorJogada[1];
                    return new double[] {pontuacao, melhorLinha, melhorColuna};
                } else{
                    int[] melhorJogada = board.getCoordMaiorValorJOGADOR(board);
                    melhorLinha = melhorJogada[0];
                    melhorColuna = melhorJogada[1];
                    return new double[] {pontuacao, melhorLinha, melhorColuna};
                }
            }
        } else {
            if (player.equals(EnumTabuleiro.IA)) {
                double[] retornoDoMinimax = minimax(board, alfa, beta, depth - 1, EnumTabuleiro.JOGADOR); //Tem que ser jogador pois o proximo nivel sera Min
                pontuacao = retornoDoMinimax[0];
                if (pontuacao > alfa) {
                    alfa = pontuacao;
                    melhorLinha = (int)retornoDoMinimax[1];
                    melhorColuna = (int)retornoDoMinimax[2];
                }
            } else {
                double[] retornoDoMinimax = minimax(board, alfa, beta, depth - 1, EnumTabuleiro.IA); //Tem que ser IA pois o proximo nivel sera Max
                pontuacao = retornoDoMinimax[0];
                if (pontuacao < beta) {
                    beta = pontuacao;
                    melhorLinha = (int)retornoDoMinimax[1];
                    melhorColuna = (int)retornoDoMinimax[2];
                }
            }
        }
        
        return new double[] {pontuacao, melhorLinha, melhorColuna};
    }
}
