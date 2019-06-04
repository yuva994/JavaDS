package com.icdms;

import java.io.IOException;

public class SearchUtil {
	public static void main(String[] args) throws IOException {
		//System.out.println(OrderedLinearSearch(new int[]{1,2,2,4,5}, 3));
		//System.out.println(binarySearchIterative(new int[]{1,2,3,4,5}, 4));
		//System.out.println(binarySearchRecursive(new int[]{1,2,3,4,5},0,4,3));
		System.out.println(interpolationSearch(new int[]{11,12,13,14,15,16,17},15));
	}
	
	/**
	 * Ordered Linear Search 
	 * @param arr
	 * @param element
	 * @return
	 */
	public static int OrderedLinearSearch(int arr[], int element){
		for(int i = 0; i<arr.length; i++){
			if(arr[i] == element)
				return i;
			else if( arr[i] > element)
				return -1;
		}
		return -1;
	}
	
	/**
	 * Binary search - Iteration
	 * Formula:
	 *	Mid = low + high - low
	 *				----------
	 *					2			
	 * @param arr
	 * @param element
	 * @return
	 */
	public static int binarySearchIterative(int arr[], int element){
		int low = 0, high = arr.length-1,mid;
		while(low <= high){
			mid = low + (high-low)/2;
			if(element == mid)
				return mid;
			else if(arr[mid] > element)
				high = mid -1;
			else
				low = mid + 1;
		}
		return -1;
	}
	
	/**\
	 * Binary search - Recursion
	 * @param arr
	 * @param low
	 * @param high
	 * @param element
	 * @return
	 */
	public static int binarySearchRecursive(int arr[], int low, int high, int element){
		int mid = low + (high-low)/2;
		if(low > high) 
			return -1;
		if(element == mid)
			return mid;
		else if( arr[mid] > element)
			return binarySearchRecursive(arr, low, mid-1, element);
		else
			return binarySearchRecursive(arr, mid+1, high, element);
					
	} 
	
	/**
	 * Interpolation search  - Linear interpolation
	 * Formula:
	 * 	Mid = low + (element - array[low])*(high - low)
	 * 				----------------------------------
	 * 					(array[high]-array[low])
	 * @param arr
	 * @param element
	 * @return
	 */
	public static int interpolationSearch(int arr[], int element){
		int low = 0, high = arr.length-1, mid;
		
		while(arr[low] <= element && arr[high] >= element){
			if(arr[high] - arr[low] == 0)
				return high+low /2;
			mid = low + ((element - arr[low])*(high-low))/(arr[high]-arr[low]);
			System.out.print("Low :: "+ low+" ");
			System.out.print("High :: "+ high+" ");
			System.out.println("Mid :: "+ mid);
			if(arr[mid] < element)
				low = mid + 1;
			else if(arr[mid] > element)
				high = mid - 1;
			else
				return mid;
		}
		if(arr[low] == element)
			return low;
		else
			return -1;
	}
	
}
