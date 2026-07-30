package com.linkedlist.elc;

import java.util.Arrays;
import java.util.Collections;

//Problem 2: Maximum People Under Weight Limit
//Sort weights in ascending order and keep adding until limit is exceeded. Example: Input:
//{60,55,45,65,70,50}, x = 200 → Output: 3

public class TcsNqtpractice2 {

	public static void main(String[] args) {
		Integer[] arr = {60,55,45,65,70,50};
		int limit= 200;
		Arrays.sort(arr);
		IO.println(Arrays.toString(arr));
		int sum = 0;
		int count=0;
		for(Integer a : arr) {
			sum+=a;
			if(sum<=200) {
				IO.println(sum);
				count++;
			}else {
				break;
			}
		}	
		IO.println("Sum is "+count);
		
		
		
		
//		Arrays.sort(arr , Collections.reverseOrder());
//		IO.println(Arrays.toString(arr));
		
		
	}

}
