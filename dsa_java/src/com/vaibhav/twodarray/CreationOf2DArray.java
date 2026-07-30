package com.vaibhav.twodarray;

public class CreationOf2DArray {
	
	public static boolean searchElm(int arr[][],int key) {
		
		for(int i=0; i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				if(arr[i][j]==key) {
					IO.println("Key found at ("+i+","+j+")");
					return true;
				}
			}
		}
		
		return false;
	}
	

	public static void main(String[] args) {

		int arr[][]=new int[3] [3];
		int n=arr.length;
		int m=arr[0].length;
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				arr[i][j]=Integer.parseInt(IO.readln());
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				IO.print(arr[i][j]+" ");
			}
			IO.println();
		}
		searchElm(arr,5);
	}

}
