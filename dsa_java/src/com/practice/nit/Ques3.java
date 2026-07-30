package com.practice.nit;

public class Ques3 {

	public static void main(String[] args) {
		
			//Count words
		String str = "Java is a language ";
		
		String[] words = str.split(" ");
		IO.println(words.length);
		
		char [] ch = str.toCharArray();
		int count = 0 ;
		for(char c : ch) {
			count ++;
		}
			
		IO.println(count);

	}

}
