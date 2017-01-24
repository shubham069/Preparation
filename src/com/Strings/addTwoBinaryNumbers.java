package com.Strings;

public class addTwoBinaryNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(addTwoBinaryNumbers.addBinary("100", "11"));
	}
	

	public static String addBinary(String a, String b) {
	    if(a==null)
	        return b;
	   if(b==null)
	        return a;
	   StringBuilder sb = new StringBuilder();
	   int len1 = a.length()-1;
	   int len2 = b.length()-1;
	   int carry=0;
	   int sum=0;
	   while(len1>=0 || len2>=0){
	       sum =carry;
	       if(len1>=0){
	           sum+=a.charAt(len1)-'0';
	           len1--;
	       }
	       if(len2>=0){
	           sum+=b.charAt(len2)-'0';
	           len2--;
	       }
	       carry= sum>>1;
	       sum= sum & 1;
	      sb.append(sum==0?'0':'1'); 
	   }
	   if(carry>0)
	        sb.append('1');
	   sb.reverse();
	   return sb.toString();
	}


}
