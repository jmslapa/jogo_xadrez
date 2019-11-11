package application;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Program {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);		
		ChessMatch chessMatch = new ChessMatch();
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!chessMatch.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(chessMatch, captured);
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(in);
				
				boolean[][] possibleMoves = chessMatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessMatch.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(in);
				
				ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);				
				}
				
				if(chessMatch.getPromoted() != null) {
					System.out.println("Type the piece that you want promote (QUEEN/BISHOP/KNIGHT/ROOK)");
					String type = in.nextLine().toUpperCase();
					chessMatch.replacePromotedPiece(type);
				}
				
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				in.nextLine();
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				in.nextLine();
			}catch(InvalidParameterException e){
				System.out.println(e.getMessage());
			}
		}
		UI.clearScreen();
		UI.printMatch(chessMatch, captured);
	}
}
