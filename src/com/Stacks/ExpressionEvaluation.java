package com.Stacks;

import java.util.HashMap;
import java.util.Stack;

public class ExpressionEvaluation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExpressionEvaluation.evaluateExp("100*{(2+12)/28}");
	}

	public static void evaluateExp(String str){

		Stack<Character> oper= new Stack<Character>();
		Stack<Double> numbers = new Stack<Double>();
		HashMap<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('}', '{');
		brackets.put(')', '(');
		char ch[] = str.toCharArray();
		for(int i=0;i<str.length();i++){
			if(ch[i]==' ')
				continue;
			if(ch[i]>='0'&& ch[i]<='9'){
				StringBuilder sb = new StringBuilder();
				while(i<str.length() && ch[i]>='0' && ch[i]<='9')
					sb.append(ch[i++]);
				i--;
				numbers.push(Double.parseDouble(sb.toString()));
			}
			else if(ch[i] =='+' || ch[i] =='-' || ch[i] =='*' || ch[i] =='/'){
				while(!oper.isEmpty() && !brackets.containsValue(oper.peek()) && !hasPrecedence(oper.peek(), ch[i])){
					evaluate(oper.pop(),numbers);
				}
				oper.push(ch[i]);
			}
			else if(brackets.containsValue(ch[i]))
				oper.push(ch[i]);
			else if(brackets.containsKey(ch[i])){
				while(!oper.isEmpty() && brackets.get(ch[i])!=oper.peek()){
					evaluate(oper.pop(),numbers);
				}
				// to pop the opening bracket
				oper.pop();
			}
		}
		while(!oper.isEmpty())
			evaluate(oper.pop(),numbers);
		if(numbers.size()>1)
			System.out.println("error!");
		else
			System.out.println(numbers.peek());
	}



	public static boolean hasPrecedence(char top ,char newOp){
		if((top=='-' || top =='+') && (newOp=='*'|| newOp=='/'))
			return true;
		else
			return false;
	}

	public static void evaluate(char ch, Stack<Double> numbers){

		double n1=0, n2=0;
		if(!numbers.isEmpty())
			n1 = numbers.pop();
		if(!numbers.isEmpty())
			n2 = numbers.pop();
		else
			System.out.println("not enough operands");

		double result=0;
		
		switch(ch){
		case '+':
			result= n1+n2;
			break;
		case '-':
			result = n1-n2;
			break;
		case '*':
			result = n1* n2;
			break;
		case '/':
			if(n1==0)
				System.out.println("Divide by zero error!");
			else
				result = n2 / n1;
			break;
		}
		numbers.push(result);
	}
}
