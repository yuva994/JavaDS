package com.icdms;

import java.io.IOException;
import java.util.HashSet;

import com.icdms.datastructure.SinglyLinkedList;

public class ListUtil {
	 public static void main(String[] args) throws IOException {
		 SinglyLinkedList linkedList = new SinglyLinkedList(new SinglyLinkedList.Node("1"));
		 linkedList.add(new SinglyLinkedList.Node("2"));
		 linkedList.add(new SinglyLinkedList.Node("3"));
		 linkedList.add(new SinglyLinkedList.Node("4"));
		 linkedList.add(new SinglyLinkedList.Node("5"));
		 linkedList.add(new SinglyLinkedList.Node("6"));
		 linkedList.add(new SinglyLinkedList.Node("7"));
		 System.out.println(linkedList);
		 
		 //findMiddleElement(linkedList);
		 //lengthByIteration(linkedList);
		 //lengthByRecursion(linkedList);
		 
		 SinglyLinkedList cyclicLinkedList = new SinglyLinkedList(new SinglyLinkedList.Node("1"));
		 cyclicLinkedList.add(new SinglyLinkedList.Node("2"));
		 cyclicLinkedList.add(new SinglyLinkedList.Node("3"));
		 SinglyLinkedList.Node cyclic = new SinglyLinkedList.Node("4");
		 cyclicLinkedList.add(cyclic);
		 cyclicLinkedList.add(new SinglyLinkedList.Node("5"));
		 cyclicLinkedList.add(new SinglyLinkedList.Node("6"));
		 cyclicLinkedList.add(new SinglyLinkedList.Node("7"));
		 cyclicLinkedList.add(cyclic);
		 
		 //System.out.println(isCyclic(linkedList));
		 //System.out.println(isCyclic(cyclicLinkedList));
		 
		 //reverseListByIteration(linkedList);
		 //reverseListByRecursion(linkedList);
		 
		 SinglyLinkedList dupLinkedList = new SinglyLinkedList(new SinglyLinkedList.Node("1"));
		 dupLinkedList.add(new SinglyLinkedList.Node("2"));
		 dupLinkedList.add(new SinglyLinkedList.Node("3"));
		 dupLinkedList.add(new SinglyLinkedList.Node("4"));
		 dupLinkedList.add(new SinglyLinkedList.Node("4"));
		 dupLinkedList.add(new SinglyLinkedList.Node("6"));
		 dupLinkedList.add(new SinglyLinkedList.Node("3"));
		 
		 //removeDuplicatesNative(dupLinkedList);
		 //removeDuplicatesUsingSet(dupLinkedList);
		 
		 //findElement(linkedList,3);
		 
		 //reversePairrec(linkedList);
		 //reversePairIterative(linkedList);
		 linkedList.setHead(rotateList(linkedList, 10));
		 System.out.println(linkedList);
	 }
	 
	 /**
	  * Find middle element of the linked list with one iteration.
	  * @param list
	  */
	 public static void findMiddleElement(SinglyLinkedList list){
		 SinglyLinkedList.Node head = list.getHead();
		 SinglyLinkedList.Node current = head;
		 SinglyLinkedList.Node middle = head;
		 int length = 1;
		 
		 while(current.next() != null){
			 length++;
			 if(length % 2 == 0)
				 middle = middle.next();
			 current = current.next();
		 }
		 
		 if(length%2==1)
			 middle = middle.next();
		 
		 System.out.println("Length :: "+length);
		 System.out.println("Middle Element : "+middle.data());
		 
	 }
	 
	 /**
	  * Length of the list - Iteration
	  * @param list
	  */
	 public static void lengthByIteration(SinglyLinkedList list){
		 SinglyLinkedList.Node current = list.getHead();
		 int length = 1;
		 while(current.next() != null){
			 length++;
			 current = current.next();
		 }
		 System.out.println("Length :: "+length);
	 }
	 
	 
	 /**
	  * Length of the list - Recursive
	  * @param list
	  */
	 public static void lengthByRecursion(SinglyLinkedList list){
		 System.out.println("Length :: "+recursiveLength(list.getHead()));
	 }
	 
	 /**
	  * Length of the list - Recursive
	  * @param current
	  * @return
	  */
	 public static Integer recursiveLength(SinglyLinkedList.Node current){
		 if(current == null){
			 return 0;
		 }
		 else
			 return 1+recursiveLength(current.next());
	 }

	 /**
	  * If list is Cyclic
	  * @param list
	  * @return
	  */
	 public static boolean isCyclic(SinglyLinkedList list){
		 boolean isCyclic = false;
		 SinglyLinkedList.Node fast = list.getHead();
		 SinglyLinkedList.Node slow = list.getHead();
		 
		 while(fast != null && fast.next() != null){
			 fast = fast.next().next();
			 slow = slow.next();
			 
			 if( fast == slow ){
				 isCyclic = true;
				 break;
			 }
		 }
		 
		 if(isCyclic){
			 slow = list.getHead();
			 while(slow != fast){
				 slow = slow.next();
				 fast = fast.next();
			 }
			 System.out.println("First Element in the loop : "+fast.data());
		 }
		 
		 return isCyclic;
		 
		 
	 }
	 
