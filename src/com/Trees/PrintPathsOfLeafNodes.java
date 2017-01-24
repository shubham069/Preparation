package com.Trees;

public class PrintPathsOfLeafNodes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintPathsOfLeafNodes.printPaths(Node );
	}

}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data= data;
		left= null;
		right=null;
	}
	
	public Node insert(Node root, int data){
		if(root==null)
			{
			root= new Node(data);
			return root;
			}
		insert(root.left, data);
		return null;
	}
}
