Instituicao:            UNIVERSIDADE FEDERAL DE SENTA CATARINA.
Departamento:           INE - DEPARTAMENTO DE INFORMÁTICA E ESTATÍSTICA.
Graduandos:             BRUNO FREITAS (XXXXXX).
                        RODRIGO PEDRO MARQUES (12200660).
Data:                   FLORIANÓPOLIS, 11 DE SETEMBRO DE 2015.

Linguagem Utilizada:    Java.

TO-DO List:
            []  Criar tabuleiros de ameaça de cada 'jogador'.
            []  Criar a inserção de peça com "pontuacao".
            []  Definir o que eh um estado.
            []  Somatorio do Tabuleiro.
            []
            []
            []


// Racunho

/**
	public double avalie(Tabuleiro board) {
		int oneAway = board.nearWins(board.prevPlayer, 1);
		int twoAway = board.nearWins(board.prevPlayer, 2);
		int threeAway = board.nearWins(board.prevPlayer, 3);
		double score = oneAway * 100.0 + twoAway * 5.0 + threeAway * 1.0;
		return score;
	}

	/*
	 * @param  profundidade profundidade a buscar
	 * @param  alfa melhor movimento de max
	 * @param  beta melhor movimento de min
	 * @return Object[0] contains (Double) score and Object[1] contains (String) move
	*/ 
	public Object[] MiniMax(Tabuleiro board, int profundidade, double alfa, double beta) {
		ArrayList<String> moveList;
		Set<String> moves = new HashSet<String>();
		ArrayList<String> places = board.getPlayerPlaces(board.proxJog);
		for (int i = 0; i < places.size(); i++) {
			moves.addAll(board.lookAround(places.get(i)));
		}
		moves.retainAll(board.getVazios());
		// make sure that moves is not empty
		// otherwise, pick from list of empty locations
		if (moves.isEmpty())
			moveList = new ArrayList<String>(board.getVazios());
		else
			moveList = new ArrayList<String>(moves);

		Double bestScore;
		Object[] temp;
		Double tempScore;
		String bestMove = "";

		// evaluate at leaf
		if (profundidade == 0) {
			Object[] x = { avalie(board), moveList.get(0) };
			return x;
		}
		bestScore = alfa;
		while (moveList.size() > 0) {
			Tabuleiro newBoard = new Tabuleiro(board);
			String newMove = moveList.get(0);
			newBoard.placeMove(newBoard.proxJog, newMove, false);
			temp = MiniMax(newBoard, profundidade - 1, -beta, -bestScore);
			tempScore = -(Double) temp[0];
			if (tempScore > bestScore) {
				bestScore = tempScore;
				bestMove = newMove;
			}
			if (bestScore > beta) {
				Object[] x = { bestScore, bestMove };
				return x;
			}
			moveList.remove(0);
		}
		Object[] x = { bestScore, bestMove };
		return x;
	}
**/