package chess.piecesType;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private int turn;

    public Pawn(Board board, Color color) {
        super(board, color);
        turn = 0;
    }

    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);
        if(getColor() == Color.WHITE) {
            //cima
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                if (/*verificar se for a primeira jogada*/ getMoveCount() == 0) {
                    p.setValues(position.getRow() - 2, position.getColumn());
                    if(!getBoard().thereIsAPiece(p)) {
                        mat[p.getRow()][p.getColumn()] = true;
                    }
                }
            }

            //diagonal
            //--
            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //-+
            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {
            //baixo
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                if (turn <= 4) {
                    p.setValues(position.getRow() + 2, position.getColumn());
                    mat[p.getRow()][p.getColumn()] = true;
                }
            }

            //diagonal
            //--
            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
            //-+
            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        //se jogar, aumentar turn
        increaseTurn();
        return mat;
    }

    private void increaseTurn() {
        this.turn++;
    }

    @Override
    public String toString() {
        if(this.getColor() == Color.WHITE) {
            return "♟";
        } else {
            return "♙";
        }
    }

    public int getTurn() {
        return turn;
    }
}
