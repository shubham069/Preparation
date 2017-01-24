package com.Trees;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

import sun.misc.Queue;

public class Trees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root= TreeNode.insert(null, 5);
		TreeNode.insert(root, 6);
		TreeNode.insert(root, 7);
		TreeNode.insert(root, 3);
		TreeNode.insert(root, 1);
		TreeNode.insert(root, 4);
		//Print Inorder
		/*TreeNode.inOrder(root);
		System.out.println();*/
		
		//Find a node in Tree
		//TreeNode tmp = TreeNode.find(root, 3);
		//System.out.println("\n"+tmp.val);
		
		//System.out.println(TreeNode.isValidBST(root));
		
		//Print root-to-leaf paths
		ArrayList<Integer> list = new ArrayList<Integer>();
		//TreeNode.printPaths(root, list);
		
		try {
			TreeNode.LevelOrderTraversal(root);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		TreeNode.ZigzagTraversal(root);
		
		
		TreeNode.printVerticalPath(root);
		
		
	}

}

class TreeNode{
	public int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {val= x;
	left=null;
	right = null;}
	
	static TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
	
	public static TreeNode insert(TreeNode root, int a){
		if(root==null)
			return new TreeNode(a);
		TreeNode iterator = root;
		while(iterator!=null){
			if (a < iterator.val) {
	            if (iterator.left == null) {
	                iterator.left = new TreeNode(a);
	                break;
	            }
	            iterator = iterator.left;
	        } else {
	            if (iterator.right == null) {
	                iterator.right = new TreeNode(a);
	                break;
	            }
	            iterator = iterator.right;
	        }
		}
		return root;
	}
	
	public static void inOrder(TreeNode root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}
	
	public static TreeNode find(TreeNode root, int data ){
		if(root==null)
			return null;
		if(root.val==data)
			return root;
		if(root.val>data)
			return find(root.left,data);
		else if(root.val<data)
			return find(root.right,data);
		return null;
	}
	
	public static int isValidBST(TreeNode a) {
		
	    return BSTUtil(a, -1);
	}
	public static int BSTUtil(TreeNode root, int prev){
        if(root==null)
            return 1;
        if(BSTUtil(root.left,prev)==0)
            return 0;
        if(root.val<prev)
            return 0;
        prev = root.val;
        return BSTUtil(root.right,prev);
            
        }
	
	public static void printPaths(TreeNode root, ArrayList<Integer> list){
		if(root==null)
			return;
		list.add(root.val);
		//If the node is a leaf node, print the list
		if(root.left==null && root.right==null)
			{
				printList(list);
				list.remove(list.size()-1);
			}
		
		else{
			printPaths(root.left, list);
			printPaths(root.right, list);
			list.remove(list.size()-1);
			
		}
	}
	
	private static void printList(ArrayList<Integer> list){
		for(Integer a : list)
			System.out.print(a);
		System.out.println();	
	}
	
	public static void LevelOrderTraversal(TreeNode root) throws InterruptedException{
		if(root==null)
			return;
		Queue<TreeNode> q = new Queue<TreeNode>();
		
		q.enqueue(root);
		while(!q.isEmpty()){
			TreeNode tmp = (TreeNode)q.dequeue();
			System.out.print(tmp.val);
		
			if(tmp.left!=null)
				q.enqueue(tmp.left);
			if(tmp.right!=null)
				q.enqueue(tmp.right);
			
			
		}
		System.out.println();
	}
	
	/**
	 * The logic is to use two stacks. One will push the elements left to right.
	 * The other will push the elements right to left
	 * @param root
	 */
	public static void ZigzagTraversal(TreeNode root){
		if(root ==null)
			return;
		//System.out.print(root.val);
		Stack<TreeNode> s1= new Stack<TreeNode>();
		Stack<TreeNode> s2= new Stack<TreeNode>();
		s1.push(root);
		while(!s1.isEmpty()|| !s2.isEmpty()){
			while(!s1.isEmpty()){
				TreeNode tmp = (TreeNode)s1.pop();
				System.out.print(tmp.val);
				if(tmp.left!=null)
					s2.push(tmp.left);
				if(tmp.right!=null)
					s2.push(tmp.right);
			}
			while(!s2.isEmpty()){
				TreeNode tmp = (TreeNode)s2.pop();
				System.out.print(tmp.val);
				// Note right is pushed before left
				if(tmp.right!=null)
					s1.push(tmp.right);
				if(tmp.left!=null)
					s1.push(tmp.left);
			}
			
		}
		System.out.println();
	}
	
	public static void printVertically(TreeNode root, int index){
		if(root == null)
			return;
		if(map.containsKey(index)){
			ArrayList<Integer> lst = map.get(index);
			lst.add(root.val);
			map.put(index, lst);
		}
		else{
			ArrayList<Integer> lst = new ArrayList<Integer>();
			lst.add(root.val);
			map.put(index, lst);
		}
		printVertically(root.left, index-1);
		printVertically(root.right, index+1);
		
	}
	
	public static void printVerticalPath(TreeNode root){
		printVertically(root, 0);
		for(ArrayList<Integer> lst : map.values())
		{
			for(Integer a : lst){
				System.out.print(a);
			}
			System.out.println();
		}
	}
	
}
