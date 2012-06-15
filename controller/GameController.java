package controller;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import view.*;
import model.*;

public class GameController {
	private static GameController gc;
	GameModel gm;
	GameCLView gv;
	
	boolean win=false;
	boolean run=true;
	
	private GameController() {
		gm = new GameModel();
		gv = new GameCLView(gm);
	}
	
	public static GameController get() {
		if (gc==null)
			gc=new GameController();
		return gc;
	}
	
	public PasswordModel getPassword() {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<gm.getPasswordLength(); i++)
			tmp.add(sc.nextInt());
	
		return new PasswordModel(tmp);
	}
	
	public int getOption() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	public void newPassword() {
		gv.printGetPassword();
		PasswordModel pw = getPassword();
		gm.setPassword(pw);
	}
	
	public void newGame() {
		gm.clearAttempts();
		this.newPassword();
	}
	
	public void saveGame() {
		File f = new File("save.txt");
		
		try {
			FileWriter fw = new FileWriter(f);
			
			ArrayList<PasswordModel> pl = gm.getAttemptsList();
			
			fw.write(Integer.toString(gm.getPasswordLength())+" ");
			fw.write(Integer.toString(gm.getTotalAttempts())+" ");
			
			PasswordModel pw = gm.getPassword();
		
			for (int i=0; i<gm.getPasswordLength(); i++)
				fw.write(Integer.toString(pw.get(i))+" ");

			fw.write("\n"+Integer.toString(pl.size())+"\n");
			
			for (int i=0; i<pl.size(); i++) {
				for (int j=0; j<gm.getPasswordLength(); j++)
					fw.write(Integer.toString(pl.get(i).get(j))+" ");
				fw.write("\n");
			}
				
			fw.flush();
			fw.close();
		}
		catch (IOException e) {
			System.out.println("Oops, no saving for you!");
			return;
		}
	}
	
	public void loadGame() {
		
	}
	
	public void runGame() {
		while (run) {
			this.newGame();
		
			while (gm.getAttemptsLeft()>0 && !win && run) {
				gv.printMenu();
				int opt = this.getOption();
			
				switch (opt) {
					case 1:
						gv.printAttemptsList();
						gv.printAttemptRequest();
						PasswordModel attempt=this.getPassword();
			
						gm.addAttempt(attempt);
						gv.printClues(attempt);
						PasswordModel pw = gm.getPassword();
						
						if (pw.exactMatch(attempt)==gm.getPasswordLength())
							win=true;
						break;
					case 2:
						this.newGame();
						break;
					case 3:
						this.saveGame();
						break;
					case 4:
						this.loadGame();
						break;
					case 5:
						run=false;
						break;
				}
			}	
				
			if (run) {
				if (win)
					gv.printYouWin();
				else
					gv.printYouLose();
				
				gv.printEndMenu();
				
				int opt = this.getOption();
				
				switch (opt) {
					case 1:
						break;
					case 2:
						run=false;
				}
			}
		}
	}
}
