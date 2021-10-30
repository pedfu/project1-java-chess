package chess.piecesType;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //#enPassant
            if(position.getRow() == 3) {
                 Position left = new Position(position.getRow(), position.getColumn() - 1);
                 if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                     mat[position.getRow()-1][position.getColumn()-1] = true;
                 }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[position.getRow()-1][position.getColumn()+1] = true;
                }
            }

        } else {
            //baixo
            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                if (getMoveCount() == 0) {
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

            //#enPassant
            if(position.getRow() == 4) {
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
                    mat[position.getRow()+1][position.getColumn()-1] = true;
                }
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
                    mat[position.getRow()+1][position.getColumn()+1] = true;
                }
            }
        }
        return mat;
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
