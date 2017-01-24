package com.recursion;

import java.util.Scanner;

public class power {
	public static int calculatePower(int n, int p) {
		if (p == 0)
			return 1;
		else if (p % 2 == 0) {
			int y = calculatePower(n, p / 2);
			return y * y;
		} else
			return n * calculatePower(n, p - 1);
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scan.nextInt();
		System.out.println("Enter power");
		int p = scan.nextInt();
		int value = calculatePower(n, p);
		System.out.println(value);
	}

}