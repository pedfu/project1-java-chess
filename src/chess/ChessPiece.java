package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
   // private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board); //falta um Position aqui
        this.color = color;
        //this.moveCount = moveCount;
    }
/*
    public ChessPosition getChessPosition() {

    }

    protected boolean isThereOpponentPiece(Position position) {

    }

    protected void increaseMoveCount() {

    }

    protected void decreaseMoveCount() {

    }*/


    public Color getColor() {
        return color;
    }
/*
    public int getMoveCount() {
        return moveCount;
    }*/
}
