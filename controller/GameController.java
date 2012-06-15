package controller;

import java.util.Scanner;
import java.util.ArrayList;

import view.*;
import model.*;

public class GameController {
	private static GameController gc;
	GameModel gm;
	GameCLView gv;
	
	boolean win=false;
	
	private GameController() {
		gm = new GameModel();
		gv = new GameCLView(gm);
	}
	
	public static GameController get() {
		if (gc==null)
			gc=new GameController();
		return gc;
	}
	
	public void newPassword() {
		gv.printGetPassword();
		
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<gm.getPasswordLength(); i++)
			tmp.add(sc.nextInt());
	
		gm.setPassword(new PasswordModel(tmp));
	}
	
	public void newGame() {
		gm.clearAttempts();
		this.newPassword();
	}
	
	public void saveGame() {
		
	}
	
	public void loadGame() {
		
	}
	
	public void runGame() {
		this.newGame();
		
		while (gm.getAttemptsLeft()>0) {
			gv.printAttempt();
		}
	}
}
