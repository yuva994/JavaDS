package com.javads.dp;

public class LongestCommonSubSequence {

	/**
	 * Simple recursion
	 * @param string1
	 * @param string2
	 * @param length1
	 * @param length2
	 * @return
	 */
	public static int LCSLength(char[] string1, char[] string2, int length1, int length2){
		if (length1 == 0 || length2 == 0)
			return 0;
		if (string1[length1-1] == string2[length2-1]){
			return 1 + LCSLength(string1,string2,length1-1,length2-1);
		}
		else
			return Math.max(LCSLength(string1,string2,length1,length2-1), LCSLength(string1,string2,length1-1,length2));
	}
	/**
	 * LCS with DP
	 * @param string1
	 * @param string2
	 * @param length1
	 * @param length2
	 * @return
	 */
	public static int LCSDPLength(char[] string1, char[] string2, int length1, int length2){
		int[][] array = new int[length1+1][length2+1];
		
		for(int i=0; i<=length1; i++){
			for(int j=0; j<=length2; j++){
				if( i==0 || j==0)
					array[i][j] = 0;
				else if( string1[i-1] == string2[j-1])
					array[i][j] = 1 + array[i-1][j-1];
				else
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
			}
		}
		return array[length1][length2];
	}
	
	/**
	 * LCS with DP - Using Binary Index
	 * @param string1
	 * @param string2
	 * @param length1
	 * @param length2
	 * @return
	 */
	public static int LCSDPBILength(char[] string1, char[] string2, int length1, int length2){
		int[][] array = new int[2][length2+1];
		int bi = 0;
		for(int i=0; i<=length1; i++){
			bi = i & 1;
			for(int j=0; j<=length2; j++){
				if( i==0 || j==0)
					array[bi][j] = 0;
				else if( string1[i-1] == string2[j-1])
					array[bi][j] = 1 + array[1-bi][j-1];
				else
					array[bi][j] = Math.max(array[1-bi][j], array[bi][j-1]);
			}
		}
		return array[bi][length2];
	}
	
	public static void LCSDPChar(char[] string1, char[] string2, int length1, int length2){
		int[][] array = new int[length1+1][length2+1];
		
		for(int i=0; i<=length1; i++){
			for(int j=0; j<=length2; j++){
				if( i==0 || j==0)
					array[i][j] = 0;
				else if( string1[i-1] == string2[j-1])
					array[i][j] = 1 + array[i-1][j-1];
				else
					array[i][j] = Math.max(array[i-1][j], array[i][j-1]);
			}
		}
		
		int index = array[length1][length2];
		
		char[] opt = new char[index];
		
		int i=length1,j=length2;
		while( i>0 && j>0) {
			if(string1[i-1] == string2[j-1]){
				opt[index-1] = string1[i-1];
				i--;j--;index--;
			}
			else if( array[i-1][j] > array[i][j-1] )
				i--;
			else
				j--;
		}
		System.out.println("LCS - Sequence : "+new String(opt));
	}
}
