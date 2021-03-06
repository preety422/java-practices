package com.preety.chessboard.domain;

public class Queen extends Piece {
	private Color color;

	public Queen(Color color) {
		super(color, PieceType.Q);
		this.color = color;
	}

	@Override
	public String move( Position start, Position end) {
		int row = end.getRow();
		int col = end.getCol();
		int srow=start.getRow();
		int scol= start.getCol();
		if(row<0 || row>Board.getRows()-1 || col<0 || col>Board.getCols()-1) return "Invalid";
		if(srow<0 || srow>Board.getRows()-1 || scol<0 || scol>Board.getCols()-1) return "Invalid";
	
		int roworder=1;
		int colorder=1;
		if(row<srow) {
			roworder=-1; // implement reverse move
		}
		if(col<scol) {
			colorder=-1; // implement reverse move
		}
		
		if( srow== row)
		{
			for(int i=scol; i<col; i++) {
				if (Board.isCellOccupied(row, i)) {
					return "Invalid";
				}
			}
		}
		if( scol== col)
		{
			for(int i=srow; i<row; i++) {
				if (Board.isCellOccupied(i, row)) {
					return "Invalid";
				}
			}
		} 
		if(srow!= row && scol!= col) {
			if(Math.abs(srow-row) != Math.abs(scol-col)) {
				return "Invalid";
			} else {
				for(int i=srow; i<row; i++) {
					for(int j=scol; j<col; j++) {
						if (Board.isCellOccupied(i, j)) {
							return "Invalid";
						}
					}
				}
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
