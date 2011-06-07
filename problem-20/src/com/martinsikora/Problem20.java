package com.martinsikora;

public class Problem20 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String num = "1";
		//num = Problem20.multiply("1254", "84351"); // 105 776 154
		//num = Problem20.multiply("999", "999"); // 998 001
		for (int i=100; i > 1; i--) {
			num = BigInteger.multiply(num, Integer.toString(i));
		}
		
		int sum = 0;
		for (int i=0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i+1));
		}
		
		System.out.println("Cycles: " + BigInteger.cycles);
		System.out.println("Mult: " + num);
		System.out.println("Sum nums: " + sum);
	}


}
