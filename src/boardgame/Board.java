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
            throw new BoardException("There is already apiece on position " + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }
    /*
        public Piece removePiece(Position position) {
            this.pieces[position.getRow()][position.getRow()] = null; //SETAR "-"
        }
    */
    public boolean positionExists(Position position) {
        if(position.getColumn() < 8 && position.getRow() < 8) {
            if(position.getRow() >= 0 && position.getColumn() >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean positionExists(int row, int column) {
        if(row < 8 && columns < 8) {
            if(row >= 0 && columns >= 0) {
                return true;
            }
        }
        return false;
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
