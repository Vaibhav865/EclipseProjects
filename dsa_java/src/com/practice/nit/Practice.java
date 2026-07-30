package com.practice.nit;

public class Practice {
	 
	 
	 public static void main(String[]args) {
		 int[] arr = {121, 370,153 ,199 ,131 ,170};
		 armst(arr);
		 
	 }
	 public static void armst(int[] arr) {
		 for(int a : arr) {
			 int sum = 0;
			 
			 while(a!=0) {
				 	int b = a%10;
				 	a=a/10;
				 	sum += b+b+b;
				 	IO.println(b);
			 }
			 boolean flag = false;
			 if(sum == a) {
				 flag = true;
			 }
			 else {
				 flag = false;
			 }
			 
			 IO.println(a +" is armstrong "+ flag);
		 }
	 }
	 
}
