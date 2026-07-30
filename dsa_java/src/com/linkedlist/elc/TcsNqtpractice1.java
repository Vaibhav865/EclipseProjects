package com.linkedlist.elc;

//Problem 1: Parking Charges Calculation
//Rules: - First 2 hours → ■100/hour - Next 3 hours → ■50/hour - Remaining hours → ■20/hour
//Example: Input: 3 → Output: 250 Input: 6 → Output: 370



public class TcsNqtpractice1 {

	public static void main(String[] args) {
		
		
		int inp = 0;
		int amount=0;
		
		
		if( inp <= 2) {
			amount += inp * 100;
		} else if( inp <=5) {
			amount += (200) + ( (inp - 2)*50 ); 
		} else {
		
			 amount = (350) + ((inp-5) * 20);
		}
		
		
		
		IO.println(amount);
		
		
	}

}
