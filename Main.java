package edu.wm.cs.cs301.guimemorygame;

import edu.wm.cs.cs301.guimemorygame.model.GameBoard;
import edu.wm.cs.cs301.guimemorygame.view.MemoryGame;
import edu.wm.cs.cs301.guimemorygame.view.MemoryGameFrameMaker;
import edu.wm.cs.cs301.guimemorygame.view.VictoryDisplay;
import edu.wm.cs.cs301.guimemorygame.model.LeaderBoardMaker;
import edu.wm.cs.cs301.guimemorygame.view.InstructionsDisplay;
import edu.wm.cs.cs301.guimemorygame.view.LeaderboardDisplay;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello, World!");
		//new MemoryGame(new GameBoard("Medium"));
		//new LeaderBoardMaker("Easy","Tate", 2);
		//new LeaderBoardMaker("Medium","Tate",2);
		//new LeaderBoardMaker("Hard","Tate",1);
		//new LeaderboardDisplay();
		
		new InstructionsDisplay();
		//new MemoryGameFrameMaker(new MemoryGame(new GameBoard("Medium")));
		new MemoryGameFrameMaker("Medium");
		
		//new VictoryDisplay(); //put into the framemaker
	}

}
