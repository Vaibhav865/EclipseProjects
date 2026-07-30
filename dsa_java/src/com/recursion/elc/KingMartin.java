package com.recursion.elc;

public class KingMartin {

	public static void main(String[] args) {
		
		
		

		        int N = 5, R = 5, start = 1, end = 4;

		        int[][] dp = new int[N + 1][R + 1];

		        dp[1][start] = 1;

		        for (int i = 2; i <= N; i++) {

		            int total = 0;
		            for (int j = 1; j <= R; j++) {
		                total += dp[i - 1][j];
		            }

		            for (int j = 1; j <= R; j++) {
		                dp[i][j] = total - dp[i - 1][j];
		            }
		        }

		        System.out.println("Total ways: " + dp[N][end]);
		    
		
		
		
		
		
	}

}
