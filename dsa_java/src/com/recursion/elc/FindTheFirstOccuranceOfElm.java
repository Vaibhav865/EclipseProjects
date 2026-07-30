package com.recursion.elc;

public class FindTheFirstOccuranceOfElm {

	public static void main(String[] args) {
		int[] arr = {1,2,2,1,4,46,4,66,9};
		
		IO.println(firstOccurance(arr, 0, 9));
	}

	public static int firstOccurance(int[] arr,int i, int key ) {
		if(i == arr.length) return -1;
		
		if(arr[i] == key) {
			return i;
		}
		
		return firstOccurance(arr, i, key);
		
		
	}
	
}
