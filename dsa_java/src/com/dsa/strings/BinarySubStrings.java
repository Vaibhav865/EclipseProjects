package com.dsa.strings;

public class BinarySubStrings {

	public static void main(String[] args) {
			
		String str = "0110111";		
		int result=0;
		int count = 0;
//		for(int i = 0 ; i<str.length() ; i++) {
//			
//			if(str.charAt(i) == '1') {
//				count++;  
//			}
//			
//		}
//		
		for(char c : str.toCharArray()) {
			if(c == '1') {
				count++;
			}else {
				result += count * (count+1)/2;
				count=0;
			}
			
		}
		result += count *(count + 1)/2;
		IO.println(result);
//		IO.println(count * (count+1)/2);
		
		
	}

}
