package boardgame;

public abstract class Piece {
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    public abstract boolean[][] possibleMoves();

    public boolean possibleMove(Position position) {
        return false;
    }

    public boolean isThereAnyPossibleMove() {
        return false;
    }

    protected Board getBoard() {
        return board;
    }
}

