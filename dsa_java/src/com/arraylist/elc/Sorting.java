package com.arraylist.elc;

import java.util.*;

public class Sorting {

	public static void main(String[] args) {
		ArrayList<Integer>  al = new ArrayList<>();
		
		al.add(3);
		al.add(2);
		al.add(5);
		al.add(4);
		al.add(9);
		al.add(2);
		
		IO.println(al);
		IO.println("After sorting in increasing order");
		Collections.sort(al);
		IO.println(al);
		
		Collections.sort(al,Collections.reverseOrder());
		
		IO.println(al);
		
	}

}
