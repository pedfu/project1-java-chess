package chess.piecesType;

import boardgame.Board;
import chess.ChessPiece;
import chess.Color;

public class Queen extends ChessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        return new boolean[0][];
    }

    @Override
    public String toString() {
        if(this.getColor() == Color.WHITE) {
            return "♛";
        } else {
            return "♕";
        }
    }
}
