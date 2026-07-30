package com.practice.nit;

public class Qua2 {

	public static void main(String[] args) {
		
      String str = "Madam";
		
		if(str.equalsIgnoreCase(new StringBuilder(str).reverse().toString())) {
			IO.println("true");
		}
		
		IO.print(str);			
		
	}

}
