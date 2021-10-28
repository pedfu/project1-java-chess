package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.piecesType.*;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;

    public ChessMatch() {
        board = new Board(8, 8);
        initialSetup();
    }

    public ChessMatch(int turn, Color currentPlayer, boolean check, boolean checkMate,
                      ChessPiece enPassantVulnerable, ChessPiece promoted) {
        board = new Board(8, 8);
        this.turn = turn;
        this.currentPlayer = currentPlayer;
        this.check = check;
        this.checkMate = checkMate;
        this.enPassantVulnerable = enPassantVulnerable;
        this.promoted = promoted;
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getRows()];
        for(int i=0; i< board.getRows(); i++) {
            for(int j=0; j< board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.piece(i,j);
            }
        }
        return mat;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    private void initialSetup() {
        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1,new Rook(board, Color.WHITE));
        placeNewPiece('e', 1,new King(board, Color.WHITE));
        placeNewPiece('c', 1,new Bishop(board, Color.WHITE));
        placeNewPiece('f', 1,new Bishop(board, Color.WHITE));
        placeNewPiece('b', 1,new Horse(board, Color.WHITE));
        placeNewPiece('g', 1,new Horse(board, Color.WHITE));
        placeNewPiece('d', 1 ,new Queen(board, Color.WHITE));
        for(int i=0; i<8; i++) {  placeNewPiece((char)('a' + i), 2, new Pawn(board, Color.WHITE));  }


        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8,new Rook(board, Color.BLACK));
        placeNewPiece('e', 8,new King(board, Color.BLACK));
        placeNewPiece('c', 8,new Bishop(board, Color.BLACK));
        placeNewPiece('f', 8,new Bishop(board, Color.BLACK));
        placeNewPiece('b', 8,new Horse(board, Color.BLACK));
        placeNewPiece('g', 8,new Horse(board, Color.BLACK));
        placeNewPiece('d', 8 ,new Queen(board, Color.BLACK));
        for(int i=0; i<8; i++) {  placeNewPiece((char)('a' + i), 7, new Pawn(board, Color.BLACK));  }

        }
/*
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {

    }
*/
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
    }

    private Piece makeMove(Position source, Position target) {
        Piece sPiece = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(sPiece, target);

        return capturedPiece;
    }
/*
    public ChessPiece replacePromotedPiece(String type) {

    }*/


    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Color currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public ChessPiece getEnPassantVulnerable() {
        return enPassantVulnerable;
    }

    public void setEnPassantVulnerable(ChessPiece enPassantVulnerable) {
        this.enPassantVulnerable = enPassantVulnerable;
    }

    public ChessPiece getPromoted() {
        return promoted;
    }

    public void setPromoted(ChessPiece promoted) {
        this.promoted = promoted;
    }
}
