package com.vaibhav.sorting;

public class InsertionShort {

	public static void insertionShort(int arr[]) {
		
		for(int i=0;i<arr.length;i++) {
			int curr=arr[i];
			int prev=i-1;
			
			while(prev>=0 && arr[prev]>curr) {
				arr[prev+1]=arr[prev];
				prev--;
			}
			arr[prev+1]=curr;
		}
		
	}
	
	public static void printing(int arr[]) {
		for(int i=0; i<arr.length ;i++) {
			IO.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		int arr[]= {5,4,2,1,3};
		insertionShort(arr);
		printing(arr);
		}
}
