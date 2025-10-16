package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;



public class InstructionsDisplay {
	//private JFrame frame;
	
	//private final CancelAction cancelAction;
	
	private JFrame instructionsFrame;

	
	public InstructionsDisplay() {
		this.instructionsFrame=new JFrame("Instructions");
		instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		instructionsFrame.setLayout(new BorderLayout());
		instructionsFrame.add(new JTextArea(InstructionsText()), BorderLayout.CENTER);
		instructionsFrame.pack(); //change to set size
		instructionsFrame.setVisible(true);
		instructionsFrame.setLocationRelativeTo(null);
	}
	
	private String InstructionsText() {
		String text=
				"Welcome to the Memory Game!\n"
				+ "> Here you will attempt to match each pair of 'game pieces' that possess a matching symbol.\n"
				+ "> Pick each hidden tile by clicking on the to reveal their symbol, also known as 'flipping' them\n"
				+ "> The first number will pick the row, and the second will pick the column\n"
				+ "> When you get a correct matching pair, both tiles will remain 'flipped' over!\n"
				+ "> Your score is measured by how many turns it takes you to 'flip' all of the tiles\n"
				+"> To change the difficulty, click on the drop down difficulty menu; and select between easy, medium, or hard.\n"
				+"\n"
				+ "Note:\n"
				+ "- When you fail a match, both tiles will remain flipped for two seconds, then the turn ends and you continue to the next.\n"
				+ "- When a match is succesful, the current turn continues; IE the turn count doesn't increase.\n"
				+ "- You can quit the game and see the symbols on all the tiles you didn't 'flip' over by clicking the 'quit' button in the menu bar\n"
				+ "- After beating the game, you will be sent to the victory screen which will ask you to input your name so it can be sent to the leaderboard,\n as well as being given the 'quit' and 'play again' options!";
		return text;
		
	}
	

	
	
	
}