package com.javads.datastructure;

import java.util.LinkedList;

public class Graph {

	public int V; //Vertices
	public LinkedList<Integer> adj[]; // Adjacent list
	
	@SuppressWarnings("unchecked")
	public Graph(int v){
		V = v;
		adj = new LinkedList[v];
		for(int i = 0; i< v; i++)
			adj[i] = new LinkedList<Integer>();
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
	}
}
