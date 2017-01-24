package com.LinkedList;

public class DeleteNthFromEnd {
	public static void main(String[] args){
		
	}

	public ListNode removeNthFromEnd(ListNode a, int b) {
	    ListNode slow = a;
	    ListNode fast = a;
	    if(fast==null)
	    return null;
	    int count=0;
	    while(fast!=null){
	        fast = fast.next;
	        if(count==b)
	            slow=slow.next;
	       
	        count++;
	    }
	    if(b>count){
	        ListNode tmp2 = a.next;
	        a= null;
	        return tmp2;
	    }
	    System.out.print(slow.val);
	    ListNode tmp = slow.next;
	    if(tmp!=null)
	    slow.next= tmp.next;
	    else
	    return null;
	    tmp= null;

	    return a;
	}
	
	 class ListNode {
		      public int val;
		      public ListNode next;
		      ListNode(int x) { val = x; next = null; }
		  }
}
