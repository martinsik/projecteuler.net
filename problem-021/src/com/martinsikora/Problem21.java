package com.martinsikora;

import java.util.ArrayList;

public class Problem21 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = 10000;
		long sum = 0;
		//ArrayList<Integer> used = new ArrayList<Integer>();
		
		for (int i=1; i < max; i++) {
			for (int j=i; j < max; j++) {
				if (i == j/* || used.contains(i)*/) {
					continue;
				} else if (i == sumDivisors(j) && j == sumDivisors(i)) {
					System.out.println(i + " vs " + j);
					sum += i + j;
				}
			}
		}
		System.out.println("Total sum: " + sum);
	}
	
	protected static int sumDivisors(long num) {
		int[] divisors = BigInteger.divisors(num);
		int sum = 0;
		for (int i : divisors) {
			if (num != i) {
				sum += i;
			}
		}
		return sum;
	}

}
