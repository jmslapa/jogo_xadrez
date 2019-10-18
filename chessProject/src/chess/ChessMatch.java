package chess;

import boardgame.Board;

public class ChessMatch {
	Board chessBoard;
	
	public ChessMatch() {
		chessBoard = new Board(8, 8);
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
	
}
