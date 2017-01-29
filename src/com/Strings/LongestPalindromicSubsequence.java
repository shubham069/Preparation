package com.Strings;

import java.util.Arrays;

/*
 * In subsequence the letters need not be continuous. Other question is based on substring where
 * the letters need to be continuous.
 */

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LongestPalindromicSubsequence.longestPalSeq("agbdba");
		LongestPalindromicSubsequence.longestPalSeq("AABCDEBAZ");


	}
	
	public static void longestPalSeq(String input){
		int matrix[][]= new int[input.length()][input.length()];
		//StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++)
			matrix[i][i]= 1;
		for(int sublen=2;sublen<=input.length();sublen++){
			for(int i=0; i<=input.length()-sublen;i++){
				int j = i+sublen-1;
				
				if(input.charAt(i)==input.charAt(j))
					matrix[i][j]= 2+matrix[i+1][j-1];
				else
					matrix[i][j]= Math.max(matrix[i+1][j], matrix[i][j-1]);
			}
		}
		printMatrix(matrix);
		System.out.println(matrix[0][input.length()-1]);
		backtrack(matrix, input.toCharArray());
	}
	
	public static void printMatrix(int [][] LP){
		for(int i=0;i<LP.length;i++){
			for(int j=0;j<LP.length;j++){
				System.out.print("  " + LP[i][j]);
			}	
			System.out.println("");
		}
	}
	
	private static void backtrack(int[][] dpTable, char[] charArray) {
		char[] palindrome = new char[dpTable[0][dpTable.length - 1]];
		int index = palindrome.length - 1;
		int length = index;
		for (int j = dpTable.length - 1, i = 0; i < dpTable.length && j > 0;) {
			if (dpTable[i][j] == 1) {
				palindrome[index] = charArray[j];
				break;
			} else if (dpTable[i][j] == 2 + dpTable[i + 1][j - 1]) {
				palindrome[index] = charArray[j];
				palindrome[length - index] = charArray[j];
				index--;
				i++;
				j--;
			} else {
				if (dpTable[i][j - 1] == dpTable[i][j])
					j--;
				else
					i++;
			}
		}
		System.out.println(Arrays.toString(palindrome));
	}

}
