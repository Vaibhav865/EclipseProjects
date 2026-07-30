package com.vaibhav.sorting;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;


public class ArraySortUsingInbuidSort {
	public static void printing(Integer arr[]) {
		for(int i=0; i<arr.length ;i++) {
			IO.print(arr[i]+" ");
		}
	}

	public static void main(String[] args) {
		
		Integer arr[]= {5,3,2,4,1};
		Arrays.sort(arr);
		printing(arr);
		Arrays.sort(arr,0,2);
		printing(arr);
		Arrays.sort(arr,Collections.reverseOrder());
		printing(arr);
		Arrays.sort(arr,0,3,Collections.reverseOrder());
		printing(arr);
}
}