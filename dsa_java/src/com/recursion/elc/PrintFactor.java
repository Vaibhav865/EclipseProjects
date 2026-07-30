package com.recursion.elc;

public class PrintFactor {

	public static void main(String[] args) {
		IO.println(fact(2,10));
	}

	private static long fact(int i, int j) {
		if(j == 0) return 1;
		return i * fact( i, j-1);
	}

}
