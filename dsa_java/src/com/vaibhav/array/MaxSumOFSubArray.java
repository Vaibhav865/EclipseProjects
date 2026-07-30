package com.vaibhav.array;

public class MaxSumOFSubArray {

	public static void maxSumOfSubArr(int arr[]) {
		int sum=0;
		int maxSum=Integer.MIN_VALUE;

		for(int i=0;i<arr.length;i++) {
			
			for(int j=i; j<arr.length;j++) {
			
				sum=0;
				for(int k=i; k<=j;k++ ) {
					
					IO.print(arr[k]);
					sum+=arr[k];
				}
				IO.print("  Current Sum is:"+sum);
				if(maxSum<sum) {
					maxSum=sum;
				}
				IO.println();
			}
			IO.println();
		}	
		IO.println("Maximum sum is :"+maxSum);
	}
	
	
	public static void main(String[] args) {
		
		int arr[]= {1,2,3,4,5};
		maxSumOfSubArr(arr);
	}
}
