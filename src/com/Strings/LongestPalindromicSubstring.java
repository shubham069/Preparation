package com.Strings;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestPalindromicSubstring.longestPalSubstring("forgeeksskeegfor");

	}

	public static void longestPalSubstring(String input){
		boolean matrix[][]= new boolean[input.length()][input.length()];
		// Single length characters are palindrome
		for(int i=0;i<input.length();i++)
			matrix[i][i]= true;
		int maxLength=1;
		int startIndex=0;
		// Check for two character string
		for(int i=0;i<input.length()-1;i++){
			if(input.charAt(i)==input.charAt(i+1))
				{
					matrix[i][i+1]=true;
					startIndex =i;
					maxLength=2;
				}
			
		}
		
		for(int sublen=3;sublen<=input.length();sublen++){
			for(int i=0; i<=input.length()-sublen;i++){
				int j = i+sublen-1;
				
				if(matrix[i+1][j-1] && input.charAt(i)==input.charAt(j))
					{
						matrix[i][j]=true;
						if(sublen>maxLength)
						{
							maxLength=sublen;
							startIndex=i;
						}
					}
			}
		}
		printMatrix(matrix);
		System.out.println(input.substring(startIndex, startIndex+maxLength));
		
	}
	public static void printMatrix(boolean [][] LP){
		for(int i=0;i<LP.length;i++){
			for(int j=0;j<LP.length;j++){
				System.out.print("  " + (LP[i][j]==true?'T':'F'));
			}	
			System.out.println("");
		}
	}
}
