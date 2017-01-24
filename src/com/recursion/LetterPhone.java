package com.recursion;
import java.util.*;

public class LetterPhone {


	public static void main(String [] args){
    
		LetterPhone phone= new LetterPhone();
		String digits = "0";
//		List<String> result = phone.letterComb(digits);
//		
//		for(String str: result)
//			System.out.print(str+" ");
//		System.out.println();
		
		List<String> resultItr = phone.letterCombinationsRec(digits);
		
		for(String str: resultItr)
			System.out.print(str+" ");

	}
	public List<String> letterCombinationsItr(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        List<String> rec = new LinkedList<>();
        rec.addAll(list);
        return rec;
    }
	public List<String> letterCombinationsRec(String digits) {
        String[] letters = {"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> rec = new LinkedList<>();
        StringBuilder string = new StringBuilder();
        letterCombinations(digits, 0, letters, string, rec);
        return rec;
    }
    
    private void letterCombinations(String digits, int number, String[] letters, StringBuilder string, List<String> rec) {
    	//Base condition : Add numbers in the list until the length equals the digit length
        if (digits.length() == number) { 
            rec.add(string.toString());
            return;
        }
        String letter = letters[digits.charAt(number) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            string.append(letter.charAt(i));
            letterCombinations(digits, number + 1, letters, string, rec);
            string.deleteCharAt(string.length() - 1);
        }
    }
    
    public List<String> letterComb(String digits){
    	   HashMap<Integer, String> map = new HashMap<Integer, String>();
    	    map.put(2, "abc");
    	    map.put(3, "def");
    	    map.put(4, "ghi");
    	    map.put(5, "jkl");
    	    map.put(6, "mno");
    	    map.put(7, "pqrs");
    	    map.put(8, "tuv");
    	    map.put(9, "wxyz");
    	    map.put(0, "");
    	    
    	    ArrayList<String> result = new ArrayList<String>();
    	    int fi = digits.charAt(0)-'0';
    	    String first =map.get(fi);
    	    int se = digits.charAt(1)-'0';
    	    String second =map.get(se);
    	    for(int i=0;i<first.length();i++)
    	    {
    	    	for (int j=0; j<second.length();j++)
    	    		result.add(first.charAt(i)+""+second.charAt(j));
    	    }
    	    return result;
    }
}
