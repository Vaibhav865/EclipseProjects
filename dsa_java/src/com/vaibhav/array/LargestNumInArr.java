package com.vaibhav.array;

public class LargestNumInArr {
	
	public static int findLargestNum(int arr[]) {
		
		int min=Integer.MIN_VALUE;
		for(int i=0 ; i<arr.length;i++) {
			
			if(arr[i]>=min) {
				min=arr[i];
			}
		}
		return min;
	}
	
	
	public static void main() {
		int arr[]= {1,2,3,4,5,6,7};
		
		int largestNum=findLargestNum(arr);
		IO.println(largestNum);
	}
}
