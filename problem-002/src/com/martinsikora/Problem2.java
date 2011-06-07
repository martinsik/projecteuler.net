package com.martinsikora;

public class Problem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int fib[] = new int[2];
		fib[0] = fib[1] = 1;
		int sum = 0;
		int old;
		
		while(fib[1] < 4000000) {
			old = fib[1];
			fib[1] += fib[0];
			if (fib[1] % 2 == 0) {
				sum += fib[1];
			}
			fib[0] = old;
		}
		
		System.out.println("Sum: " + sum);
	}

}
