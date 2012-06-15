package view;

import model.*;

public class GameCLView {
	GameModel gm;
	
	public GameCLView(GameModel g) {
		gm=g;
	}
	
	public void printGetPassword() {
		System.out.println("Type the new password:");
	}
	
	public void printAttempt() {
		System.out.printf("You have %d attempts remaining\n",
				gm.getAttemptsLeft());
		System.out.println("Make a new attempt:");
	}
}