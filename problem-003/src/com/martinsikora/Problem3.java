package com.martinsikora;

public class Problem3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double num = 600851475143l;
		//double num = 39;
		double maxFactor = 1;
		
		double max = 2 * Math.ceil(Math.pow(num, 0.5));
		double i = 1;
		int cycles = 0;
		
		while (i <= num && i <= max) {
			if (num % i == 0) {
				num /= i;
				maxFactor = i;
				i = 1;
			}
			i += 2;
			cycles++;
		}
		
		System.out.println("Max factor: " + maxFactor);
		System.out.println("Cycles: " + cycles);
	}

}
