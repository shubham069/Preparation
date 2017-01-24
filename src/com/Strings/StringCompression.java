package com.Strings;

public class StringCompression {
	public static void main(String[] args){
		String str= "aabccccaaad";
		StringCompression compress= new StringCompression();
		System.out.println(1<<0);
		compress.stringComp(str);
	}
	
	public void stringComp(String str){
		char ch[] = str.toCharArray();
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<str.length();i++){
			int count=1;
			builder.append(ch[i]);
			while(i<str.length()-1 && ch[i]==ch[i+1] )
			{	
				count++;
				i++;
			}
//			if(count!=1)
//				i--;
			builder.append(count);

		}
		System.out.println(builder.toString());
	}
}
