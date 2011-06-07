package com.martinsikora.shared;

public class Math {

	public static int cycles = 0;
	
	public static String power(int base, int pow) {
		String num = Integer.toString(base);
		boolean carry = false;
		
		for (int i=2; i <= pow; i++) {
			StringBuilder newNum = new StringBuilder();
			for (int j=num.length() - 1; j >= 0 || carry; j--) {
				cycles++;
				int digit = 0;
				if (j >= 0) {
					digit = base * Integer.parseInt(num.substring(j, j+1));
				}
				
				if (carry) {
					digit++;
					carry = false;
				}
				
				if (digit >= 10) {
					digit -= 10;
					carry = true;
				}
				newNum.append(digit);
			}
			num = newNum.reverse().toString();
		}
		return num;
	}
	
}
