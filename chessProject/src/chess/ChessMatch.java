package chess;

import boardgame.Board;
import boardgame.Position;
import chess.pieces.King;
import chess.pieces.Rook;

public class ChessMatch {
	Board chessBoard;
	
	public ChessMatch() {
		chessBoard = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[chessBoard.getRows()][chessBoard.getColumns()];
		for(int i=0 ; i<chessBoard.getRows() ; i++) {
			for(int j = 0 ; j<chessBoard.getColumns() ; j++) {
				mat[i][j] = (ChessPiece) chessBoard.piece(i, j);
			}
		}
		return mat;
	}
	
	private void initialSetup() {		
		chessBoard.placePiece(new King(chessBoard, Color.BLACK), new Position(0, 4));
		chessBoard.placePiece(new Rook(chessBoard, Color.BLACK), new Position(0, 0));
		chessBoard.placePiece(new Rook(chessBoard, Color.BLACK), new Position(0, 7));
		
		chessBoard.placePiece(new King(chessBoard, Color.WHITE), new Position(7, 4));
		chessBoard.placePiece(new Rook(chessBoard, Color.WHITE), new Position(7, 0));
		chessBoard.placePiece(new Rook(chessBoard, Color.WHITE), new Position(7, 7));
	}
}
