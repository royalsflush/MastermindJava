package model;

import java.util.ArrayList;

import model.PasswordModel;

public class GameModel {
	PasswordModel currentPassword;
	int totalAttempts=10;
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
	
	public void clearAttempts() {
		attempts.clear();
	}
	
	public int getAttemptsLeft() {
		return totalAttempts-attempts.size();
	}
	
	public int getPasswordLength() {
		return passwordLength;
	}
}