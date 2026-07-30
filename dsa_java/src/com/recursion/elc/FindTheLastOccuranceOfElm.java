package com.recursion.elc;

public class FindTheLastOccuranceOfElm {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,653,23,2,3,1,2};
		int i = arr.length-1;
		IO.println(lastOccurance(arr, i,3));
		
	}
	
	public static int lastOccurance(int[] arr, int i , int key) {
		
		if(i == 0) return -1;
		if(arr[i] == key) return i ;
		return lastOccurance(arr, i-1, key);
		
		
	}
	
}
