package edu.wm.cs.cs301.guimemorygame.model;

public interface GamePiece {
	public boolean equals(GamePiece other);
	//The equals() method is used to compare a given string to the specified object. 
	//The result is true if and only if the argument is not null and is a String object
	//that represents the same sequence of characters as this object.
	//For Equals GamePiece other, it will be used to see if two tiles match.
	
	public void setVisible(boolean v);
	//public void setVisible(boolean status): This method sets the visibility of a component 
	//to visible or not. If it sets to true then the component will be visible in the output else
	//if it sets to false or not defined component won’t be visible in the output.
	////so that the piece can be switched over and back again
	
	public boolean isVisible();
	//Gets a value indicating whether the mark is visible or not. 
	//Is this supposed to be get visible?
	//so that the piece can be inspected to see if the game is won
	
	public Character getSymbol();
	
	//enforces the Character return type and used by equals
	//Should it be char and not Character?
}
