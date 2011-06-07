package com.martinsikora;

public class Problem12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long i=0, triangle = 0;
		
		while (true) {
			triangle = i * (i+1) / 2;
			if (BigInteger.divisors(triangle).length > 200) {
				break;
			}
			i++;
		}
		System.out.println("Cycles: " + BigInteger.cycles);
		System.out.println("Triangle: " + triangle);
	}

}
