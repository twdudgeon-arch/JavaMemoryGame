package edu.wm.cs.cs301.guimemorygame.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LeaderBoardMaker{
	private String difficulty;
	private String name;
	private int turns;
	private Path path;
	private List<String> lines;
	
	//Check how to scan for the turn count and compare
	
	public LeaderBoardMaker(String diff, String n, int turn) {
		this.difficulty=diff;
		this.name=n;
		this.turns=turn;
		
		this.path = Paths.get("C:\\Users\\twdud\\git\\GUIMemoryGameByTateDudgeon\\Resources\\leaderboard.txt");
		try {
			this.lines= Files.readAllLines(path, StandardCharsets.UTF_8);;
		
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
		if(lines.size()==0) {
			
		}
		makeLeader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    

		
		this.difficulty=diff;
		this.name=n;
		this.turns=turn;
		//makeLeader();
	}
	
	public void makeLeader() throws FileNotFoundException {
		if(this.difficulty.equals("Easy")) {
			if(scoreChecker(1, this.turns)){
				lines.set(0, "Easy:"+"\t"+name+","+"\t"+turns);
			}
		}
		
		if(this.difficulty.equals("Medium")) {
			if(scoreChecker(2, this.turns)) {
				lines.set(1, "Medium:"+"\t"+name+","+"\t"+turns);
			}
		}
		if(this.difficulty.equals("Hard")) {
			if(scoreChecker(3, this.turns)) {
				lines.set(2, "Hard:"+"\t"+name+","+"\t"+turns);
			}
		}
		try {
			Files.write(path, lines, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean scoreChecker(int loop, int turn) throws FileNotFoundException {
		//Have it look for the line based on difficulty, then take the int to compare later
		BufferedReader myReader=new BufferedReader(new FileReader("C:\\Users\\twdud\\git\\GUIMemoryGameByTateDudgeon\\Resources\\leaderboard.txt"));
		Scanner myRead=new Scanner(myReader);
		String line=myRead.nextLine();
		if (loop>1) {
			line=myRead.nextLine();
		}
		if(loop>2) {
			line=myRead.nextLine();
		}
		String Score=line.replaceAll("[\\D]","");
		System.out.println(Score);
		myRead.close();
		if (Score.equals("")) {
			return true;
		}else if(Integer.parseInt(Score)>=turn) {
			return true;
		}
		return false;
		
		
	}
}