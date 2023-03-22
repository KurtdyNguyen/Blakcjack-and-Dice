package objects;

public class player {
	private String name;
	private int currentScore;
	private boolean isBot;
	private dice dice;
	
	public player(String name, boolean isBot, int diceNum) {
		this.name = name;
		this.isBot = isBot;
		this.dice = new dice(diceNum);
	}
	
	public int roll() {
		int val = this.dice.roll();
		return val;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public boolean isBot() {
		return isBot;
	}
	
	public dice getDice() {
		return dice;
	}
	
	public void lastWords() {
		if(this.isBot)
			System.out.println("Beep. Bop. I'll be back.");
		else
			System.out.println("Putang ina mo.");
	}
	
	public static void main(String[] args) {
		player Minh = new player("Minh", false, 3);
		int testChance = 0;
		for(int i = 0; i < 100; i++) {
			if(Minh.roll() == Minh.getDice().getNum().get(0))
				testChance++;
		}
		System.out.println(testChance);
	}
}
