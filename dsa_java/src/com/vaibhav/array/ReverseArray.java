package com.vaibhav.array;

public class ReverseArray {
	
	public static void reverse(int arr[]) {
		
		int start=0;
		int end=arr.length-1;
		
		while(start < end) {
			int  temp=arr[end];
			arr[end]=arr[start];
			arr[start]=temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {

		int arr[]= {1,2,3,4,5};
		reverse(arr);
		
		System.out.println("Reverse Array Is :");
		for(int i=0; i<arr.length;i++) {
			IO.print(arr[i]+" ");
		}

	}

}