	 /**
	  * Reverse a linked list - Iteration
	  * @param list
	  */
	 public static void reverseListByIteration(SinglyLinkedList list){
		 SinglyLinkedList.Node pointer = list.getHead();
		 SinglyLinkedList.Node current = null, previous = null;
		 
		 while(pointer != null){
			 current = pointer;
			 pointer = pointer.next();
			 
			 current.setNext(previous);
			 previous = current;
			 list.setHead(current);
		 }
		 
		 System.out.println(list.toString());
	 }
	 
	 /**
	  * Reverse a linked list - Recursion
	  * @param list
	  */
	 public static void reverseListByRecursion(SinglyLinkedList list){
		 list.setHead(recursiveReverseList(list.getHead()));
		 System.out.println(list);		 
	 }
	 
	 /**
	  * Reverse a linked list - Recursion
	  * @param list
	  */
	 public static SinglyLinkedList.Node recursiveReverseList(SinglyLinkedList.Node node){
		 SinglyLinkedList.Node head = null;
		 if(node.next() == null)
			 return node;
		 head = recursiveReverseList(node.next());
		 
		 // C -> D -> null
		 
		 node.next().setNext(node);
		 node.setNext(null);
		 
		 return head;
	 }
	 
	 /**
	  * Remove duplicates - Loops
	  * @param list
	  */
	 public static void removeDuplicatesNative(SinglyLinkedList list){
		 SinglyLinkedList.Node ptr1 = null, ptr2 = null;
		 ptr1 = list.getHead();
		 
		 while( ptr1 != null && ptr1.next()!= null ){
			 ptr2 = ptr1;
			 
			 while(ptr2.next()!=null){
				 
				 if(ptr1.data().equals(ptr2.next().data())){
				 	ptr2.setNext(ptr2.next().next());
				 }
				 else
					 ptr2 = ptr2.next();
			 }
			 ptr1 = ptr1.next();
		 }
		 
		 System.out.println(list.toString());
	 }
	 
	 /**
	  * Remove duplicates - Set
	  * @param list
	  */
	 public static void removeDuplicatesUsingSet(SinglyLinkedList list){
		 HashSet<String> set = new HashSet<String>();
		 
		 SinglyLinkedList.Node current = list.getHead();
		 SinglyLinkedList.Node prev = null;
		 
		 while( current != null ){
			 String value = current.data();
			 if(set.contains(value)){
				 prev.setNext(current.next());
			 }
			 else {
				 set.add(value);
				 prev = current;
			 }
			 current = current.next();
		 }
		 
		 System.out.println(list.toString());
	 }
	 
	 /**
	  * Find Nth element in the list
	  * @param list
	  * @param elementPosition
	  */
	 public static void findElement(SinglyLinkedList list, Integer elementPosition){
		 SinglyLinkedList.Node fast = list.getHead(), slow = list.getHead();
		 int length = 1;
		 
		 while(fast.next() != null){
			 fast = fast.next();
			 length++;
			 if(length > elementPosition){
				 slow = slow.next();
			 }
			 
		 }
		 
		 System.out.println(elementPosition + "th Position from the last in the list :: "+slow.data());
	 }
	 
	 /**
	  * Reverse pairs in linked list - Recursive
	  * @param list
	  */
	 public static void reversePairrec(SinglyLinkedList list){
		 list.setHead(reversePairrecursive(list.getHead()));
		 System.out.println(list.toString());
	 }
	 public static SinglyLinkedList.Node reversePairrecursive(SinglyLinkedList.Node head){
		 SinglyLinkedList.Node tmp;
		 if(head == null || head.next() == null	){
			 return head;
		 }
		 else{
			 tmp = head.next();
			 head.setNext(tmp.next());
			 tmp.setNext(head);
			 head = tmp;
			 
			 head.next().setNext(reversePairrecursive(head.next().next()));
			 return head;
		 }		 
	 }
	 
	 /**
	  * Reverse pairs in linked list - Iterator
	  * @param list
	  */
	 public static void reversePairIterative(SinglyLinkedList list){
		 SinglyLinkedList.Node tmp1 = null, tmp2= null,head = list.getHead();
		 while(head != null && head.next()!=null){
			 if(tmp1 != null)
				 tmp1.next().setNext(head.next());
			 
			 tmp1 = head.next();
			 head.setNext(head.next().next());
			 tmp1.setNext(head);
			 
			 if(tmp2 == null){
				 tmp2 = tmp1;
			 }
			 
			 head = head.next();			 
		 }
		 list.setHead(tmp2);
		 System.out.println(list);
	 }
	 
	 
	 public static SinglyLinkedList.Node rotateList(SinglyLinkedList list, int n){
		 SinglyLinkedList.Node head = list.getHead(), rotateStart = head, rotateEnd = head;
		 if( head == null || head.next() == null)
			 return head;
		 
		 while(n-->0){
			 //System.out.println("n "+n);
			 rotateEnd = rotateEnd.next();
			 if(rotateEnd == null)
				 rotateEnd = head;
		 }
		 //System.out.println("rotateEnd "+rotateEnd.data());
		 if(rotateStart == rotateEnd)
			 return head;
		 while(rotateEnd.next() != null){
			 rotateStart = rotateStart.next();
			 rotateEnd = rotateEnd.next();
		 }
		 //System.out.println("rotateStart "+rotateStart.data());
		 SinglyLinkedList.Node tmp = rotateStart.next();
		 rotateEnd.setNext(head);
		 rotateStart.setNext(null);
		 return tmp;
		 
	 }
}
