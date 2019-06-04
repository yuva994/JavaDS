package com.javads.datastructure;

public class SinglyLinkedList {

	private Node head;
	private Node tail;
	
	public SinglyLinkedList(Node node){
		this.head = node;
		this.tail = head;
	}
	
	public void add(Node node){
		this.tail.next = node;
		this.tail = node;
	}
	
	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public static class Node{
		String data;
		Node next;

		public String data() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}

		public Node next() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node(String data){
			this.data = data;
		}
		
		public String toString(){
			return data.toString();
		}
	}
	
	public String toString(){
		StringBuilder result = new StringBuilder();
		Node current = this.head;
		
		while (current!=null){
			result.append(current.data).append(" --> ");
			current = current.next;			
		}
		result.delete(result.length()-5, result.length());
		return result.toString();
	}
	
}
