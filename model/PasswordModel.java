package model;

import java.util.ArrayList;

public class PasswordModel {
	ArrayList<Integer> pass;
	
	public PasswordModel(ArrayList<Integer> arr) {
		pass=arr;
		
		for (int i=0; i<arr.size(); i++)
			System.out.println(arr.get(i).intValue());
	}
	
	public int exactMatch(PasswordModel p) {
		return 0;
	}
	
	public int outOfPlaceMatch(PasswordModel p) {
		return 0;
	}
}
