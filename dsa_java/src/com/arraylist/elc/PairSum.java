package com.arraylist.elc;

//import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;

public class PairSum {

	public static void main(String[] args) {
			ArrayList<Integer>  al = new ArrayList<>();
			ArrayList<Integer>  al2 = new ArrayList<>();
			int target = 5;
//					al.add(3);
//					al.add(2);
//					al.add(5);
//					al.add(4);
//					al.add(6);
//					al.add(1);
//					Collections.sort(al);
			IO.println(al);
//			IO.println(al.get(2));
		
			for(int i = 0 ; i<1000 ;i++) {
				al.add(i);
			}
			
//			IO.println(sumPair(al,target));\
			 long start1 = System.nanoTime();
			 int sum = 0;
			 for(int i = 0 ; i<al.size() ; i++) {
				 sum+=i;
			 }
			 
			long end1 = System.nanoTime();
			
//			IO.println(sumPair2(al,target));
			
			long start2 = System.nanoTime();
			int sum2 = 0;
			for(Integer i :al) {
				sum2 +=i;
			}
			long end2 = System.nanoTime();
			
			IO.println(end1- start1);
			IO.println(end2 - start2);
		
	}
	
	// 1 2 3 4 5 6      5
	
	public static boolean sumPair(ArrayList<Integer> al , int target ) {
			int i = 0 ; 
			int j = al.size()-1;
				while(i!=j) {
					if(al.get(i) + al.get(j) == target) {
						return true;
					 }
					else if(al.get(i) + al.get(j) < target) {
						i++;
					} else {
						j--;
					}
		
				}
			return false;
				
	}
	
	public static boolean sumPair2(ArrayList<Integer> al , int target ) {
			for(int i = 0 ; i<al.size() ; i++) {
				for(int j = 1 ; j<al.size() ; j++) {
					if(al.get(i) + al.get(j) == target) return true;
				}	
			}
		return false;
	
	}
	
	
	
	
	
	
	
	
	

}
