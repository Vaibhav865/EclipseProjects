package com.dsa.strings;


public class PalindromeOrNot {

	public static void main(String[] args) {
		
		String str = "racecar";
		IO.println(isPalindrome(str));
		
	}
	
	public static boolean isPalindrome(String str) {
		for(int i = 0 ; i<str.length()/2 ;i++) {
			if(str.charAt(i) != str.charAt(str.length()-i-1)) {
				return false;
			}
		}
		return true;
		
	}

}
