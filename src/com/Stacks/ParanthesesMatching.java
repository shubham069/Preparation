package com.Stacks;
import java.util.Stack;

public class ParanthesesMatching {
	public static void main(String[] args){
		System.out.println(ParanthesesMatching.parantheses("])"));
	}
	public static int parantheses(String a){
	Stack<Character> stack = new Stack<Character>();
    boolean notValid=false;
    for(int i =0; i<a.length();i++){
        switch(a.charAt(i)){
            case '[':
                stack.push('[');
                break;
            case ']':
                if(stack.isEmpty() || stack.peek() != '[')
                   {
                       notValid=true;
                       break;
                   } 
                   else
                   stack.pop();
                   break;
           case '(':
                stack.push('(');
                break;
            case ')':
                if(stack.isEmpty() ||stack.peek() != '(')
                   {
                       notValid=true;
                       break;
                   } 
                   else
                   stack.pop();
                   break;
           	case '{':
                stack.push('{');
                break;
            case '}':
                if(stack.isEmpty() ||stack.peek() != '{')
                   {
                       notValid=true;
                       break;
                   } 
                   else
                   stack.pop();
                   break;
        
    }
    }
    if(!stack.isEmpty() || notValid)
        return 0;
   else 
        return 1;
}
}
