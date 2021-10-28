package chess.piecesType;

import chess.ChessPiece;

public class Knight /* extends ChessPiece*/ {/*

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] bArray = new boolean[8][8];
        for(int i=0; i< bArray.length; i++) {
            for(int j=0; j<bArray[i].length; j++) {
                bArray[i][j] = false;
            }
        }
        //verificar se a casa é menor q isso
        if(getPosition().getRow() >= 2 && getPosition().getRow() <= 5) {
            if(getPosition().getColumn() >= 2 && getPosition().getColumn() <= 5) {
                bArray[getPosition().getRow() + 2][getPosition().getColumn() + 1] = true;
                bArray[getPosition().getRow() + 2][getPosition().getColumn() - 1] = true;

                bArray[getPosition().getRow() - 2][getPosition().getColumn() + 1] = true;
                bArray[getPosition().getRow() - 2][getPosition().getColumn() - 1] = true;

                bArray[getPosition().getRow() - 1][getPosition().getColumn() + 2] = true;
                bArray[getPosition().getRow() + 1][getPosition().getColumn() + 2] = true;

                bArray[getPosition().getRow() + 1][getPosition().getColumn() - 2] = true;
                bArray[getPosition().getRow() - 1][getPosition().getColumn() - 2] = true;
            } else if(getPosition().getColumn() >= 2) {

            }
        }

        bArray[getPosition().getRow()][getPosition().getColumn()] = false; //piece cannot move to the same place
        return bArray;
    }*/
}
