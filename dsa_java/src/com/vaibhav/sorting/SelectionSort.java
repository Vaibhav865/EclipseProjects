package com.vaibhav.sorting;

public class SelectionSort {
	
	public static void selectionSort(int arr[]) {
		
		for(int i=0;i<arr.length-1;i++) {
			int minpos=i;
			for(int j=i+1;j>arr.length;j++) {
				if(arr[j]<arr[minpos]) {
					minpos=j;
				}
			}
			int temp=arr[minpos];
			arr[minpos]=arr[i];
			arr[i]=temp; 	
		}
		
	}
	
	public static void printArr(int arr[]) {
		for(int i=0;i<arr.length;i++) {
			IO.print(arr[i]+" ");
		}
	}
	
	public static void main(String[]args) {
		int arr[]= {5,4,3,2,1,0};
		selectionSort(arr);
		printArr(arr);
	}
}	
		























