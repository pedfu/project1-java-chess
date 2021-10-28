package chess.piecesType;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {
    public Bishop(Board board, Color color) {
        super(board, color);
    }

    public boolean[][] possibleMoves () {
        boolean[][] bArray = new boolean[8][8];/*
        for (int i = 0; i < bArray.length; i++) {
            for (int j = 0; j < bArray[i].length; j++) {
                bArray[i][j] = false;
            }
        }
        for (int i = 0; i + getPosition().getColumn() < 8; i++) {//ver se tem oeca ka
            bArray[getPosition().getRow() + i][getPosition().getColumn() + i] = true;

            if (isThereOpponentPiece(new Position(getPosition().getRow() + i,
                    getPosition().getColumn() + i))) {
                break;
            }
        }
        for (int i = 0; getPosition().getColumn() - i >= 0; i++) {
            bArray[getPosition().getRow() - i][getPosition().getColumn() - i] = true;
            if (isThereOpponentPiece(new Position(getPosition().getRow() + i,
                    getPosition().getColumn() + i))) {
                break;
            }
        }
        for (int i = 0; (i + getPosition().getColumn() < 8) && (getPosition().getColumn() - i >= 0); i++) {//ver se tem oeca ka
            bArray[getPosition().getRow() + i][getPosition().getColumn() - i] = true;

            if (isThereOpponentPiece(new Position(getPosition().getRow() + i,
                    getPosition().getColumn() - i))) {
                break;
            }
        }
        for (int i = 0; (i + getPosition().getColumn() < 8) && (getPosition().getColumn() - i >= 0); i++) {
            bArray[getPosition().getRow() - i][getPosition().getColumn() + i] = true;
            if (isThereOpponentPiece(new Position(getPosition().getRow() - i,
                    getPosition().getColumn() + i))) {
                break;
            }
        }
        bArray[getPosition().getRow()][getPosition().getColumn()] = false;*/ //piece cannot move to the same place
        return bArray;
    }

    @Override
    public String toString() {
        if(this.getColor() == Color.WHITE) {
            return "♝";
        } else {
            return "♗";
        }
    }
}

