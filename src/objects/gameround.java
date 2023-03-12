package objects;

import java.util.ArrayList;
import java.util.List;

public class gameround {
	public List<player> players = new ArrayList<player>();
	public int currentPlayer, winner;
	public boolean done;
	
	public void calculatePoint(int currentPlayer, int roundPoint) {
		player thisPlayer = players.get(currentPlayer);
		int newScore = thisPlayer.getCurrentScore() + roundPoint;
		if (newScore > 21) {
			thisPlayer.setCurrentScore(0);
		}
		else {
			if (newScore == 21) {
				done = true;
				winner = currentPlayer;
			}
			thisPlayer.setCurrentScore(newScore);
		}
	}	
	
	public List<player> getPlayers() {
		return players;
	}



	public void setPlayers(List<player> players) {
		this.players = players;
	}



	public int getCurrentPlayer() {
		return currentPlayer;
	}



	public void setCurrentPlayer(int currentPlayer) {
		this.currentPlayer = currentPlayer;
	}



	public boolean isDone() {
		return done;
	}



	public void setDone(boolean done) {
		this.done = done;
	}



	public int getWinner() {
		return winner;
	}



	public gameround() {
		
	}
	
	public static void main(String[] args) {
		
	}

}
