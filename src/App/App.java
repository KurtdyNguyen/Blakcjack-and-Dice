package App;

import java.util.InputMismatchException;
import java.util.Scanner;

import objects.*;

public class App {
	public int nPlayer;
	public gameround gameround;
	
	public App(){
		System.out.println("\nEnter the number of players(from 1 to 4 players): ");
		Scanner scan = new Scanner(System.in);
		try {
			int nPlayer = scan.nextInt();
			while(nPlayer > 4 || nPlayer < 1) {
				System.out.println("\nWrong input. Please enter the number of players again(1-4): ");
				nPlayer = scan.nextInt();
			}
		} catch(InputMismatchException e){
			System.out.println("\nInvalid input. Not an integer.");
			e.printStackTrace();
			scan.close();
		}
		scan.close();
	}

	public static void main(String[] args) {
		new App();
	}

}
