package edu.wm.cs.cs301.guimemorygame.controller;

import edu.wm.cs.cs301.guimemorygame.model.GameBoard;
import edu.wm.cs.cs301.guimemorygame.view.InstructionsDisplay;
import edu.wm.cs.cs301.guimemorygame.view.LeaderboardDisplay;
import edu.wm.cs.cs301.guimemorygame.view.MemoryGame;
import edu.wm.cs.cs301.guimemorygame.view.MemoryGameFrameMaker;
import edu.wm.cs.cs301.guimemorygame.view.VictoryDisplay;

//Is this necessary?
public class DifficultySelector{//Should close LeaderBoard, diff

	
	
	//.dispose() all the windows, only re-open the leader board and game windows
	
	public DifficultySelector(MemoryGameFrameMaker frameMaker, String diff) {
		frameMaker.frame.dispose();
		frameMaker.lDisplay.LFrame.dispose();
		
		if(diff.equals("Easy")) {
			new MemoryGameFrameMaker("Easy");
		}
		
		if(diff.equals("Medium")) {
			new MemoryGameFrameMaker("Medium");
		}

		if(diff.equals("Hard")) {
			new MemoryGameFrameMaker("Hard");
		}
	}



	
}
