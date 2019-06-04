package com.javads.datastructure;

import java.util.ArrayList;
import java.util.List;

public class GenericBinaryTree<T> {

	List<T> elements = new ArrayList<T>();
	
	void add(T element){
		elements.add(element);
	}
	
	boolean isEmpty(){
		return elements.isEmpty();
	}
	
	T elementAtIndex(int index){
		return elements.get(index);
	}
	
	int parentIndex(int index){
		return index/2;
	}
	
	int leftIndex(int index){
		return 2*index;
	}
	
	int rightIndex(int index){
		return 2*index+1;
	}
}
