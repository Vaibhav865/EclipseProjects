package com.vaibhav.array;

import java.awt.List;
import java.util.Arrays;
import java.util.stream.Stream;

public class findMissingNum {

	public static void main(String[] args) {
		
		List  arr = new List.of{1,2,3,5};
		
		int n = arr.length;
		int missingNum = n * (n-1)/2;
		Integer sum =  Arrays.stream(arr).mapToInt(Integer::a).sum();
		
		
		IO.println(missingNum-n);
		
	}

}
