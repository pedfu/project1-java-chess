package chess.piecesType;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves() {
        boolean[][] bArray = new boolean[8][8];
        for(int i=0; i<bArray.length; i++) {
            for(int j=0; j<bArray[i].length; j++) {
                bArray[i][j] = true;
            } //inicializa tudo como falso
        }
        /*
        for(int i=0; i<bArray.length; i++) {
            for(int j=0; j<bArray[i].length; j++) {
                bArray[i][j] = false;
            } //inicializa tudo como falso
        }
        if(isThereOpponentPiece(new Position(getPosition().getRow() + 1,
                getPosition().getColumn() + 1)) || isThereOpponentPiece(
                        (new Position(getPosition().getRow() + 1,
                                getPosition().getColumn() - 1)) )) { //ver se tem oponente na diagonal de cima
            bArray[getPosition().getRow()+1][getPosition().getColumn()+1] = true;
            bArray[getPosition().getRow()+1][getPosition().getColumn()+1] = true;
        }
        if(!(isThereOpponentPiece(new Position(getPosition().getRow() + 1,
                getPosition().getColumn())))) {
            //if theres no enemy in front...
            bArray[getPosition().getRow()+1][getPosition().getColumn()] = true;
            if(!(getMoveCount() > 0)) {
                bArray[getPosition().getRow()+2][getPosition().getColumn()] = true;
            }
        }
        bArray[getPosition().getRow()][getPosition().getColumn()] = false;*/
        return bArray;
    }

    @Override
    public String toString() {
        if(this.getColor() == Color.WHITE) {
            return "♟";
        } else {
            return "♙";
        }
    }
}
