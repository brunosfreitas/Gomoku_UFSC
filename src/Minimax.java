

/*
Links:
    MiniMax com poda alfa e beta:   https://www.ocf.berkeley.edu/~yosenl/extras/alphabeta/alphabeta.html
    Demonstracao do MiniMax:        http://www.ai.mit.edu/courses/6.034f/gamepair.html

*/
public class Minimax {

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

    /**
     * @param board     Tabuleiro
     * @param alfa      Melhor movimento do Max
     * @param beta      Melhor movimento do Min
     * @param depth     Profundidade a procurar
     * @param player    Jogador atual
     * @return a melhor pontuacao encontrada
     * IA é o Max
     * Jogador é o Min

     */
    

    public double minimax(Tabuleiro board, double alfa, double beta, int depth, EnumTabuleiro player){
        
        double pontuacao = 0;
        int melhorColuna = 99;
        int melhorLinha = 99;
        
        if (depth == 0) {
            if (board.getSomaAmeaca() == 0) {
                melhorColuna = 7;
                melhorLinha = 7;
            } else {
                
            }
        } else {
            if (player.equals(EnumTabuleiro.IA)) {
                pontuacao = minimax(board, alfa, beta, depth - 1, EnumTabuleiro.JOGADOR); //Tem que ser jogador pois o proximo nivel sera Min
                if (pontuacao > alfa) {
                    alfa = pontuacao;
                }
            } else {
                pontuacao = minimax(board, alfa, beta, depth - 1, EnumTabuleiro.IA); //Tem que ser IA pois o proximo nivel sera Max
                if (pontuacao < beta) {
                    beta = pontuacao;
                }
            }
        }
        
        
        
        
        return 0; //so pro compilador parar de reclamar.
    }
}
