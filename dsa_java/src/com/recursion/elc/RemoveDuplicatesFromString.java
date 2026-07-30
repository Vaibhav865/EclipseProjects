package com.recursion.elc;

//import java.util.Map;

public class RemoveDuplicatesFromString {

	public static void main(String[] args) {
		
		String  str = "aapnacolllage";

		removeDuplicate(str, 0, new StringBuilder (""),new boolean [26]);
	}
	
	public static void removeDuplicate(String str , int idx , StringBuilder newStr , boolean map[]) {
		if(idx == str.length() ) {
			IO.println(newStr);
			return;
		}
		 char currChar = str.charAt(idx);
		 
		 if(map[currChar - 'a'] == true) {
			 removeDuplicate(str, idx+1, newStr, map);
		 }else {
			 map[currChar-'a'] = true ;	 
			 removeDuplicate(str, idx+1, newStr.append(currChar), map);
		 }
		
	}

}
