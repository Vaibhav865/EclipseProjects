package com.vaibhav.array;

public class MaxSumOfSubArrByKaDanesAlgo {
	
	public static void calculateMaxSum(int arr[]){
		int maxSum=Integer.MIN_VALUE;
		int currSum=0;
		
		for(int i=0 ; i<arr.length;i++) {
			
			currSum=currSum+arr[i];
			if(currSum<0) {
				currSum=0;
			}
			maxSum=Math.max(currSum, maxSum);
		}
		IO.println("Maximum sum is :"+maxSum);
	}
		
	public static void main(String[] args) {
		int arr[]= {-1,-2,-3,-4,-5,-6};
		calculateMaxSum(arr);
	}
	
	
}


