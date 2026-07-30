package com.dsa.strings;

public class ShortestPath {

	public static void main(String[] args) {
		String str = "WNEENESENNN";
		String str2="NWS"; 
		IO.println(getShortedPath(str));
		IO.println(getShortedPath(str2));
	}
	
	public static int getShortedPath(String str) {
		
		int y = 0;
		int x = 0;
		for(int i = 0 ; i<str.length() ; i++) {
			
			char direction = str.charAt(i);
			
			if(direction == 'W') y++;
			else if(direction ==  'N') y--;
			else if(direction == 'S') x++;
			else x--;
		}
		
		int X2 = x*x;
		int Y2 = y*y;
		return (int)Math.sqrt(Y2+X2);
	}

}
