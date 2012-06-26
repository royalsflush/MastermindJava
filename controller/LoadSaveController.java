package controller;

import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import model.*;

public class LoadSaveController {
	GameModel gm;
	JFileChooser theFileChooser;
	JFrame parent;

	public LoadSaveController(GameModel pGm) {
		gm=pGm;
		theFileChooser = new JFileChooser();
		parent = new JFrame();
	}

	private void writeToFile(File f) {
		try {
			FileWriter fw = new FileWriter(f);

			ArrayList<PasswordModel> pl = gm.getAttemptsList();

			fw.write(Integer.toString(gm.getPasswordLength())+" ");
			fw.write(Integer.toString(gm.getTotalAttempts())+"\n");

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

	private void readFromFile(File f) {
		try {
			Scanner sc = new Scanner(f);
			int pwLength = sc.nextInt();

			gm.setPasswordLength(pwLength);
			gm.setTotalAttempts(sc.nextInt());
			ArrayList<Integer> pw = new ArrayList<Integer>();

			for (int i=0; i<pwLength; i++)
				pw.add(new Integer(sc.nextInt()));
			gm.setPassword(new PasswordModel(pw));

			int plLength = sc.nextInt();
			ArrayList<PasswordModel> pl = new ArrayList<PasswordModel>();

			for (int i=0; i<plLength; i++) {
				ArrayList<Integer> tmp = new ArrayList<Integer>();

				for (int j=0; j<pwLength; j++)
					tmp.add(new Integer(sc.nextInt()));
				pl.add(new PasswordModel(tmp));
			}
			gm.setAttempts(pl);

			sc.close();
		}
		catch (Exception e) {
			System.out.println("Oops, no loading for you!");
			return;
		}
	}

	public void saveGame() {
		int returnVal = theFileChooser.showSaveDialog(parent);
	
		if (returnVal==JFileChooser.APPROVE_OPTION)
			writeToFile(theFileChooser.getSelectedFile());
	}

	public void loadGame() {
		int returnVal = theFileChooser.showOpenDialog(parent);
		
		if (returnVal==JFileChooser.APPROVE_OPTION)
			readFromFile(theFileChooser.getSelectedFile());
	}
}
