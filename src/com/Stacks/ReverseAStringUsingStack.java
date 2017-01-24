package com.Stacks;

import java.util.Arrays;
import java.util.Stack;

public class ReverseAStringUsingStack {
	public static void main(String [] args){
		System.out.print(ReverseAStringUsingStack.reverse("hello"));
	}
	
	public static String reverse(String r){
		Stack<Character> stack = new Stack<Character>();
		char[] ch = r.toCharArray();
		int i=0;
		for(i=0;i<r.length();i++){
			stack.push(ch[i]);
		}
		i=0;
		
		while(!stack.isEmpty())
		{
			ch[i++]= stack.pop();
		}
		return String.valueOf(ch);
	}
}
