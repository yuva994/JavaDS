package com.icdms;

import java.util.HashMap;
import java.util.Stack;

import com.icdms.datastructure.BinaryTree;
import com.icdms.datastructure.BinaryTree.Node;

public class TreeUtil {
	static BinaryTree tree = new BinaryTree();
	@SuppressWarnings("unused")
	public static void main(String[] args){
		 	tree.root = new Node(5); 
	        tree.root.left = new Node(4); 
	        tree.root.right = new Node(6); 
	        tree.root.left.left = new Node(2); 
	        tree.root.left.right = new Node(3); 
	        
	        //System.out.println(size(tree.root));
	        //insert(tree.root, 1);
	        /*preOrderRecursive(tree.root);
	        System.out.println();
	        preOrderIterative(tree.root);
	        System.out.println();
	        inOrderRecursive(tree.root);
	        System.out.println();
	        inorderIterative(tree.root);
	        System.out.println();
	        postOrderRecursive(tree.root);
	        System.out.println();
	        postOrderIterative(tree.root);
	        System.out.println();*/
	        //printLevelOrder(tree.root);
	        
	        int inOrder[] = {4, 2, 5, 1, 3};  
	        int preOrder[] = {1, 2, 4, 5, 3};  
	        int postOrder[] = {4, 5, 2, 3, 1}; 
	        int length = inOrder.length;
	        
	        //System.out.println(compareWithPost( buildTree(inOrder, preOrder, 0,	length-1), postOrder, 0) == length);
	        //System.out.println(checkTree(preOrder, 0, inOrder, 0, postOrder, 0, length));
	        
	        postIndex = length-1;
	        preIndex = 0;
	        Stack<Integer> preOdr = new Stack<Integer>();
	        HashMap<Integer,Integer> in = new HashMap<Integer,Integer>();
	        for(int i=0; i<length;i++)
	        	in.put(inOrder[i],i);
	        //findPreOrder(inOrder, postOrder, 0, length-1, preOdr, in);
	        //findPostOrder(inOrder, preOrder, 0, length-1);
	        /*while(!preOdr.isEmpty())
	        	System.out.print(preOdr.pop()+" ");*/
	        
	        //preOrderIterative(buildTreePI(inOrder,postOrder,0,length-1));
	        
	        int preOrder1[] = {1,2,4,5,3,6,7};  
	        int preOrderMirror[] = {1,3,7,6,2,5,4};  
	       // preOrderIterative(buildTreeM(preOrder1,preOrderMirror,0,preOrder1.length-1,preOrder1.length));
	        
	        /*inOrderRecursive(tree.root);
	        System.out.println();
	        inOrderRecursive(constructMirrorTree(tree.root));*/
	        
	        //printPath(tree.root,new int[100],0);
	        tree = new BinaryTree(); 
	        tree.root = new Node(20); 
	        tree.root.left = new Node(8); 
	        tree.root.right = new Node(22); 
	        tree.root.left.left = new Node(4); 
	        tree.root.left.right = new Node(12); 
	        tree.root.left.right.left = new Node(10); 
	        tree.root.left.right.right = new Node(14); 
	        //System.out.println(LCA(tree.root,8,12).key);
	        
	        tree = new BinaryTree(); 
	        tree.root = new Node(10); 
	        tree.root.left = new Node(12); 
	        tree.root.right = new Node(15); 
	        tree.root.left.left = new Node(25); 
	        tree.root.left.right = new Node(30); 
	        tree.root.right.left = new Node(36); 
	        
	       /* convertToCDLL(tree.root);
	        Node itr = ctree.root; 
	        do
	        {
	        	System.out.print(itr.key+" ");
	        	itr = itr.right;
	        }while (itr != ctree.root);*/
	        
	        //System.out.println(leafCount(TreeUtil.tree.root));
	        //System.out.println(isBST(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	        
	        tree = new BinaryTree(); 
	        tree.root = new Node(10); 
	        tree.root.left = new Node(8); 
	        tree.root.right = new Node(2); 
	        tree.root.left.left = new Node(3); 
	        tree.root.left.right = new Node(5); 
	        tree.root.right.right = new Node(2); 
	        //System.out.println(isSumProperty(tree.root));
	        
	        isUncheked(tree.root);
	        
	        
	}
	
