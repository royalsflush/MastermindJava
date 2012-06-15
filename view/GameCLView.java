package view;

import java.util.ArrayList;

import model.*;

public class GameCLView {
	GameModel gm;
	
	public GameCLView(GameModel g) {
		gm=g;
	}
	
	public void printGetPassword() {
		System.out.println("Type the new password:");
	}
	
	public void printAttemptRequest() {
		System.out.printf("You have %d attempts remaining\n",
				gm.getAttemptsLeft());
		System.out.println("Make a new attempt:");
	}
	
	public void printPassword(PasswordModel p) {
		for (int i=0; i<p.length(); i++)
			System.out.printf("%d ", p.get(i));
		
		if (p.length()!=0)
			System.out.printf("\n");
	}
	
	public void printClues(PasswordModel p) {
		PasswordModel pw = gm.getPassword();
		System.out.printf("%d %d\n", pw.exactMatch(p),
				pw.outOfPlaceMatch(p));
	}
	
	public void printAttemptsList() {
		PasswordModel pw = gm.getPassword();
		ArrayList<PasswordModel> pl = gm.getAttemptsList();
		
		for (int i=0; i<pl.size(); i++) {
			printPassword(pl.get(i));
			printClues(pl.get(i));
		}
		
		System.out.println();
	}
	
	public void printYouWin() {
		System.out.println("Congratulations, you guessed the password!");
	}
	
	public void printYouLose() {
		System.out.println("Better luck next time!");
	}
	
	public void printMenu() {
		System.out.println("From here, you can:");
		System.out.println("Make an attempt - type '1'");
		System.out.println("Start a new game - type '2'");
		System.out.println("Save game - type '3'");
		System.out.println("Load the saved game - type '4'");
		System.out.println("Quit - type '5'");
		System.out.println();
	}
	
	public void printEndMenu() {
		System.out.println("From here, you can:");
		System.out.println("Start a new game - type '1'");
		System.out.println("Quit - type '2'");
		System.out.println();
	}
}