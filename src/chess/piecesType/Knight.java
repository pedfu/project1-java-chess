package chess.piecesType;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece{
    public Knight(Board board, Color color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        //L up and right -+
        p.setValues(position.getRow()-2, position.getColumn()+1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p) || isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L up and left --
        p.setValues(position.getRow()-2, position.getColumn()-1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L down and right ++
        p.setValues(position.getRow()+2, position.getColumn()+1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L down and left +-
        p.setValues(position.getRow()+2, position.getColumn()-1);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }


        //L left and down
        p.setValues(position.getRow()+1, position.getColumn()-2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L left and up
        p.setValues(position.getRow()-1, position.getColumn()-2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L right and down
        p.setValues(position.getRow()+1, position.getColumn()+2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //L right and up
        p.setValues(position.getRow()-1, position.getColumn()+2);
        if(getBoard().positionExists(p) && (!getBoard().thereIsAPiece(p)||isThereOpponentPiece(p))) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }

    @Override
    public String toString() {
        if(this.getColor() == Color.WHITE) {
            return "♞";
        } else {
            return "♘";
        }
    }
}
