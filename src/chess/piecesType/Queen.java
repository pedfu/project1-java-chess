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
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];/*
        ChessPiece[] pieces = new ChessPiece[3];
        pieces[0] = new Bishop(getBoard(), getColor());
        pieces[1] = new King(getBoard(), getColor());
        pieces[2] = new Rook(getBoard(), getColor());

        boolean[][] mat1= pieces[0].possibleMoves();
        boolean[][] mat2= pieces[0].possibleMoves();
        boolean[][] mat3= pieces[0].possibleMoves();

        for(int i=0; i< getBoard().getRows(); i++) {
            for(int j=0; j<getBoard().getColumns(); j++) {
                if(mat1[i][j] == true) {
                    mat[i][j] = true;
                }else if(mat2[i][j] == true) {
                    mat[i][j] = true;
                }else if(mat3[i][j] == true) {
                    mat[i][j] = true;
                }
            }
        }
*/
        return mat;
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
