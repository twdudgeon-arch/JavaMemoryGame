package edu.wm.cs.cs301.guimemorygame.view;

import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JLabel;

import edu.wm.cs.cs301.guimemorygame.model.GameBoard;
import edu.wm.cs.cs301.guimemorygame.model.LeaderBoardMaker;

public class LeaderboardDisplay{
	
	
	/*private int scorecomp;
	private Scanner myRead;
	private int eturn, mturn, hturn;
	private String EScore,MScore,HScore;
	private BufferedReader  myReader;
	private String ln;
	private String difficulty;
	private String name;
	private int turn;*/
	public JFrame LFrame;
	   public LeaderboardDisplay(){
		
		   /*this.scorecomp=0;
		   EScore="Easy:";
		   MScore="Medium:";
		   HScore="Hard:";*/
			
		   //this.myRead=new Scanner(myReader);
			
			//System.out.println(myRead.nextLine());
		   //System.out.println(leaderBoardText());
		   LeaderBoardWindow().setVisible(true);
		   
	   }
	   
	   public JFrame LeaderBoardWindow() {
		   this.LFrame=new JFrame("Leaderboard");
			LFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			LFrame.setLayout(new BorderLayout());
			
			LFrame.add(new TextArea(leaderBoardText()), BorderLayout.CENTER);
			LFrame.pack(); //Change to set size
			LFrame.setVisible(true);
			LFrame.setLocationRelativeTo(null);
		   
		   
		   return LFrame;
	   }
	   
	   public String leaderBoardText() {
		   try{  
			   File file=new File("C:\\Users\\twdud\\git\\GUIMemoryGameByTateDudgeon\\Resources\\leaderboard.txt");    //creates a new file instance  
			   FileReader fileRead=new FileReader(file);   
			   BufferedReader buffered=new BufferedReader(fileRead);  
			   StringBuffer stringBuff=new StringBuffer();  
			   String line;  
			   while((line=buffered.readLine())!=null){  
				   stringBuff.append(line);      
				   stringBuff.append("\n");     
		   			}  
			   fileRead.close();    
			   //System.out.println("Contents of File: ");  
			   //System.out.println(stringBuff.toString());   
			   return stringBuff.toString();
		   }catch(IOException e){  
			   e.printStackTrace();
			   }
		   	return "";
		   
		   }  
	   

}