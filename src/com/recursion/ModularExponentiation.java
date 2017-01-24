package com.recursion;

import java.util.Scanner;

/*
 * Time complexity if O(logn) which is the best possible
 * Case :
 * A : 71045970
B : 41535484
C : 64735492
Your function returned the following :
6598572
The expected returned value :
20805472
 */

public class ModularExponentiation {

	public static int calculateModularExponentiaition(int n, int p, int m) {
		if(n ==0)
			return 0;
		else if (p == 0)
			return 1;
		else if (p % 2 == 0) {
			int y = calculateModularExponentiaition(n, p / 2, m);
			int r=  (y*y)%m;
			return r;
			//return r < 0 ? r + m : r;
		} else
		{
			int h =  n%m;
			//int k  = h < 0 ? h + m : h;
	        int j =  calculateModularExponentiaition(n, p - 1, m);
	        int l = (h * j)%m ;
	        return l ;
	        //return l < 0 ? l+m : l;
		}
	}


	 public static int modpow(int value , int power, int mod){
	    int e = 1;
	   
	    for (int i = 0; i < power; i++) {
	         e = ((e * value) % mod);
	            
	    }
	        
	        return e;
	}
	public static void main(String[] args) {
		int a = -17412928 + 64735492;
		System.out.println(a);
		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter a number");
//		int n = scan.nextInt();
//		System.out.println("Enter power");
//		int p = scan.nextInt();
//
//		System.out.println("Enter modular");
//		int m = scan.nextInt();
		
		int n = 71045970;
		int p = 41535484;
		int m = 64735492;

		int value = calculateModularExponentiaition(n, p, m);
		System.out.println(value);
		
		
		System.out.println("Iterative Method: "+modpow(n,p,m));
	}
}

