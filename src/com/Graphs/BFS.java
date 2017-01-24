package com.Graphs;

import java.util.Stack;

public class BFS {
	public static void main(String[] args){
		
	}
	
	class Vertex{
		public char label;
		public boolean visited;
		public Vertex(char lab){
			label=lab;
			visited=false;
		}
	}
	
	class Graph{
		private final int maxVertices=20;
		private Vertex vertexList[];
		private int adjMatrix[][];
		private int vertexCount;
		private Stack<Integer> theStack;
		public Graph(){
			vertexList = new Vertex[maxVertices];
			adjMatrix = new int[maxVertices][maxVertices];
			vertexCount=0;
			for(int y=0; y<maxVertices;y++){
				for(int x=0;x<maxVertices;x++)
					adjMatrix[x][y]=0;
			theStack= new Stack();
			}
		}
		
	
	
		public void addVertex(char lab){
			vertexList[vertexCount++]= new Vertex(lab);
		}
		
		public void addEdge(int start, int end){
			adjMatrix[start][end]=1;
			adjMatrix[end][start]=1;
		}
		
		public void displayVertex(int v){
			System.out.println(vertexList[v].label);
		}
		
		public void dfs(){
			
		}
	
	}
	
}
