package com.preety.chessboard.domain;

public class Pawn extends Piece {
	private Color color;

	public Pawn(Color color) {
		super(color, PieceType.Q);
		this.color = color;
	}

	@Override
	public String move( Position start, Position end) {
		int row = end.getRow();
		int col = end.getCol();
		int srow=start.getRow();
		int scol= start.getCol();

		if(Math.abs(col-scol)>1) {
			return "Invalid";
		}
		if(color== Color.W) {
			if(col<1)return "Invalid";
		}
		if(color== Color.B) {
			if(col>Board.getRows()-2)return "Invalid";
		}
		
		if( scol== col)
		{
			if(Board.isCellOccupied(row, col)){
				return "Invalid";
			}
		}
		
		if (Board.isCellOccupied(row, col)) {
			Color endPiece = Board.getCellPieceColor(row, col);
			if (endPiece != color) {
				Board.setCellPieceColor(row, col, color);
				Board.setCellPiece(row, col, PieceType.Q);	
			} else {
				return "Invalid";
			}
			
		} else {
			Board.setCellPieceColor(row, col, color);
			Board.setCellPiece(row, col, PieceType.Q);
		}
		return "Valid";
	}

}
