
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
     */
    

    public void MiniMax(Tabuleiro board, int alfa, int beta, int depth, Jogador player){
        
    }
}
