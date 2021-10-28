package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows<1 || columns<1) {
            throw new BoardException("Error creating board: there must be at least 1 row and 1 column");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int columns) {
        if(!positionExists(row, columns)) {
            throw new BoardException("Position not on the board");
        }
        return this.pieces[row][columns];
    }

    public Piece piece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if(thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    public Piece removePiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if(piece(position) == null) {
            return null;
        }
        Piece aux = piece(position);
        aux.position = null;
        this.pieces[position.getRow()][position.getColumn()] = null; //SETAR "-"
        return aux;
    }
    public boolean positionExists(Position position) {
        return positionExists(position.getRow(), position.getColumn());
    }

    public boolean positionExists(int row, int column) {
        return row >=0 && row < rows && column >= 0 && column < columns;
    }

    public boolean thereIsAPiece(Position position) {
        if(!positionExists(position)) {
            throw new BoardException("Position not on the board");
        }
        if (pieces[position.getRow()][position.getColumn()] !=  null ) {
            return true; //tem peca
        }
        return false; //n tem peca
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
