package com.recursion.elc;

public class SumOfNNaturalNumber {

	public static void main(String[] args) {
		
		int n = 10 ;
		
		IO.println(SumOfNNum(n));
	}
	
	public static int SumOfNNum(int n ) {
		if(n== 0) {
			return 0;
		}
		 
		return n+ (SumOfNNum(n-1));
		
	}
//	public static int SumOfNNum2(int n ) {
//		if(n== 0) {
//			return 0;
//		}
//		int s = SumOfNNum2(n-1);
//		int s2 = n+s;
//		return s2;
//	}

}
