package chess;

import boardgame.Board;
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

    private void initialSetup() {
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,7));
        board.placePiece(new Rook(board, Color.WHITE), new Position(7,0));
        board.placePiece(new King(board, Color.WHITE), new Position(7,4));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7,2));
        board.placePiece(new Bishop(board, Color.WHITE), new Position(7,5));
        board.placePiece(new Horse(board, Color.WHITE), new Position(7,1));
        board.placePiece(new Horse(board, Color.WHITE), new Position(7,6));
        board.placePiece(new Queen(board, Color.WHITE), new Position(7,3));
        for(int i=0; i<8; i++) {  board.placePiece(new Pawn(board, Color.WHITE), new Position(6,i));  }


        board.placePiece(new King(board, Color.BLACK), new Position(0,4));
        board.placePiece(new Rook(board, Color.BLACK), new Position(0,0));
        board.placePiece(new Rook(board, Color.BLACK), new Position(0,7));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0,2));
        board.placePiece(new Bishop(board, Color.BLACK), new Position(0,5));
        board.placePiece(new Horse(board, Color.BLACK), new Position(0,1));
        board.placePiece(new Horse(board, Color.BLACK), new Position(0,6));
        board.placePiece(new Queen(board, Color.BLACK), new Position(0,3));
        for(int i=0; i<8; i++) {  board.placePiece(new Pawn(board, Color.BLACK), new Position(1,i));  }
    }
/*
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {

    }

    public ChessPosition performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {

    }

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
