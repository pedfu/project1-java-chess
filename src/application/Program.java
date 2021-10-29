package application;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chess.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChessMatch cm = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

        while(true) {
            try{
                UI.clearScreen();
                UI.printMatch(cm, captured);
                System.out.println();
                System.out.print("Source: ");
                ChessPosition source = UI.readChessPosition(scanner);

                boolean[][] possibleMoves = cm.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(cm.getPieces(), possibleMoves);

                System.out.println();
                System.out.print("Target: ");
                ChessPosition target = UI.readChessPosition(scanner);

                ChessPiece capturedPiece = cm.performChessMove(source, target);

                if(capturedPiece != null) {
                    captured.add(capturedPiece);
                }
                /*if(capturedPiece != null) {
                    if(capturedPiece.getColor() == Color.WHITE) {
                        whiteCapturedPieces.add(capturedPiece);
                    } else {
                        blackCapturedPieces.add(capturedPiece);
                    }
                    System.out.println();
                    System.out.print("White captured pieces: ");
                    for (Piece piece:whiteCapturedPieces) {
                        System.out.print(piece + " ");
                    }
                    System.out.println();

                    System.out.print("Black captured pieces: ");
                    for (Piece piece : blackCapturedPieces) {
                        System.out.print(piece + " ");
                    }
                }*/
            } catch (ChessException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
        }
        //scanner.close();
    }
}
