package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.concurrent.TimeUnit;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import edu.wm.cs.cs301.guimemorygame.model.GameBoard;
import edu.wm.cs.cs301.guimemorygame.model.GamePiece;

public class MemoryGame extends JPanel{
	private static final long serialVersionUID = 1L;
	public JButton[][] buttonGrid;
	public JFrame frame;
	public JPanel panel;
	public GameBoard board;
	public GamePiece symbolCheck=null;
	public JButton buttonStore=null;
    private Timer timer;
    public boolean matchIsRunning=false;
    public int turnCount;
    private JLabel eventLabel;
    private JPanel panelLabel;
	public LeaderboardDisplay lDisplay;
	public MemoryGameFrameMaker frameMaker;
	public JMenuItem menuTurn;
    
	public MemoryGame(GameBoard b,MemoryGameFrameMaker frameMaker) {
		this.frameMaker=frameMaker;
		this.turnCount=0;
		this.board=b;
		this.buttonGrid=new JButton[board.getMaxRows()][board.getMaxCols()];
		this.setButtonGrid(board);
		
		menuTurn= new JMenuItem("Turn: "+getTurnCount());
		
		
		//TURN THIS INTO JUST A PANEL FOR MEMORYGAMEFRAMEMAKER
		panel=new JPanel(new GridLayout(board.getMaxRows(),board.getMaxCols(),10,10));
		
		for (int row = 0; row < board.getMaxRows(); row++) {
		    for (int col = 0; col < board.getMaxCols(); col++) {
		    	panel.add(this.buttonGrid[row][col]);
		    }
		}
		
		panelLabel=new JPanel();
		eventLabel=new JLabel("		");
		
		eventLabel.setFont(new Font("Calibri",Font.PLAIN, 20));
		panelLabel.add(eventLabel);
		//panelLabel.add(turnLabel);
		eventLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		/*for (int i=0; i<(board.getMaxRows()*board.getMaxCols()); i++) {
			
			JButton button=new JButton("?");
			button.setPreferredSize(new Dimension(10,10));
			button.setBorder( new LineBorder(Color.BLACK) );
			button.setFont(new Font("Arial", Font.PLAIN, 40));
			panel.add(button);
			
			
		}*/
		
		//frame.add(panel);
		
		//frame.setVisible(true);
	}
	
	public JPanel getPanel() {
		//panel.setVisible(true);
		this.setVisible(true);
		return panel;
	}
	
	public JLabel getPanelLabel() {
		panelLabel.setVisible(true);
		return eventLabel;
	}
	

	public void setButtonGrid(GameBoard board){
		//method for this type of button?
		
		//JButton[][] buttonGrid=new JButton[board.getMaxRows()][board.getMaxCols()];
		for (int row = 0; row < board.getMaxRows(); row++) {
		    for (int col = 0; col < board.getMaxCols(); col++) {
		    	/*JButton button=new JButton("?");
				button.setPreferredSize(new Dimension(10,10));
				button.setBorder( new LineBorder(Color.BLACK) );
				button.setFont(new Font("Arial", Font.PLAIN, 40));*/
				
				JButton button=this.mGameButton("?", row, col);
				
				this.buttonGrid[row][col]=button;
		
		
		    }	
	}
		//this.buttonGrid=buttonGrid;
}
	
	public JButton mGameButton(String string, int row, int col) {
		JButton button=new JButton(string);
		button.setPreferredSize(new Dimension(10,10));
		button.setBorder( new LineBorder(Color.BLACK) );
		button.setFont(new Font("Arial", Font.PLAIN, 40));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				if (button.getText().equals("?")) {
					//button.setText(String.valueOf(board.board[row][col].getSymbol()));
					
					try {
						flippedButton(button, row, col);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else {
					eventLabel.setText("Tile Already Flipped! Pick unflipped tile please!");
				}
			}
		});
		return button;
	}
	
	public void flippedButton(JButton buttonChange, int row, int col) throws InterruptedException {
		if (this.matchIsRunning) { //make it so they also change the game pieces to true?
			eventLabel.setText("Match is currently running");
			
		}else {
		buttonChange.setText(String.valueOf(board.board[row][col].getSymbol()));
		board.board[row][col].setVisible(true);
		//Only need one of the above?
		
		if (symbolCheck==null) {
		//button.setText("A");//Figure out how to get Symbol into here?
			//buttonChange.setText(String.valueOf(board.board[row][col].getSymbol()));
			symbolCheck=board.board[row][col]; //set to true or false!!!!
			buttonStore=this.buttonGrid[row][col];
		}else {
			//buttonChange.setText(String.valueOf(board.board[row][col].getSymbol()));
			if (symbolCheck.equals(board.board[row][col])){
				//buttonChange.setText(String.valueOf(board.board[row][col].getSymbol()));
				
				eventLabel.setText("It's a Match!");
				symbolCheck=null;
				buttonStore=null;
				checkIfWon();
				
			}else {
				this.matchIsRunning=true;
				//turn them both back to normal buttons here, have the 2 second pause
				//2 second pause here
				
				eventLabel.setText("It's not a Match...");
				//panel.updateUI();
				twoSecondPause(buttonChange);
				this.turnCount++; //adds to the turn count after the pause
				menuTurn.setText("Turn: "+getTurnCount());
				board.board[row][col].setVisible(false);
				symbolCheck.setVisible(false);
				
			}
			
			}
		}
		//return null; have it return a button?
	}
	
	
	
	public void twoSecondPause(JButton bc) {
		//make a new variable that checks if the timer is running?
		/*try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		timer = new Timer(2000, new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
			buttonStore.setText("?");
			bc.setText("?");
			symbolCheck=null;
			buttonStore=null;
			matchIsRunning=false;
            timer.stop();
			}
            });
        timer.start();
        timer.setRepeats(false);
	}
	
	public void checkIfWon() {
		
		if (board.isBoardVisible()) {
			//System.out.println("hello?");
			//disable each JButton
			for (int row = 0; row < board.getMaxRows(); row++) {
			    for (int col = 0; col < board.getMaxCols(); col++) {
			    	this.buttonGrid[row][col].setEnabled(false);
			    }
			    
			    eventLabel.setText("Congrats, you won!");
			    //lDisplay.LFrame.dispose();
			    
			}
			new VictoryDisplay(this);
		}
	}
	
	public void quitButtonPressed() {
		this.board.setBoardVisible();
		
		for (int row = 0; row < board.getMaxRows(); row++) {
		    for (int col = 0; col < board.getMaxCols(); col++) {
		    	this.buttonGrid[row][col].setText(String.valueOf(board.board[row][col].getSymbol()));
		    }
		}
		
		for (int row = 0; row < board.getMaxRows(); row++) {
		    for (int col = 0; col < board.getMaxCols(); col++) {
		    	this.buttonGrid[row][col].setEnabled(false);
		    }
		}
		
		eventLabel.setText("Game Quit");
	}
	
	public int getTurnCount() {
		return this.turnCount+1;
	}

	public String getDifficulty() {
		return this.board.getDifficulty();
	}

	
}
