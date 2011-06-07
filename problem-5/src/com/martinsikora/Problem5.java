package com.martinsikora;

public class Problem5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int minDiff = 2520;
		/*for (int i=2; i <= 20; i++) {
			total *= i;			
		}*/
		
		boolean divisable = false;
		
		while (true) {
			minDiff += 20;
			divisable = false;
			for (int i=1; i <= 20; i++) {
				if (minDiff % i != 0) {
					divisable = true;
					break;
				}
			}
			
			if (!divisable) {
				break;				
			}
		}
		
		System.out.println("Result: " + minDiff);
		
		
	}

}
