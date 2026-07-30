package com.practice.nit;

public class FindSecondLargestElemInArray {

	public static  int findSecondLagest(int[] arr) {
		int secondLar=Integer.MIN_VALUE;
		int firstLar=Integer.MIN_VALUE;
		
		for(int i = 0 ; i<arr.length;i++) {
			if(arr[i] >= firstLar) {
				firstLar = arr[i];
			}
		}
		
		for(int i = 0 ; i<arr.length ; i++) {
			if(arr[i]==firstLar) {
				continue;
			}
			else if(arr[i] >= secondLar) {
				secondLar= arr[i];
			}
		}
		return secondLar;
	}
	
	public static void main(String[] args) {
		int arr[] ={1, 2, 4, 7, 7, 5,6};
		IO.println("Second Largest :"+  FindSecondLargestElemInArray.findSecondLagest(arr));
	}

}
