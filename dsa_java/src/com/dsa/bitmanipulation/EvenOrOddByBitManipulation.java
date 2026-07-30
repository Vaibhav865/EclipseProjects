package com.dsa.bitmanipulation;

public class EvenOrOddByBitManipulation {

	public static void main(String[] args) {
		
		int bitMask = 1;
		int n = 11;
		if((n & bitMask) == 0) IO.println("Even");
		else IO.println("Odd");
		
	}

}
