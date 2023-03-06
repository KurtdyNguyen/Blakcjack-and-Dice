package objects;

public class player {
	private String name;
	private int currentScore;
	private boolean are_you_a_bot;
	private dice dice;

	public static void main(String[] args) {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public boolean are_you_a_bot() {
		return are_you_a_bot;
	}
	
	public dice getDice() {
		return dice;
	}
}
