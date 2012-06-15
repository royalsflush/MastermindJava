package model;

import java.util.ArrayList;

import model.PasswordModel;

public class GameModel {
	PasswordModel currentPassword;
	int totalAttempts=3;
	int passwordLength=5;
	ArrayList<PasswordModel> attempts;
	
	public GameModel() {
		attempts=new ArrayList<PasswordModel>();
	}
	
	public void setPassword(PasswordModel newPassword) {
		currentPassword=newPassword;
	}
	
	public void setTotalAttempts(int nAttempts) {
		totalAttempts=nAttempts;
	}
	
	public int getAttemptsLeft() {
		return totalAttempts-attempts.size();
	}
	
	public ArrayList<PasswordModel> getAttemptsList() {
		return attempts;
	}
	
	public int getPasswordLength() {
		return passwordLength;
	}
	
	public PasswordModel getPassword() {
		return currentPassword;
	}
	
	public void addAttempt(PasswordModel p) {		
		attempts.add(p);
	}
	
	public void clearAttempts() {
		attempts.clear();
	}
}