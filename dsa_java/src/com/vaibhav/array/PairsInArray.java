package com.vaibhav.array;

public class PairsInArray {

	public static void pairs(int arr[]) {
		
		int count=0;
		for(int i=0;i<arr.length;i++) {
			
			int current=arr[i];
			for(int j=i+1; j<arr.length;j++) {
				IO.print("("+current+","+arr[j]+")");
				count++;
			}
			IO.println();
		}
		IO.println("The pair count is :"+count);
	}
	
	public static void main(String[] args) {
		
		int arr[]= {2,4,6,8,10};
		pairs(arr);
	}

}
