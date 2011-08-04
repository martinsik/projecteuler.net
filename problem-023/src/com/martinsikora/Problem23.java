package com.martinsikora;

import java.util.ArrayList;

public class Problem23 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> abundant = new ArrayList<Integer>();
		long total = 0;
		
		for (int i=1; i < 28123; i++) {
			int divisors[] = BigInteger.divisors(i);
			
			long sum = 0;
			for (int j : divisors) {
				if (i != j) {
					sum += j;
				}
			}
			
			if (sum > i) {
				abundant.add(i);
			}
		}
		
		int[] abundantInt = new int[abundant.size()];
		for (int i=0; i < abundantInt.length; i++) {
			abundantInt[i] = abundant.get(i).intValue();
		}
		
		for (int i=1; i <= 28123; i++) {
			//System.out.println(i);
			byte can = -1;
			for (int j=0; j < abundantInt.length; j++) {
				for (int k=abundantInt.length - 1; k >= 0; k--) {
					int first = abundantInt[j];
					if (first > i) {
						can = 0;
						break;
					}
					int second = abundantInt[k];
					
					if (first > second) {
						can = 0;
						break;
					} else if (first + second == i) {
						can = 1;
						break;
					}
				}
				if (can == 1) {
					break;
				}
			}
			
			if (can != 1) {
				System.out.println(i);
				total += i;
			}
		}
		
		System.out.println("Total: " + total);

	}

}
