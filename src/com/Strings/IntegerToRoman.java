package com.Strings;

import java.util.HashMap;

public class IntegerToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman obj= new IntegerToRoman();
		System.out.println(obj.integerToRoman(91));
		System.out.println(obj.integerToRoman(1));
		System.out.println(obj.integerToRoman(2));
		System.out.println(obj.integerToRoman(3));
		System.out.println(obj.integerToRoman(4));
		System.out.println(obj.integerToRoman(5));
		System.out.println(obj.integerToRoman(6));
		System.out.println(obj.integerToRoman(7));
		System.out.println(obj.integerToRoman(8));
		System.out.println(obj.integerToRoman(9));
		System.out.println(obj.integerToRoman(10));
		System.out.println(obj.integerToRoman(20));
		System.out.println(obj.integerToRoman(30));
		System.out.println(obj.integerToRoman(60));
		System.out.println(obj.integerToRoman(90));
		System.out.println(obj.integerToRoman(100));
		System.out.println(obj.integerToRoman(200));
		System.out.println(obj.integerToRoman(400));
		System.out.println(obj.integerToRoman(900));
		System.out.println(obj.integerToRoman(1000));
		
		
		
	}
	
	public String integerToRoman(int a){
		int[] val = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] digits={ "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
							"IX", "V", "IV", "I"};
		StringBuffer sb = new StringBuffer();
		int i=0;
		while(a>=0 && i<13){
			while(a>=val[i])
			{
				a-=val[i];
				sb.append(digits[i]);
			}
			i++;
		}
		return sb.toString();
	}


}
