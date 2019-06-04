package com.icdms;

import com.icdms.dp.LongestCommonSubSequence;

public class DynamicProgramming {

	static Integer[] lookup;
	public static void main(String[] args) {
		lookup = new Integer[10+1];
		//System.out.println("Fibonacci using DP - Tabulation :: "+fibonacci(10));
		//System.out.println("Fibonacci using DP - Memoization :: "+fibo(10));
		//UglyNumber.findUglyNumber(10);
		/*System.out.println(
				LongestCommonSubSequence.LCSLength(
						"AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), "AGGTAB".length(), "GXTXAYB".length()));*/
		/*System.out.println(
				LongestCommonSubSequence.LCSDPBILength(
						"AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), "AGGTAB".length(), "GXTXAYB".length()));*/
		LongestCommonSubSequence.LCSDPChar(
						"AGGTAB".toCharArray(), "GXTXAYB".toCharArray(), "AGGTAB".length(), "GXTXAYB".length());
	}
	
	/**
	 * Fibonacci using DP - Tabulation - Bottom Up
	 * @param n
	 * @return
	 */
	public static int fibonacci(int n){
		int[] fib = new int[n+1];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2;i <= n;i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		//System.out.println(Arrays.toString(fib));
		return fib[n];
	}
	
	/**
	 * Fibonacci using DP - Memoization - Top Bottom
	 * @param n
	 * @return
	 */
	
	public static int fibo(int n){
		if(lookup[n] == null){
			if(n <= 1)
				lookup[n] = n;
			else
				lookup[n] = fibo(n-1) + fibo(n-2);
		}
		return lookup[n];			
	}

}
