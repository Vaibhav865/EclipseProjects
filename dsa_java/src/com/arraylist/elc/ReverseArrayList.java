package com.arraylist.elc;

import java.util.ArrayList;

public class ReverseArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer>  al = new ArrayList<>();
		
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(5);
		al.add(6);
		
		IO.println(al);
		
		for(int i = al.size()-1; i>=0 ; i--) {
			IO.println(al.get(i) );
		}
		
		
	}

}
