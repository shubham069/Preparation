package com.TwoSigma;

import java.util.HashMap;
import java.util.HashSet;

public class StringChain {
	public static String[] input= {"a", "b", "ba", "bda", "bdac"};
	public static HashSet<String> hm = new HashSet<String>();
	//static int maxCount=1;
	//static int count =1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(String str : input)
			hm.add(str);
		int maxCount=1;
		int count =1;
		StringBuilder sb = new StringBuilder();
		for(String str:input){
			count =checkLength(str, count);
			if(maxCount>count)
				maxCount=count;
				
		}
		//System.out.println(maxCount);
		System.out.println(longestChain(input));
	}
	
	public static int checkLength(String str, int count){
		StringBuilder sb = new StringBuilder();
		int tmpCount=count;
			for(int i=0;i<str.length();i++)
			{
				sb.append(str.substring(0,i));
				sb.append(str.substring(i+1,str.length()));
				if(hm.contains(sb.toString()))
					{
						tmpCount++;
						checkLength(sb.toString(), count);
						tmpCount--;
					}
				sb.setLength(0);
			}
			if(count<tmpCount)
				count=tmpCount;
			
			return count;
	}
	
	
	static int longestChain(String[] words) {
	       if(words==null || words.length==0)
	           return 0;
	       // Set will hold all the words and will give O(1) for lookup
	       HashSet<String> wordsSet = new HashSet<String>();
	       /* This is similar to a dynamic programming problem where 
	       * we can store the value of intermediate results 
	       * and use them as is.
	       * The HashMap stores the count of the longestChain for every new word
	       * So in case of searching the length we encounter the word in the hash map
	       * we can directly add the lenght stored against the word and return.
	       */
	       HashMap<String, Integer> wordDp= new HashMap<String, Integer>();
	       
	       for(String str: words){
	           wordsSet.add(str);
	       }
	       
	       int count=0;
	       int maxCount=0;
	       for(String str: words){
	           //Only consider those words whose length is greater than maxCount found till now
	           if(str.length()>maxCount){
	               count= chainSearch(str, wordsSet, wordDp) + 1;
	               if(count>maxCount)
	                   maxCount= count;
	           }
	       }
	        return maxCount;

	    }

	public static int chainSearch(String word, HashSet<String> wordsSet, HashMap<String, Integer> wordDp){
	    int count =0;
	    int tmpCount=0;
	    StringBuilder sb = new StringBuilder();
	    for(int i=0; i<word.length();i++){
	        sb.append(word.substring(0,i));
	        sb.append(word.substring(i+1));
	        
	        //check whether the new word exists in the set or not
	        if(wordsSet.contains(sb.toString())){
	            if(wordDp.containsKey(sb.toString())){
	                tmpCount= wordDp.get(sb.toString());
	                if(count<tmpCount)
	                    count=tmpCount;
	            }
	            else{
	                tmpCount = chainSearch(sb.toString(), wordsSet, wordDp)+1;
	                if(tmpCount>count)
	                    count = tmpCount;
	            }
	        }
	        sb.setLength(0);
	       }
	    //wordDp.put(word, count+1);
	    return count;
	   }

}
