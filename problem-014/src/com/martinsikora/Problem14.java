package com.martinsikora;


public class Problem14 {

	protected static long cycles = 0;
	
	static int MEMORY_SIZE = 10000000;

	public static void main(String[] args) {
		long[] knownResponses = new long[MEMORY_SIZE];
		long i = 1, maxNum = 0, maxChain = 0;
		
		for (; i < 1000000; i++) {
			long test = i, chain = 0;
			while (test != 1) {
				chain++; cycles++;
				if (test < MEMORY_SIZE && knownResponses[(int) test] != 0) {
					chain += knownResponses[(int) test];
					break;
				} else {
					if (test % 2 == 0) {
						test /= 2;
					} else {
						test = 3 * test + 1;
					}
				}
			}
			knownResponses[(int) i] = chain;
			
			if (chain > maxChain) {
				maxChain = chain;
				maxNum = i;
			}
		}
		
		System.out.println("Cycles: " + cycles);
		System.out.println("Max chain: " + maxNum + "(" + maxChain + " long chain)");

	}

}
