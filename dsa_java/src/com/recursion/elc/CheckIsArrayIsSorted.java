package com.recursion.elc;

public class CheckIsArrayIsSorted {

	public static void main(String[] args) {
		int[] arr = {1,0,3,5,6,7,8,9};
		IO.println(isSorted(arr, 0));
	}
	
	
	public static boolean isSorted(int []arr, int i ) {
		if(i == arr.length-1) {
			return true;
		}
		
		if(arr[i] > arr[i+1]) {
			return false;
		}
		
		return isSorted(arr,i+1);
		
	}
}
