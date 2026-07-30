package com.dsa.bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class GetIthBit {

	public static void main(String[] args) {
		int n = 10 ;
		int i = 2;
		int bitMask = 1<<i ;
		
		if((n & bitMask) == 0) IO.println("Even");
		else IO.println("Odd");

	}

}
