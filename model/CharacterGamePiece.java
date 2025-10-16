package edu.wm.cs.cs301.guimemorygame.model;//when you come back to this, figure out what each method does

public class CharacterGamePiece implements GamePiece {
	private final Character symbol;
	private boolean visible;
	
	public CharacterGamePiece(char s) {
		this.symbol = s;
		this.visible=false;
	}


	public boolean equals(GamePiece other) {
		if (this.symbol==other.getSymbol()) {
			return true;
		}
		return false;
	}


	public void setVisible(boolean v) {
		this.visible=v;
		
	}


	public boolean isVisible() {
		return this.visible;
	}


	public Character getSymbol() {
		return this.symbol;
	}
	
}