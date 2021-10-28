package application;

import chess.ChessPiece;

import java.awt.*;

public class UI {
    public static void printBoard(ChessPiece[][] pieces) {
        for(int i=0; i< pieces.length; i++) {
            System.out.print((8-i) + " ");
            for(int j=0; j<pieces[i].length; j++) {
                printPiece(pieces[i][j]);
            }
            System.out.println();
        }
        char alph = 'a';
        System.out.print(" \t");
        for(int i=0; i<8; i++) {
            System.out.print(Character.valueOf((char) (alph + i)) + "\t");
        }
    }

    private static void printPiece(ChessPiece piece) {
        System.out.print("\t");
        if(piece != null) {
            System.out.print(piece);
        } else {
            System.out.print("⬜");
            //❏
        }
    }
}
