package com.martinsikora;

public class Problem10 {

	protected static long cycles;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long sum = 2;
		for (int i=3; i < 2000000; i=i+2) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		System.out.println("Sum: " + sum);
		System.out.println("Cycles: " + cycles);
	}
	
	protected static boolean isPrime(int num) {
		for (int j=2; j <= Math.ceil(Math.pow(num, 0.5)); j++) {
			cycles++;
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}

}
