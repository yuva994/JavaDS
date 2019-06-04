package com.javads.util;

import java.util.Arrays;
import java.util.List;

import com.javads.datastructure.Heap;

public class HeapUtils {

	public static void main(String[] args) {
		Heap<Integer> heap = Heap.of(Arrays.asList(6,8,3,5,1));
		System.out.println("Result :: "+heap.getAll());
		List<Integer> output = heap.sort();
		System.out.println(output);
	}
}
