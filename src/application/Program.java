package application;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;

public class Program {
    public static void main(String[] args) {
        ChessMatch cm = new ChessMatch();
        UI.printBoard(cm.getPieces());
    }
}
