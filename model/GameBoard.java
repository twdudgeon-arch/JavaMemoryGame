package edu.wm.cs.cs301.guimemorygame.model;

import java.util.Scanner;



public class GameBoard{
	
	private EnglishAlphabet alphabet;
	
	public GamePiece[][] board;
	
	private int maxRows;
	
	private int rowCount;
	
	private int maxCols;
	
	private int colCount;
	
	private int alphCount;
	
	private int turnCount;
	
	private String difficulty;
	
	public GameBoard(String diff) {
		this.difficulty=diff;
		if(difficulty.equals("Easy")) {
			this.maxRows=3;
			this.maxCols=4;
		}
		
		if(difficulty.equals("Medium")) {
			this.maxRows=4;
			this.maxCols=7;
		}
		
		if(difficulty.equals("Hard")) {
			this.maxRows=7;
			this.maxCols=8;
		}
		
		this.turnCount=1;
		this.alphabet= new EnglishAlphabet();
		this.board=new GamePiece[maxRows][maxCols];
		this.colCount=0;
		this.rowCount=0;
		this.alphCount=0;
		this.turnCount=0;
		createBoard();
	}
	
	
	public void createBoard() {
		while(rowCount<maxRows) {
			while (colCount<maxCols) {
				GamePiece piece1=new CharacterGamePiece(alphabet.toCharArray()[alphCount]);
				board[rowCount][colCount]=piece1;
				
				colCount++;
				turnCount++;
				alphCount=turnCount/2;
				}
			colCount=0;
			rowCount++;
			}
		
		boardShuffle(board);
		}

	
	
	public static void boardShuffle(GamePiece[][] board) {
		//Citation for the video of the below function: https://youtu.be/2r4M8f4ZAH4?si=TY150bKU-2GLvrdM
		//Citation for the video's channel: https://www.youtube.com/@davemikesell4788
				for(int i=0; i < board.length; i++) {
					for(int j=0; j<board[i].length; j++) {
						int i1=(int)(Math.random()*(board.length));
						int j1=(int)(Math.random()*(board[i].length));
					
						GamePiece temp=board[i][j];
						board[i][j]=board[i1][j1];
						board[i1][j1]=temp;
					}
				}
	}
	
	public boolean isBoardVisible() {
		//int rows=board.length; just use maxRows and maxCols? Change located here
		//int cols=board[0].length;

		for(int row = 0; row < maxRows; row++) {
			for (int col = 0; col < maxCols; col++) {
				if(board[row][col].isVisible()==false) {
					return false;}	
				}
				}
		return true;
		}
	
	public void setBoardVisible() {
			//int rows=board.length;
			//int cols=board[0].length;

			for(int row = 0; row < maxRows; row++) {
				for (int col = 0; col < maxCols; col++) {
					board[row][col].setVisible(true);
					}
					}
			}

	
	public int getMaxRows(){
		return maxRows;
	}
	
	public int getMaxCols(){
		return maxCols;
	}
	
	public String getDifficulty() {
		return difficulty;
	}
	
}