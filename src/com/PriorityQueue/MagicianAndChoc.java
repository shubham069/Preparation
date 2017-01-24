package com.PriorityQueue;
/*
Given N bags, each bag contains Ai chocolates. 
There is a kid and a magician. 
In one unit of time, kid chooses a random bag i, eats Ai chocolates, 
then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates 
kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

Note: Return your answer modulo 10^9+7
*/

import java.util.ArrayList;
import java.util.TreeMap;

public class MagicianAndChoc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MagicianAndChoc choc = new MagicianAndChoc();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(6);
		list.add(5);
		
		System.out.println(choc.nchoc(3, list));
	}
		public int nchoc(int A, ArrayList<Integer> B) {
	        TreeMap<Integer, Integer> bag = new TreeMap<Integer, Integer>();
	        int count =0;
	        for(int a : B){
	            if(count!=0){
	                bag.put(a, count);
	                count++;
	            }
	            else
	                count++;
	        }
	        int sum=0,key,value, newKey;
	        
	        while(A!=0){
	            if(bag.size()!=0)
	            {
	                key =bag.lastKey();
	                System.out.println(key);
	                value = bag.get(key);
	                sum+= key;
	                System.out.println(sum);
	                bag.remove(key);
	                newKey = key/2;
	                bag.put(newKey,value);
	                A--;
	            }
	        }
	        return sum;
	        
	    
	}

}
