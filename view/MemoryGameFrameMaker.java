package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;

import edu.wm.cs.cs301.guimemorygame.controller.DifficultySelector;
import edu.wm.cs.cs301.guimemorygame.model.GameBoard;


public class MemoryGameFrameMaker{
	public GameBoard board;
	public MemoryGame gridPanel;
	public JFrame frame;
	private JMenuBar menubar;
	public LeaderboardDisplay lDisplay;
	
	public MemoryGameFrameMaker(String diff) {
		
		this.gridPanel= new MemoryGame(new GameBoard(diff),this);
		this.board=gridPanel.board;
		this.menubar=new JMenuBar();
		this.lDisplay=new LeaderboardDisplay();
		
		this.frame=createAndShowGUI();
		frame.setVisible(true);
	}
	
	private JFrame createAndShowGUI() {
		
		JFrame frame = new JFrame("Memory Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//should close everything 
		//change back to nothing?
		//frame.setJMenuBar(createMenuBar());
		frame.setResizable(false);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			 public void windowClosing(WindowEvent event) {
				shutdown();
			}
		});
		
		frame.add(createTitlePanel(), BorderLayout.NORTH);
		frame.add(gridPanel.getPanel(), BorderLayout.CENTER);
		frame.add(gridPanel.getPanelLabel(), BorderLayout.SOUTH);
		//frame.add(keyboardPanel.getPanel(), BorderLayout.SOUTH);
		
		frame.setSize(700, 600);
		frame.setLocationByPlatform(true);
		frame.setJMenuBar(createMenuBar());
		frame.setVisible(true);
		
		System.out.println("Frame size: " + frame.getSize());
		
		return frame;
	}
	
	private JMenuBar createMenuBar() {
		JMenuBar menuBar=new JMenuBar();
		
		JMenu difficulty=new JMenu("Difficulty");
		menuBar.add(difficulty);
		
		JMenuItem instructions = new JMenuItem("Instructions");
		menuBar.add(instructions);
		
		instructions.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				new InstructionsDisplay();
				}
			});
		
		JMenuItem quit=new JMenuItem("Quit");
		menuBar.add(quit);
		
		quit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				gridPanel.quitButtonPressed();
				}
			});
		
		menuBar.add(gridPanel.menuTurn);
		
		JMenuItem easy=new JMenuItem("Easy");
		difficulty.add(easy);
		easy.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				diffSelect("Easy");
				}
			});
		
		
		JMenuItem medium=new JMenuItem("Medium");
		difficulty.add(medium);
		medium.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				diffSelect("Medium");
				}
			});
		
		JMenuItem hard=new JMenuItem("Hard");
		difficulty.add(hard);
		hard.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				diffSelect("Hard");
				}
			});
		
		
		return menuBar;

	}
	
	private JPanel createTitlePanel() {
		JPanel panel = new JPanel(new FlowLayout());
		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
		
		InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "cancelAction");
		ActionMap actionMap = panel.getActionMap();
		actionMap.put("cancelAction", new CancelAction());
		
		JLabel label = new JLabel("Memory Game");
		label.setFont(AppFonts.getTitleFont());
		panel.add(label);
		
		return panel;
	}
	
	public void shutdown() {
		//board.leaderBoardMaker().writeStatistics();
		frame.dispose();
		
		System.exit(0);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	private class CancelAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent event) {
			
			shutdown();
		}
		
	}

	public String getDifficulty() {
		return board.getDifficulty();
	}

	public void diffSelect(String diff) {

		new DifficultySelector(this, diff);
	}
	


	
}