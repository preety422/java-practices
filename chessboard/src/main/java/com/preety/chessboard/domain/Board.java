package com.preety.chessboard.domain;

import com.preety.chessboard.exception.NotAValidChessBoard;
import com.preety.chessboard.domain.Color;
import com.preety.chessboard.domain.Color;

public class Board {
	private static boolean isOccupied[][];
	private static Color colorPresent[][];
	private static PieceType piecePresent[][];
	private static int rows;
	private static int cols;
	

	public static boolean[][] getIsOccupied() {
		return isOccupied;
	}

	public static Color[][] getColorPresent() {
		return colorPresent;
	}

	public static PieceType[][] getPiecePresent() {
		return piecePresent;
	}

	public static int getRows() {
		return rows;
	}

	public static int getCols() {
		return cols;
	}

	public void initialSetUp(String[][] boardData) {
		if (boardData == null || boardData.length == 0) {
			throw new NotAValidChessBoard("chess board is not initialized with pieces");
		}
		rows = boardData.length;
		cols = boardData[0].length;
		isOccupied = new boolean[rows][cols];
		colorPresent = new Color[rows][cols];
		piecePresent = new PieceType[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (boardData[i][j] != "--") {
					isOccupied[i][j] = true;
					String color = String.valueOf(boardData[i][j].charAt(0));
					colorPresent[i][j] = Color.valueOf(color);
					piecePresent[i][j] = PieceType.valueOf(boardData[i][j].charAt(1) + "");
				} else {
					isOccupied[i][j] = false;
				}
			}
		}

	}

	public static boolean isCellOccupied(int row, int col) {
		return isOccupied[row][col];
	}

	public static Color getCellPieceColor(int row, int col) {
		return colorPresent[row][col];
	}

	public static PieceType getCellPiece(int row, int col) {
		return piecePresent[row][col];
	}

	public static void setCellPieceColor(int row, int col, Color c) {
		colorPresent[row][col] = c;
	}

	public static void setCellPiece(int row, int col, PieceType p) {
		piecePresent[row][col] = p;
	}

}