	public static void preOrderRecursive(Node root){
		if(root == null)
			return;
		System.out.print(root.key+" ");
		preOrderRecursive(root.left);
		preOrderRecursive(root.right);
	}
	
	public static void preOrderIterative(Node root){
		if(root == null)
			return;
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()){
			Node curr = s.pop();
			System.out.print(curr.key + " ");
			
			if(curr.right != null)
				s.push(curr.right);
			if(curr.left != null)
				s.push(curr.left);
		}
	}
	
	public static void inOrderRecursive(Node root){
		if(root == null)
			return;
		inOrderRecursive(root.left);
		System.out.print(root.key+" ");
		inOrderRecursive(root.right);
	}
	
	public static void inorderIterative(Node root){
		if(root == null)
			return;
		
		Stack<Node> n = new Stack<Node>();
		Node curr = root;
		
		while(curr != null || n.size() >0 ){
			while(curr != null){
				n.push(curr);
				curr = curr.left;
			}
			
			curr = n.pop();
			
			System.out.print(curr.key + " ");
			
			curr = curr.right;
		}
	}

	public static void postOrderRecursive(Node root){
		if(root == null)
			return;
		postOrderRecursive(root.left);
		postOrderRecursive(root.right);
		System.out.print(root.key+" ");
	}
	
	public static void postOrderIterative(Node root){
		if(root == null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		s.push(root);
		while(!s.isEmpty()){
			Node curr = s.peek();
			if(curr.isLeaf()){
				Node temp = s.pop();
				System.out.print( temp.key + " ");
			}
			else{
				if(curr.right != null){
					s.push(curr.right);
					curr.right = null;
				}
				if(curr.left != null)
					s.push(curr.left);
					curr.left = null;
			}
				
		}
	}
	
	/**
	 * Level order 
	 * @param root
	 */
	public static void printLevelOrder(Node root){
		int height = calcHeight(root);
		for(int i=1;i<=height;i++)
			printLevel(root,i);
	}
	
	/**
	 * Calculate height of the tree
	 * @param root
	 * @return
	 */
	public static int calcHeight(Node root){
		if(root == null)
			return 0;
		else{
			int lht = calcHeight(root.left);
			int rht = calcHeight(root.right);
			
			if(lht > rht)
				return lht + 1;
			else 
				return rht + 1;
		}
	}
	
	public static void printLevel(Node root,int level){
		if(root == null)
			return;
		if(level == 1)
			System.out.print(root.key + " ");
		else if(level>1){
			printLevel(root.left,level-1);
			printLevel(root.right,level-1);
		}
	} 
	/**********************************************************/
	static int preIndex = 0;
	/**
	 * Given inorder, preorder and post order construct a tree and verify if all of the belong to the tree.
	 * @param a
	 * @param start
	 * @param end
	 * @param element
	 * @return
	 */
	public static int search(int[] a, int start, int end, int element){
		for(int i=start; i<=end; i++)
			if(a[i] == element)
				return i;
		return -1;
	}
	public static Node buildTree(int[] in,int[] pre, int inStrt, int inEnd){
		if(inStrt > inEnd)
			return null;
		
		Node node = new Node(pre[preIndex++]);
		
		if(inStrt == inEnd)
			return node;
		
		int inIndex = search(in,inStrt,inEnd,node.key);
		node.left = buildTree(in, pre, inStrt, inIndex-1);
		node.right = buildTree(in, pre, inIndex+1, inEnd);
		
		return node;
	}
	public static int compareWithPost(Node node,int[] post, int index){
		if (node == null)
			return index;
		index = compareWithPost(node.left, post, index);
		index = compareWithPost(node.right, post, index);
		
		if(node.key == post[index])
			index++;
		else
			return -1;
		
		return index;
	}
	
	/***************************************************/
	
	/**
	 * Find if inorder, preorder, postorder belong to same tree without generating tree.
	 * @param preOrder
	 * @param s
	 * @param inOrder
	 * @param s1
	 * @param postOrder
	 * @param s2
	 * @param length
	 * @return
	 */
	public static boolean checkTree(int[] preOrder, int s, int[] inOrder,int s1, int[] postOrder, int s2, int length){
		if(length == 0)
			return true;
		if(length == 1)
			return (inOrder[s1] == postOrder[s2]) && (postOrder[s2] == preOrder[s]);
		
		int index = -1;
		for(int i=s1;i<length;i++)
			if(inOrder[i] == preOrder[s]){
				index = i;
				break;
			}
		if(index == -1)
			return false;
		
		boolean left = checkTree(preOrder, s+1, inOrder, s1, postOrder, s2, index);
		boolean right = checkTree(preOrder, s+index+1, inOrder, s1+index+1, postOrder, s2+index, length-index-1);
		
		return left && right;
	}
	
	static int postIndex=0;
	/**
	 * find pre order given inorder and post order
	 * Optimization - HashMap can be used instead of search
	 * @param a
	 * @param element
	 * @return
	 */
	public static int search(int[] a,int element){
		for(int i=0; i<a.length;i++)
			if(a[i] == element)
				return i;
		return -1;
	}
	
	public static void findPreOrder(int[] in, int[] post,int inStrt,int inEnd, Stack<Integer> s, HashMap<Integer,Integer> hm){
		if(inStrt>inEnd)
			return;
		Integer val = post[postIndex--];
		int inIndex = hm.get(val);//search(in,val);
		findPreOrder(in, post, inIndex+1, inEnd, s, hm);
		findPreOrder(in, post, inStrt, inIndex-1, s, hm);
		s.push(val);
	}
	
	/**
	 * Find post order of the given preorder, inorder
	 * @param in
	 * @param pre
	 * @param inStrt
	 * @param inEnd
	 */
	public static void findPostOrder(int[] in, int[] pre,int inStrt,int inEnd){
		if(inStrt>inEnd)
			return;
		
		int inIndex = search(in,inStrt,inEnd,pre[preIndex++]);
		findPostOrder(in, pre, inStrt, inIndex-1);
		findPostOrder(in, pre, inIndex+1, inEnd);
		System.out.print(in[inIndex]+" ");
	}
	
	/**
	 * Build tree from preorder and post order traversals
	 * @param pre
	 * @param post
	 * @param strt
	 * @param end
	 * @param length
	 * @return
	 */
	public static Node buildTree(int[] pre, int[] post, int strt, int end, int length){
		
		if(preIndex >=length || strt > end )
			return null;
		
		Node root = new Node(pre[preIndex++]);
		
		if(strt == end || preIndex >=length)
			return root;
		
		int i;
		
		for(i=strt;i <= end; i++)
			if(post[i] == pre[preIndex])
				break;
		
		if(i <= end){
			root.left = buildTree(pre, post, strt, i, length);
			root.right = buildTree(pre, post, i+1, end, length);
		}
		return root;
	}
	
	/**
	 * Build tree from inorder and post order
	 * @param in
	 * @param post
	 * @param inStrt
	 * @param inEnd
	 * @return
	 */
	public static Node buildTreePI(int[] in,int[] post, int inStrt, int inEnd){
		if(inStrt > inEnd)
			return null;
		
		Node node = new Node(post[postIndex--]);
		
		if(inStrt == inEnd)
			return node;
		
		int inIndex = search(in,inStrt,inEnd,node.key);
		node.right = buildTreePI(in, post, inIndex+1, inEnd);
		node.left = buildTreePI(in, post, inStrt, inIndex-1);
				
		return node;
	}
	/**
	 * Create tree from preorder and mirror of preorder
	 * @param pre
	 * @param preM
	 * @param strt
	 * @param end
	 * @param length
	 * @return
	 */
	public static Node buildTreeM(int[] pre,int[] preM,int strt,int end, int length){
		if(preIndex >= length || strt>end)
			return null;
		
		Node root = new Node(pre[preIndex++]);
		
		if(strt == end)
			return root;
		
		int i;
		for(i = strt; i < end; i++)
			if(preM[i] == pre[preIndex])
				break;
		
		if(i <= end){
			root.left = buildTreeM(pre, preM, strt, i-1, length);
			root.right = buildTreeM(pre, preM, i+1, end, length);
		}
		return root;
	}
	
	/**
	 * Insert into a BST
	 * @param node
	 * @param data
	 * @return
	 */
	public static Node insert(Node node, int data){
		if(node == null){
			return new Node(data);
		}
		else{
			if(node.key >= data)
				node.left = insert(node.left,data);
			else
				node.right = insert(node.right, data);
			return node;
		}		
	}
	
	/**
	 * No of nodes in the tree
	 * @param node
	 * @return
	 */
	public static int size(Node node){
		if(node == null)
			return 0;
		else
			return size(node.left) + 1 + size(node.right); 
	}
	/**
	 * Calc no of leaf nodes
	 * @param node
	 * @return
	 */
	public static int leafCount(Node node){
		if(node == null)
			return 0;
		if(node.isLeaf())
			return 1;
		return leafCount(node.left) + leafCount(node.right);
	}
	/**
	 * Delete tree - Automatic GC
	 * @param tree
	 */
	public static void delete(BinaryTree tree){
		tree.root = null;
	}
	
	/**
	 * Create mirror tree
	 * @param node
	 * @return
	 */
	public static Node constructMirrorTree(Node node){
		if(node == null)
			return node;
		
		Node left = constructMirrorTree(node.left);
		Node right = constructMirrorTree(node.right);
		
		node.left = right;
		node.right = left;
		
		return node;
	}
	
	/**
	 * Print paths in a tree
	 * @param node
	 * @param path
	 * @param pathLength
	 */
	public static void printPath(Node node, int[] path, int pathLength){
		
		if(node == null)
			return;
		
		path[pathLength++] = node.key;
		
		if(node.isLeaf()){
			for(int i=0; i<pathLength; i++)
				System.out.print(path[i]+" ");
			System.out.println();
		}
		else{
			printPath(node.left, path, pathLength);
			printPath(node.right, path, pathLength);
		}
		
	}
	
	/**
	 * Print least common ancestor in BST
	 * @param node
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static Node LCA(Node node,int n1, int n2){
		if(node == null)
			return null;
		
		if(node.key > n1 && node.key > n2)
			return LCA(node.left,n1,n2);
		if(node.key < n1 && node.key < n2)
			return LCA(node.right,n1,n2);
		return node;
	}
	
	/**
	 * Convert tree to CDLL
	 * @param node
	 * @return
	 */
	public static Node convertToCDLL(Node node){
		if(node == null)
			return node;
		Node left = convertToCDLL(node.left);
		Node right = convertToCDLL(node.right);	
		
		node.left = node.right = node;
		
		return concatenate(concatenate(left, node), right);
	}
	public static Node concatenate(Node lList,Node rList){
		if(rList == null)
			return lList;
		if(lList == null)
			return rList;
		
		Node lLast = lList.left;
		Node rLast = rList.left;
		
		lLast.right = rList;
		rList.left = lLast;
		

		lList.left = rLast;
		rLast.right = lList;
		
		return lList;
		
	}
	
	/**
	 * check if a BT is BST
	 * @param node
	 * @param min
	 * @param max
	 * @return
	 */
	public static boolean isBST(Node node,int min,int max){
		if(node == null)
			return true;
		if(node.key < min || node.key > max)
			return false;
		return isBST(node.left, min, node.key-1) && isBST(node.right,node.key+1,max);
	}
	
	/**
	 * Check if sum property is true
	 * 	-	Sum of child nodes = root node 
	 * @param node
	 * @return
	 */
	public static boolean isSumProperty(Node node){
		int lData = 0,rData = 0;
		if(node == null || node.isLeaf())
			return true;
		else{
			if(node.left != null)
				lData = node.left.key;
			if(node.right != null)
				rData = node.right.key;
			
			if( (node.key == lData + rData)  &&  (isSumProperty(node.left)) && isSumProperty(node.right) )
				return true;
			else
				return false;
		}
		
	}
	/**
	 * Check sum of covered and uncovered nodes of BT
	 * @param node
	 * @return
	 */
	public static int ucSumLt(Node node){
		if(node.isLeaf())
			return node.key;
		if(node.left == null)
			return node.key + ucSumLt(node.right);
		else
			return node.key + ucSumLt(node.left);
	}
	public static int ucSumRt(Node node){
		if(node.isLeaf())
			return node.key;
		if(node.right == null)
			return node.key + ucSumRt(node.left);
		else
			return node.key + ucSumRt(node.right);
	}
	public static int sum(Node root){
		if(root == null)
			return 0;
		return sum(root.left) + root.key + sum(root.left);
	}
	public static int ucSum(Node root){
		int lb = 0, rb = 0;
		if(root.left != null)
			lb = ucSumLt(root.left);
		if(root.right != null)
			rb = ucSumRt(root.right);
		
		return root.key + lb + rb;
	}
	public static void isUncheked(Node root){
		int sum = sum(root);
		int sumUC = ucSum(root);
		
		System.out.println(sumUC == (sum-sumUC));
	}
}
