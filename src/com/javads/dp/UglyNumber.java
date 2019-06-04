package com.javads.dp;

public class UglyNumber {

	/**
	 * Find if a number is ugly 
	 * A number is ugly if the number is divisible by greatest divisible powers of 2,3,5.
	 * @param n
	 */
	public static void findUglyNumber(int n){
		int[] ugly = new int[n];
		int i2 = 0,i3 = 0,i5 = 0;
		int nxtXof2 = 2, nxtXof3 = 3, nxtXof5 = 5;
		int nxtUglyNo = 1;
		
		ugly[0] = 1;
		
		for(int i=1; i<n; i++){
			nxtUglyNo = Math.min(nxtXof2, Math.min(nxtXof3, nxtXof5));
			ugly[i] = nxtUglyNo;
			//System.out.println(Arrays.toString(ugly));
			if(nxtUglyNo == nxtXof2){
				i2 = i2 + 1;
				nxtXof2 = ugly[i2]*2;
			}
			if(nxtUglyNo == nxtXof3){
				i3 = i3 + 1;
				nxtXof3 = ugly[i3]*3;
			}
			if(nxtUglyNo == nxtXof5){
				i5 = i5 + 1;
				nxtXof5 = ugly[i5]*5;
			}
			//System.out.println(nxtXof2 + " : " + nxtXof3 + " : " + nxtXof5);
		}
		System.out.println(nxtUglyNo);
		
	}

}
