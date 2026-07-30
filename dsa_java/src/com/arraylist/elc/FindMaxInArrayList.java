package com.arraylist.elc;

import java.util.*;


public class FindMaxInArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer>  al = new ArrayList<>();
		

		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		al.add(9);
		al.add(6);
		
		IO.println(al);
		int max = Integer.MIN_VALUE;
		for(Integer a : al) {
//			if(a>max) max =a ;
			max = Math.max(max,a);
		}
		IO.println(max);
		
	}

}
