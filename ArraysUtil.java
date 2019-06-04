package com.icdms;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class ArraysUtil {
 
  public static void main(String[] args) throws IOException {
	 
	  //findMissingNumberByFormula(new int[] {1,2,3,4,5,6,7,9,10},10);
	  //findMissingNumberByAPI(new int[] {1,2,3,4,5,6,7,9,10},10);
	  //removeDuplicatesUsingSet(new int[] {1,2,3,4,4,6,7,7,10});
	  //removeDuplicatesUsingList(new int[] {1,2,3,4,4,6,7,7,10});
	  //removeDuplicatesUsingStream(new int[] {1,2,3,4,4,6,7,7,10});
	  //convertIntArrayToList(new int[] {1,2,3,4,4,6,7,7,10});
	  //findLargestNSmallestNumber(new int[] {10,2,3,15,4,6,7,7,1});
	  //reverseArrayNative(new int[] {10,2,3,15,4,6,7,7,1});
	  //reverseArraybyMid(new int[] {10,2,3,15,4,6,7,7,1});
	  reverseArraybyColl(new Integer[] {10,2,3,15,4,6,7,7,1});
	
  }

  
  /**
   * Find one missing element in an array - Formula
   */
  public static void findMissingNumberByFormula(int[] input, int count){
	  int expectedSum = count * ( count + 1 ) / 2;
	  int actualSum = Arrays.stream(input).reduce( (i,j) -> i+j ).getAsInt();
	  System.out.println(expectedSum - actualSum);
  }
  
  /**
   * Find one or more missing element in an array - BitSet
   */
  public static void findMissingNumberByAPI(int[] input, int count){
	  BitSet set = new BitSet(count);
	  Integer lastMissingIndex = 0;

	  Arrays.stream(input).forEach( i -> set.set(i-1));	 
	  
	  for(int i=0; i< count-input.length; i++){
		  lastMissingIndex = set.nextClearBit(lastMissingIndex);
		  System.out.println(++lastMissingIndex);
		  }
  }
  
  /**
   * Remove duplicates - set
   */
  public static void removeDuplicatesUsingSet(int[] input){

	  Set<Integer> set = new HashSet<Integer>();
	  
	  Arrays.stream(input).forEach(i -> set.add(i));
	  Integer[] output = set.toArray(new Integer[set.size()]);
	  System.out.println(Arrays.toString(output));
  }
  
  /**
   * Remove duplicates - List
   */
  public static void removeDuplicatesUsingList(int[] input){
	  List<Integer> list = new ArrayList<Integer>();
	  
	  Arrays.stream(input).forEach(i -> {
		  if(!list.contains(i))
			  list.add(i);
		});
	  
	  Integer[] output = list.toArray(new Integer[list.size()]);
	  System.out.println(Arrays.toString(output));
  }
  
  /**
   * Remove duplicates - Stream
   */
  public static void removeDuplicatesUsingStream(int[] input){
	  
	  int[] output = Arrays.stream(input).distinct().toArray();
	  System.out.println(Arrays.toString(output));
  }
  
  /**
   * Convert int[] to List<Integer> - Stream
   */
  public static void convertIntArrayToList(int[] input){
	  List<Integer> list = Arrays.stream(input).boxed().collect(Collectors.toList());
	  System.out.println(list);
  }
  
  /**
   * Find largest & Smallest number in unsorted array
   */
  private static int smallestNumber; 
  private static int largestNumber ;
  public static void findLargestNSmallestNumber(int[] input){
	  smallestNumber = Integer.MAX_VALUE;
	  largestNumber = Integer.MIN_VALUE;
	  Arrays.stream(input).forEach(i -> {
		  if(i < smallestNumber)
			  smallestNumber = i;
		  if(i > largestNumber)
			  largestNumber = i;
	  });
	  
	  System.out.println("smallestNumber " + smallestNumber + " largestNumber "+largestNumber);
  }
  
  /**
   * Reverse an array - O(n)
   */
  public static void reverseArrayNative(int[] input){
	  int[] newArray = new int[input.length];
	  int j = input.length;
	  for(int i=0;i<input.length;i++){
		  newArray[j-1] = input[i];
		  j--;
	  }
	  System.out.println(Arrays.toString(newArray));
  }
  
  /**
   * Reverse an array - O(n/2)
   */
  public static void reverseArraybyMid(int[] input){
	  int k;
	  for(int i=0;i<input.length/2;i++){
		  k = input[i];
		  input[i] = input[input.length-i-1];
		  input[input.length-i-1] = k;
	  }
	  System.out.println(Arrays.toString(input));
  }

  /**
   * Reverse an array - Collections
   */
  public static void reverseArraybyColl(Integer[] input){
	  Collections.reverse(Arrays.asList(input));
	  System.out.println(Arrays.toString(input));
  }
}