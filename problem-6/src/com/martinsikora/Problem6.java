package com.martinsikora;

public class Problem6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int sumSqares = 0;
		int squaresSum = 0;
		
		for (int i=1; i <= 100; i++) {
			sumSqares += i*i;
			squaresSum += i;
		}
		
		System.out.println("Difference: " + (squaresSum * squaresSum - sumSqares));
	}

}
