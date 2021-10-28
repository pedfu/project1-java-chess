package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public Piece piece(int row, int columns) {
        return this.pieces[row][columns];
    }

    public Piece piece(Position position) {
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
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
/*
    public boolean thereIsAPiece(Position position) {
        if (pieces[position.getRow()][position.getColumn()] !=  "-" ) {
            return false; //nao tem peca
        }
        return true; //tem peca
    }
*/
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
}
