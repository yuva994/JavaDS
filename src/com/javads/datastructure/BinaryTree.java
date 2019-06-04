package com.javads.datastructure;

public class BinaryTree {

	public Node root;
	
	public BinaryTree(){
		root = null;
	}
	public Node getRoot() {
		return root;
	}
	public void setRoot(Node root) {
		this.root = root;
	}
	
	public static class Node{
		public int key;
		public Node left, right;
		
		public Node(int key){
			this.key = key;
			left = right = null;
		}
		public boolean isLeaf(){
			return left == null ? right == null : false;
		}
}


	
}
