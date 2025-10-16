package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.wm.cs.cs301.guimemorygame.controller.DifficultySelector;
import edu.wm.cs.cs301.guimemorygame.model.GameBoard;
import edu.wm.cs.cs301.guimemorygame.model.LeaderBoardMaker;



public class VictoryDisplay{
	//private JEditorPane editPane;
	public JFrame frame;
	private JTextField inputField;
	//private JButton playAgain;
	//private JButton exit;
	private JButton submit;
	public String name;
	public int turn;
	private JLabel congrats;
	private String difficulty;
	private boolean exists=true;
	private boolean nextTime;
	private MemoryGame game;

	//private TextArea description; figure out how to use?
	
	
	public VictoryDisplay(MemoryGame game) {
		this.game=game;
		this.turn=game.getTurnCount();//This good? Check what goes into the input?
		this.difficulty=game.getDifficulty();
		
		//this.difficulty="Medium";
		//this.turn=3;
		this.frame=createVictoryFrame();
		
	}
	

	private JFrame createVictoryFrame() {
		JFrame frame=new JFrame("Victory Screen");
		this.congrats=new JLabel("CONGRATULATIONS!");
		this.nextTime=false;
		
		congrats.setFont(new Font("Calibri",Font.BOLD, 40));
		
		/*this.description=new TextArea("You win! Please Type in your Name Below\n and click the 'submit'"
				+ " button if You Want Your Turn Score of # To be Recorded!\n"
				+ "(Please do not input a number in/for your name!)");*/
		
		
		//congrats.setFont(new Font("Calibri",Font.PLAIN, 18));
				
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.add(congrats);
		//frame.add(description);
		
		//Figure out if there is a way of making this neater after getting everything to work
		frame.add(new JLabel("You win! please type in your name below and click the"));
		frame.add(new JLabel("'submit' button if You want your turn score of # Recorded!"));
		frame.add(new JLabel("Note: It will only allow one submit for your name!"));
		frame.add(new JLabel("So be very careful if you decide to type your name!"));
		frame.add(new JLabel("(Please do not input a number in/for your name!)"));
		// 
		frame.add(nameInput());
		frame.add(createBottomButtonsPanel());
		
		frame.setLocationRelativeTo(null);
		frame.setSize(550, 550);
		frame.setVisible(true);
		return frame;
	}
	
	private JPanel createBottomButtonsPanel() {//Edit the sizes and font sizes?
		//creates the two bottom buttons for victory screen
		
		//add action events to the buttons, and tie them to either closing the game or replaying
		JPanel bottomPane=new JPanel();
		JButton playAgain=new JButton("Play Again");
		playAgain.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				//make method(s) that close the other windows, and then makes a new game with the same difficulty
				victoryClose();
				//new MemoryGameFrameMaker(new MemoryGame(new GameBoard(difficulty)));
				}
			});
		
		JButton quit=new JButton("Quit");
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);//this is how to close the program, right?
				}
			});
		
		bottomPane.setLayout(new FlowLayout());
		bottomPane.add(playAgain);
		bottomPane.add(quit);
		
		return bottomPane;
	}
	
	private JPanel nameInput() {//Edit the sizes and font sizes?
		//Create a bar that allows user to input their name, and the submit button beneath it
		//Have the input work; ONCE!
		JPanel inputPane=new JPanel();
		inputField=new JTextField();
		inputField.setPreferredSize(new Dimension(150,30));
		///inputField.setBounds(0,0,150,10);
		submit=new JButton("Submit");
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inputField.getText().isEmpty()) {
					//System.out.println("No blank names please!");
				}else if(nextTime){
					//System.out.println("Already updated Leaderboard");
				}else {
					name=inputField.getText();
					new LeaderBoardMaker(difficulty, getName(), turn);
					System.out.println(difficulty+":"+"\t"+getName()+","+"\t"+turn);
					nextTime=true;
					System.out.println("Leaderboard updated!");
					inputField.setEnabled(false);
					submit.setEnabled(false);
				//LeaderBoardMaker(String diff, String n, int turn)
					}
				}
			});
		inputPane.setLayout(new FlowLayout());
		//inputPane.setSize(100,100);
		inputPane.add(inputField);
		inputPane.add(submit);
		
		return inputPane;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean existsConfirm() {
		return this.exists;
	}
	
	public void victoryClose() {
		frame.dispose();
		new DifficultySelector(game.frameMaker,difficulty);
	}
}