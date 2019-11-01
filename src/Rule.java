import java.util.ArrayList;

public class Rule {

	private int state;
	private int charRead;
	private int charWrite;
	private int move;
	private int transition;
	
	public Rule(int state, int charRead, int charWrite, int move, int transition) {
		this.state = state;
		this.charRead = charRead;
		this.charWrite = charWrite;
		this.move = move;
		this.transition = transition;
	}
	public Rule() {

	}
	
	
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getCharRead() {
		return charRead;
	}
	public void setCharRead(int charRead) {
		this.charRead = charRead;
	}
	public int getCharWrite() {
		return charWrite;
	}
	public void setCharWrite(int charWrite) {
		this.charWrite = charWrite;
	}
	public int getMove() {
		return move;
	}
	public void setMove(int move) {
		this.move = move;
	}
	public int getTransition() {
		return transition;
	}
	public void setTransition(int transition) {
		this.transition = transition;
	}

	public String toString(){
		return("[" + this.state + ", " + this.charRead + ", " + 
				this.charWrite + ", " + this.move + ", " + this.transition + "]");
	}

	
	

}
