package com.martinsikora;

import java.security.Security;

public class Problem7 {

	protected static int cycles = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int num = 3;
		int i = 2;
		
		while (i < 10001) {
			num += 2;
			if (Problem7.testPrime(num)) {
				i++;
			}
		}
		
		System.out.println(i + "st prime: " + num);
		System.out.println("Cycles: " + Problem7.cycles);
	}
	
	protected static boolean testPrime(int num) {
		for (int i=2; i <= Math.ceil(Math.pow(num, 0.5)); i++) {
			Problem7.cycles++;
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
