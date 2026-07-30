package com.recursion.elc;

public class IncreasingOrder {

	public static void main(String[] args) {
		
		int n = 10 ;
		PrintInc(n);
		
	}
	
	public static void PrintInc(int n ) {
		if(n == 1) {
			IO.println(n);
			return;
		}
		
		PrintInc(n-1);
		IO.println(n);
		
	}

}
