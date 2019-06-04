package com.javads.util;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    public static void main(String[] args) throws IOException {
    
    	findNonRepeatedChar("ssrssrssrabc");
    	findNonRepeatedCharUsingStream("ssrssrssrabc");
    	printDuplicateCharecters("repeatedString");
    	isAnagramUsingList("madam","dsmam");
    	isAnagramUsingBuilder("madam","damam");
    	isAnagramUsingNative("madam","dsmam");
    	reverseUsingBuilder("reverse");
    	reverseUsingIteration("reverse");
    	reverseUsingIterationBuffer("reverse");
    	reverseUsingRecursion("reverse");
    	regex("A B C");
    }
    
    /**
     * Find first non-Repeated Char - Map - Legacy
     * @param input
     */
    public static void findNonRepeatedChar(String input){
    	LinkedHashMap<String, Integer> map = new LinkedHashMap<String,Integer>();
    	
    	for(char c: input.toCharArray()){
    		map.put(c+"", map.containsKey(c+"") ? map.get(c+"")+1 : 1 );
    	}
    	   	
    	for(Entry<String, Integer> entry: map.entrySet()){
    		if(entry.getValue() == 1){
    			System.out.println(entry.getKey());
    			break;
    		}
    	}
    }
    
    /**
     * Find first non-Repeated Char - Map - Stream
     * @param input
     */
    public static void findNonRepeatedCharUsingStream(String input){
    	LinkedHashMap<String, Integer> map = new LinkedHashMap<String,Integer>();
    	
    	for(char c: input.toCharArray()){
    		map.put(c+"", map.containsKey(c+"") ? map.get(c+"")+1 : 1 );
    	}
    	Predicate<Integer> predicate = (i->i.equals(1));
    	Entry<String, Integer> filteredMap = map.entrySet().stream().filter(a -> predicate.test(a.getValue())).findFirst().get();
    	System.out.println(filteredMap.getKey() + " :: " + filteredMap.getValue());
    	
    }
    
    /**
     * Print duplicate characters in the string - HashMap
     * @param input
     */
    public static void printDuplicateCharecters(String input){
    	Map<Character,Integer> map = new HashMap<Character,Integer>();
    	for(char c: input.toCharArray())
    		if(map.containsKey(c))
    			map.put(Character.valueOf(c), 1+map.get(Character.valueOf(c)));
    		else
    			map.put(Character.valueOf(c), 1);
    	
    	Predicate<Integer> predicate = i -> i >1;
    	map.entrySet().stream().filter(a -> predicate.test(a.getValue())).forEach( a -> {
    		System.out.println(a.getKey());
    	});
    }
    
    /**
     * Check if two strings are anagram - List API
     * @param input1
     * @param input2
     */
    public static void isAnagramUsingList(String input1, String input2){
    	char[] array1 = input1.toCharArray();
    	char[] array2 = input2.toCharArray();
    	
    	Arrays.sort(array1);
    	Arrays.sort(array2);
    	
    	System.out.println(Arrays.equals(array1, array2));
    }
    
    /**
     * Check if two strings are anagram - String Builder API
     * @param input1
     * @param input2
     */
    public static void isAnagramUsingBuilder(String input1, String input2){
    	StringBuilder builder = new StringBuilder(input2);
    	
    	for(char c:input1.toCharArray()){
    		int index = builder.indexOf(""+c);
    		if(index != -1)
    			builder.deleteCharAt(index);
    		else
    			break;
    	}
    	
    	System.out.println(builder.length() == 0);
    }

    /**
     * Check if two strings are anagram - Native code
     * @param input1
     * @param input2
     */
    public static void isAnagramUsingNative(String input1, String input2){
    	if(input1.length() == input2.length()){
    		for(char c: input1.toCharArray()){
    			int index = input2.indexOf(c);
    			if(index != -1)
    				input2 = input2.substring(0,index) + input2.substring(index+1, input2.length());
    		}
    	}
    		
    	System.out.println(input2.isEmpty());
    }
    
    /**
     * reverse String - StringBuilder
     * @param input
     */
    public static void reverseUsingBuilder(String input){
    	StringBuilder builder = new StringBuilder(input);
    	
    	System.out.println("StringBuilder :: "+builder.reverse().toString());
    	
    	System.out.println("StringBuffer :: "+new StringBuffer().append(input).reverse().toString());
    }
    
    /**
     * reverse String - Iteration
     * @param input
     */
    public static void reverseUsingIteration(String input){
    	String reversed = "";
    	
    	for(int i=input.length()-1; i>=0; i--){
    		reversed += input.charAt(i)+"";
    	}
    	
    	System.out.println("Iteration :: "+reversed);
    }
    
    /**
     * reverse String - Iteration - StringBuffer
     * @param input
     */
    public static void reverseUsingIterationBuffer(String input){
    	StringBuffer reversed = new StringBuffer();
    	
    	for(int i=input.length()-1; i>=0; i--){
    		reversed.append(input.charAt(i)+"");
    	}
    	
    	System.out.println("IterationBuffer :: "+reversed.toString());
    }
    
    /**
     * reverse String - Recursion
     * @param input
     */
    public static void reverseUsingRecursion(String input){
    	System.out.println(reverseStringRecursive(input));
    }
    
    /**
     * reverse String - Recursion
     * @param input
     */
    public static String reverseStringRecursive(String input){
    	if(input.length() < 2)
    		return input;
    	return reverseStringRecursive(input.substring(1)) + input.charAt(0);
    }
    
    /**
     * Check if string contains digits - regex
     * @param input
     */
    public static void regex(String input){
    	Pattern p = Pattern.compile("(?i)[abc\\.,]");
    	Matcher m = p.matcher(input);
    	System.out.println(m.matches());
    	
    	String pattern = "(abc)(\\s+)(,)";
    	System.out.println(input.replaceAll(pattern, "$1$3"));
    	
    	System.out.println(Arrays.asList(input.split("\\s")));
    }
    
    
}

