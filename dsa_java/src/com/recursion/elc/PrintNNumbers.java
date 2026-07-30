package com.recursion.elc;

public class PrintNNumbers {

	public static void main(String[] args) {
		
		int n = 10 ;
		
		PrintN(n);
	}
	
	public static void PrintN(int n) {
		if(n == 1 ) {
			IO.println(n);
			return;
		}
		IO.println(n);
		PrintN(n-1);
	}

}
