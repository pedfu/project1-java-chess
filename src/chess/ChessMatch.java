package chess;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.piecesType.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class ChessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private ChessPiece enPassantVulnerable;
    private ChessPiece promoted;
    private List<ChessPiece> piecesOnTheBoard = new ArrayList<>();
    private List<ChessPiece> capturedPieces = new ArrayList<>();

    public ChessMatch() {
        board = new Board(8, 8);
        turn = 1;
        currentPlayer = Color.WHITE;
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
        piecesOnTheBoard.add(piece);
    }

    private void nextTurn() {
        turn++;
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private void initialSetup() {
        //peca teste

        placeNewPiece('a', 1, new Rook(board, Color.WHITE));
        placeNewPiece('h', 1,new Rook(board, Color.WHITE));
        placeNewPiece('e', 1,new King(board, Color.WHITE));
        placeNewPiece('c', 1,new Bishop(board, Color.WHITE));
        placeNewPiece('f', 1,new Bishop(board, Color.WHITE));
        placeNewPiece('b', 1,new Knight(board, Color.WHITE));
        placeNewPiece('g', 1,new Knight(board, Color.WHITE));
        placeNewPiece('d', 1 ,new Queen(board, Color.WHITE));
        for(int i=0; i<8; i++) {  placeNewPiece((char)('a' + i), 2, new Pawn(board, Color.WHITE));  }


        placeNewPiece('a', 8, new Rook(board, Color.BLACK));
        placeNewPiece('h', 8,new Rook(board, Color.BLACK));
        placeNewPiece('e', 8,new King(board, Color.BLACK));
        placeNewPiece('c', 8,new Bishop(board, Color.BLACK));
        placeNewPiece('f', 8,new Bishop(board, Color.BLACK));
        placeNewPiece('b', 8,new Knight(board, Color.BLACK));
        placeNewPiece('g', 8,new Knight(board, Color.BLACK));
        placeNewPiece('d', 8 ,new Queen(board, Color.BLACK));
        for(int i=0; i<8; i++) {  placeNewPiece((char)('a' + i), 7, new Pawn(board, Color.BLACK));  }

    }
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMoves();
    }
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source, target);
        Piece capturedPiece = makeMove(source, target);

        if(testCheck(currentPlayer)) {
            undoMove(source,target,capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }

        check = (testCheck(opponent(currentPlayer))) ? true : false;

        if(testCheckMate(opponent(currentPlayer))) {
            checkMate = true;
        } else {
            nextTurn();
        }

        return (ChessPiece) capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if(!board.thereIsAPiece(position)) {
            throw new ChessException("There is no piece on source position");
        }
        if(currentPlayer != ((ChessPiece)(board.piece(position))).getColor()) {
            throw new ChessException("The chosen piece is not yours");
        }
        if(!board.piece(position).isThereAnyPossibleMove()) {
            throw new ChessException("There is no possible moves for chosen piece");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        if(!board.piece(source).possibleMove(target)) {
            throw new ChessException("The chosen piece can't move to target position");
        }
    }

    private Piece makeMove(Position source, Position target) {
        ChessPiece sPiece = (ChessPiece) board.removePiece(source);
        sPiece.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(sPiece, target);

        if(capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add((ChessPiece) capturedPiece);
        }
        return capturedPiece;
    }

    private void undoMove(Position source, Position target, Piece capturedPiece) {
        ChessPiece p = (ChessPiece) board.removePiece(target);
        p.decreaseMoveCount();
        board.placePiece(p, source);

        if(capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add((ChessPiece) capturedPiece);
        }
    }

    private Color opponent(Color color) {
        return (color == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    private ChessPiece king(Color color) {
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor()==color).collect(Collectors.toList());
        for(Piece p : list) {
            if(p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There is no " + color + " king on the board");
    }

    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() != color).collect(Collectors.toList());
        for(Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            if(mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
    }

    private boolean testCheckMate(Color color) {
        if(!testCheck(color)) {
            return false;
        }
        List<Piece> opponentPieces = piecesOnTheBoard.stream().filter(x -> ((ChessPiece)x).getColor() == color).collect(Collectors.toList());
        for(Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMoves();
            for(int i=0; i< board.getRows(); i++) {
                for (int j=0; j< board.getColumns(); j++) {
                    if(mat[i][j]) {
                        Position source = ((ChessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i,j);
                        Piece capturedPiece = makeMove(source,target);
                        boolean testCheck = testCheck(color);
                        undoMove(source, target, capturedPiece);
                        if(!testCheck) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }



    public int getTurn() {
        return turn;
    }

    public Color getCurrentPlayer() {
        return currentPlayer;
    }

    public boolean getCheck() {
        return check;
    }

    public boolean getCheckMate() {
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
