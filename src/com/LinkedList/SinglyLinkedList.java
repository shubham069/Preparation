package com.LinkedList;

import com.LinkedList.DeleteNthFromEnd.ListNode;

public class SinglyLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node newNode = new Node(1);
		Node head = newNode.insert(newNode, 1, null);
		head = newNode.insert(new Node(2), 2, head);
		head = newNode.insert(new Node(3), 3, head);
		head = newNode.insert(new Node(4), 4, head);
		head = newNode.insert(new Node(5), 5, head);
		Node temp= head;
		Node.display(temp);
		head = newNode.removeNthFromEnd(head, 1);
		//head = newNode.delete(head, 3);
		Node.display(head);

	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node insert(Node newNode, int position, Node head) {
		if (head == null) {
			return newNode;
		} else if (position == 1) {
			newNode.next = head;
			head = newNode;
			return head;
		} else {
			int count = 1;
			Node prevNode = head;
			Node currNode;
			while (count < position-1) {
				prevNode = prevNode.next;
				count++;
			}
			currNode = prevNode.next;
			prevNode.next = newNode;
			newNode.next = currNode;
			return head;
		}
	}
	public static void display(Node head){
		while(head!=null){
			System.out.print(head.data + "-->");
			head = head.next;
		}
		System.out.println();
	}
	
	public Node delete(Node head, int position){
		if(head == null){
			return head;
		}
		else if(position==1 ){
			if(head.next==null)
			return head;
			else{
				Node temp =head;
				temp =null;
				return head.next;
			}
		}
		else{
			int count=1;
			Node prevNode = head;
			Node currNode;
			while(count<position-1){
				prevNode= prevNode.next;
				count++;
			}
			currNode = prevNode.next;
			prevNode.next= currNode.next;
			return head;
		}
	}
	
	public Node removeNthFromEnd(Node a, int b) {
		Node slow = a;
		Node fast = a;
	    if(fast==null)
	    return null;
	    int count=0;
	    while(fast.next!=null){
	        fast = fast.next;
	        if(count>=b)
	            slow=slow.next;
	       
	        count++;
	    }
	    if(b>count){
	    	Node tmp2 = a.next;
	        a= null;
	        return tmp2;
	    }
	    //System.out.print(slow.data);
	    Node tmp = slow.next;
	    if(tmp!=null)
	    slow.next= tmp.next;
	    else
	    return null;
	    tmp= null;

	    return a;
	}
}
