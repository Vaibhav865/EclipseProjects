package com.backtracking.elc;

public class FindSubSet {

	public static void main(String[] args) {
		
		String str = "abc";
		String ans="";
		subSet(str, ans ,0);
		IO.println(str.length());
		
	}
	
	public static void subSet(String str , String ans , int i) {
		
		if(i == str.length()) {
			if(ans.length() == 0) {
				IO.println("null");
			}else {
				IO.println(ans);
			}
			return;
		}
		
		subSet(str , ans+str.charAt(i),i+1);
		subSet(str , ans,i+1);
		
		
	}

}
