package com.recursion.elc;

public class Factorial {

	public static void main(String[] args) {
	
		int n = 5 ;
		
		IO.println(factorialCal(n));
			
	}
	
	public static int factorialCal(int n ) {
		if(n == 0) {
			return 1;
		}
		  
		int fct1 = factorialCal(n-1);
		int fn = n * factorialCal(n-1);
		return fn;
		
	}

}
