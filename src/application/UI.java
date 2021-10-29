package application;

import chess.ChessPiece;
import chess.ChessPosition;
import chess.Color;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UI {

    public static void clearScreen() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static ChessPosition readChessPosition(Scanner scanner) {
        //letra e numero a1
        try {
            String s = scanner.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));

            return new ChessPosition(column, row);
        }catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPositon. Valid values are from a1 to h8");
        }
    }

    public static void printBoard(ChessPiece[][] pieces) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], false);
            }
                System.out.println();
            }
        for (int i = 0; i < pieces.length; i++) {System.out.print("\t" + (char)('a' + i));}
    }

    public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
        for (int i = 0; i < pieces.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pieces.length; j++) {
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            System.out.println();
        }
        for (int i = 0; i < pieces.length; i++) {System.out.print("\t" + (char)('a' + i));}
    }


    private static void printPiece(ChessPiece piece, boolean background) {
        if(background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }

        int n = 0;
        if (piece == null) {/*
            if(n%2==0) {
                System.out.print("\t" + UI.ANSI_WHITE_BACKGROUND+"⬜"+ UI.ANSI_RESET);
                n++;
            } else {
                System.out.print("\t" + UI.ANSI_BLACK_BACKGROUND+"⬜"+ UI.ANSI_RESET);
                if(!(n%7==0)) {
                    n++;
                }
            }*/
            System.out.print("\t⬜" + ANSI_RESET);
        } else {/*
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
            if(n%2==0) {
                System.out.print("\t" + UI.ANSI_WHITE_BACKGROUND+piece+ UI.ANSI_RESET);
                n++;
            } else {
                System.out.print("\t" + UI.ANSI_BLACK_BACKGROUND+piece+ UI.ANSI_RESET);
                if(!(n%7==0)) {
                    n++;
                }
            }*/
            System.out.print("\t" +piece + ANSI_RESET);
           // System.out.print("\t"+UI.ANSI_WHITE_BACKGROUND+piece+ UI.ANSI_RESET);
        }
    }
}
