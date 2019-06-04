package com.javads.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

	List<T> elements = new ArrayList<T>();
	
	/*
	 * Add element to the end of the heap and restructure the heap to accomodate the new element.
	 */
	void add(T element){
		
		elements.add(element);
		int currentIndex = elements.size() - 1;
		while(!isRoot(currentIndex) && !isCorrectChild(currentIndex)){
			int parentIndex = parentIndex(currentIndex);
			swap(currentIndex,parentIndex);
			currentIndex = parentIndex;
		}
	}
	
	boolean isRoot(int index){
		return index == 0;
	}
	
	boolean isCorrectChild(int index){
		return isCorrect(parentIndex(index),index);
	}

	private boolean isCorrect(int parentIndex, int index) {
		if(!isValidIndex(parentIndex) || !isValidIndex(index))
			return true;
		return elements.get(parentIndex).compareTo(elements.get(index)) < 0 ;
	}

	void swap(int index1, int index2){
		T element1 = elements.get(index1);
		T element2 = elements.get(index2);
		elements.set(index1, element2);
		elements.set(index2, element1);
	}
	
	/**
	 * Removes root element from the heap - Heap Sort
	 * @return
	 */
	T pop(){
		T element = elements.get(0);
		
		int lastElementIndex = elements.size()-1;
		swap(0, lastElementIndex);
		elements.remove(lastElementIndex);
		
		int elementIndex = 0;
		
		if(!isLeaf(elementIndex) && !isCorrectParent(elementIndex)){
			int smallerChildIndex = smallerChildIndex(elementIndex);
			swap(elementIndex, smallerChildIndex);
			elementIndex = smallerChildIndex;
		}
		
		return element;
	}
	
	boolean isLeaf(int index){
		return !isValidIndex(leftIndex(index));
	}
	
	boolean isCorrectParent(int index){
		return isCorrect(index, leftIndex(index)) && isCorrect(index, rightIndex(index));
	}
	
	int smallerChildIndex(int index){
		int leftChildIndex = leftIndex(index);
		int rightChildIndex = rightIndex(index);
		
		if(!isValidIndex(rightChildIndex))
			return leftChildIndex;
		
		if(elements.get(leftChildIndex).compareTo(elements.get(rightChildIndex)) < 0 )
			return leftChildIndex;
		
		return rightChildIndex;
		
	}
	
	boolean isValidIndex(int index){
		return index < elements.size();
	}
	
	boolean isEmpty(){
		return elements.isEmpty();
	}
	
	T elementAtIndex(int index){
		return elements.get(index);
	}
	
	int parentIndex(int index){
		return (index-1)/2;
	}
	
	int leftIndex(int index){
		return 2 * index + 1;
	}
	
	int rightIndex(int index){
		return 2 * index + 2;
	}
	
	public static <T extends Comparable<T>> Heap<T> of(Iterable<T> elements){
		Heap<T> result = new Heap<T>();
		//elements.forEach(element -> result.add(element));
		for(T e: elements){
			result.add(e);
		}
		return result;
	}
	
	public List<T> sort() {
		List<T> result = new ArrayList<T>();
		while(!isEmpty())
			result.add(pop());
		return result;
	}
	
	public List<T> getAll(){
		return elements;
	}
}
