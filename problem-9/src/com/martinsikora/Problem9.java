package com.martinsikora;

public class Problem9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int cycles = 0;
		for (int c = 997; c > 3; c--) {
			for (int b = 1000-c-1; b > 0; b--) {
				cycles++;
				int a = 1000 - b - c;
				if (a < 1) {
					break;
				}
				if (a*a + b*b == c*c) {
					System.out.println("a=" + a + " b=" + b + " c=" + c);
					System.out.println("Cycles: " + cycles);
					return;
				}
			}
		}
		System.out.println("not found");
	}

}
