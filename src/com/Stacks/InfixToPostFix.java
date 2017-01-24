package com.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class InfixToPostFix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InfixToPostFix.infixToPostfix("1^2*3-4+5/6/(7+8)");

	}
	public static void infixToPostfix(String str){
		Stack<Character> stack = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('}', '{');
		brackets.put(')', '(');

		for(char ch : str.toCharArray()){
			if(ch>='0' && ch<='9')
				sb.append(ch);

			else if(ch=='+' || ch=='-' || ch=='/' || ch=='*'){

				while(!stack.isEmpty()  && !hasPrecedence(stack.peek(), ch)){
					sb.append(stack.pop());
				}
				stack.push(ch);
			}
			
			else if(brackets.containsValue(ch))
				stack.push(ch);
			else if(brackets.containsKey(ch)){
				while(!stack.isEmpty() && stack.peek()!=brackets.get(ch))
					sb.append(stack.pop());
				//For the opening bracket
				stack.pop();
			}
		}
		//pop the left overs
		while(!stack.isEmpty())
			sb.append(stack.pop());
		System.out.println(sb.toString());
	}


	public static boolean hasPrecedence(char top ,char newOp){
		if((top=='-' || top =='+') && (newOp=='*'|| newOp=='/'))
			return true;
		else
			return false;
	}

}
