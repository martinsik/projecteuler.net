package com.martinsikora;

public class Problem4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxNum = 99999;
		int num1, num2;
		num1 = num2 = maxNum;
		int maxPal = 0;
		int cycles = 0;
		
		while (num1 > 0) {
			while (num2 > 0) {
				cycles++;
				
				int pal = num1 * num2;
				if (pal < maxPal) {
					break;
				}
				String reverse = (new StringBuffer(Integer.toString(pal))).reverse().toString();
				if (Integer.toString(pal).compareTo(reverse) == 0 && pal > maxPal) {
					maxPal = pal;
					break;
				}
				num2--;
				
				if (num2 < 100) {
					break;
				}
			}
			num2 = num1;
			num1--;
		}
		System.out.println("Largest palindrome: " + maxPal);
		System.out.println("Cycles: " + cycles);
	}

}
