package model;

import java.util.ArrayList;

public class PasswordModel {
	ArrayList<Integer> pass;
	
	public PasswordModel(ArrayList<Integer> arr) {
		pass=arr;
	}
	
	public int exactMatch(PasswordModel p) {
		int qtd=0;
		
		for (int i=0; i<pass.size(); i++)
			if (p.get(i)==this.get(i))
				qtd++;
		return qtd;
	}
	
	public int outOfPlaceMatch(PasswordModel p) {
		int qtd=0;
		
		for (int i=0; i<pass.size(); i++)
			for (int j=0; j<p.length(); j++)
				if (i!=j && p.get(i)==this.get(j))
					qtd++;
		return qtd;
	}
	
	public int get(int idx) {
		return pass.get(idx).intValue();
	}
	
	public int length() {
		return pass.size();
	}
}
