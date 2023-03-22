package App;

import java.util.InputMismatchException;
import java.util.Scanner;

import objects.*;

public class App {
	public int nPlayer;
	public gameround gameround;
	
	public App(){
		Scanner scan = new Scanner(System.in);
		int nPlayer = 0;
		boolean done = false;
		while(!done) {
			try {
				System.out.println("\nEnter the number of players(from 1 to 4 players): ");
				nPlayer = scan.nextInt();
				if(nPlayer > 4 || nPlayer < 1) {
					System.out.println("\nWrong input. Not in range from 1 to 4.");
					scan.nextLine();
				} else {
					done = true;
				}
			} catch(InputMismatchException e){
				System.out.println("\nInvalid input. Not an integer.");
				scan.nextLine();
			}
		}
		System.out.println("\nGenerating players...");
		scan.close();
		
		this.nPlayer = nPlayer;
		this.gameround = new gameround();
		player currentPlayer;
		for(int i = 1; i <= 4; i++) {
			if(i <= nPlayer) {
				currentPlayer = new player(Integer.toString(i), false, i);
			} else {
				currentPlayer = new player(Integer.toString(i), true, i);
			}
			this.gameround.getPlayers().add(currentPlayer);
		}
		
		System.out.println("\n\tPLAYER LIST:");
		for(player p: this.gameround.getPlayers()) {
			System.out.println(p.getName() + "| NPC: " + p.isBot() + "| Dice weight: " + p.getDice().getNum().get(0));
		}
		System.out.println("\nThe game begins.");
		player player;
		while(!this.gameround.isDone()) {
			int current = this.gameround.getCurrentPlayer();
			player = this.gameround.getPlayers().get(current);
			int dice = player.roll();
			this.gameround.calculatePoint(current, dice);
			System.out.println("\nPlayer " + Integer.toString(current + 1) + "rolls a " + dice);
			System.out.println("\nPlayer " + Integer.toString(current + 1) + "current score: " + player.getCurrentScore());
			current++;
			if(current >= 4)
				current %= 4;
			this.gameround.setCurrentPlayer(current);
		}
		System.out.println("\nThe winner is decided. Player " + Integer.toString(this.gameround.getWinner() + 1) + "wins!");
		System.out.println("\n\t\tFINAL SCORE:");
		for(int i = 0; i < 4; i++) {
			System.out.printf("\nPlayer %d\t%-3d\n", i+1, this.gameround.getPlayers().get(i).getCurrentScore());
		}
		for(int i = 0; i < 4; i++) {
			if(i != this.gameround.getWinner())
				this.gameround.getPlayers().get(i).lastWords();
		}
	}

	public static void main(String[] args) {
		new App();
	}

}
