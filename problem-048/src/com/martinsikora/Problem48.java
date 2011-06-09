package com.martinsikora;

/*
 * Last ten: 9110846700
 */
public class Problem48 {

	
	public static void main(String[] args) {
		String total = "0";
		for (int i=1; i <= 1000; i++) {
			System.out.println(i + "...");
			total = BigInteger.sum(total, BigInteger.pow(i, i));
		}
		System.out.println("Cycles: " + BigInteger.cycles);
		System.out.println("Total: " + total);
		System.out.println("Last ten: " + total.substring(total.length() - 10, total.length()));
		
		//System.out.println("2 ^ 100: " + powBy2(2, 100));
	}

}
