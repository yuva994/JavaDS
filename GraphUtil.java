package com.icdms;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import com.icdms.datastructure.Graph;

public class GraphUtil {
	private static Graph g;
	public static void main(String[] args){
		g = new Graph(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
	
        //BFS(0);
        //DFS();
        
        g = new Graph(6); 
        g.addEdge(5, 2); 
        g.addEdge(5, 0); 
        g.addEdge(4, 0); 
        g.addEdge(4, 1); 
        g.addEdge(2, 3); 
        g.addEdge(3, 1); 
        
        topologicalSort();
	}
	
	/**
	 * Breadth First Search - Queue
	 * @param s
	 */
	public static void BFS(int s){
		boolean[] visited = new boolean[g.V];
		LinkedList<Integer> queue = new LinkedList<Integer>();
		visited[s] = true;
		queue.add(s);
		
		while(!queue.isEmpty()){
			int v = queue.poll();
			System.out.print(v+" ");
			
			Iterator<Integer> i = g.adj[v].listIterator();
			while(i.hasNext()){
				int n = i.next();
				if(!visited[n]){
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	/**
	 * Depth First Search - Stack
	 */
	public static void DFS(){
		boolean[] visited = new boolean[g.V];
		
		for(int i=0; i<g.V;i++)
			if(!visited[i])
				DFSUtil(i,visited);
	}
	
	/**
	 * Depth First Search - Stack
	 * @param v
	 * @param visited
	 */
	public static void DFSUtil(int v, boolean[] visited){
	
		visited[v] = true;
		System.out.print(v+" ");
		
		Iterator<Integer> i = g.adj[v].listIterator();
		while(i.hasNext()){
			int n = i.next();
			if(!visited[n])
				DFSUtil(n, visited);
		}
	}
	
	/**
	 * Topological Sort - Stack
	 */
	public static void topologicalSort(){
		boolean[] visited = new boolean[g.V];
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0;i<g.V;i++)
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		
		while (!stack.empty()) 
			System.out.print(stack.pop() + " "); 
		
	}
	
	/**
	 * Topological Sort - Stack
	 * @param n
	 * @param visited
	 * @param stack
	 */
	public static void topologicalSortUtil(int n, boolean[] visited, Stack<Integer> stack){
		
		visited[n] = true;
		int i;
		
		Iterator<Integer> itr = g.adj[n].listIterator();
		while(itr.hasNext()){
			i = itr.next();
			if(!visited[i])
				topologicalSortUtil(i, visited, stack);
		}
		
		stack.push(new Integer(n));
	}
}
