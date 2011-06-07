package com.martinsikora;

import java.util.ArrayList;

public class BigInteger {
	
	public static long cycles;
	
	/**
	 * Multiply two variables
	 * 
	 * @param   first    first number
	 * @param   second   second number
	 * @return  returns multiplied numbers
	 */
	public static String multiply(String first, String second) {
		byte[][] sums = new byte[Math.max(first.length(), second.length())][first.length() + second.length()];
		int padding = 0;
		
		while (first.length() != second.length()) {
			if (first.length() > second.length()) {
				second = "0" + second;
			} else {
				first = "0" + first;
			}
		}

		for (int i=first.length()-1; i >= 0; i--) {
			int num1 = Integer.parseInt(first.substring(i, i+1));
			int digit = 0;
			int j = sums[i].length - 2;
			
			for (int k=first.length()-1; k >= 0 && j-padding+1 >= 0; j--, k--) {
				cycles++;
				int num2 = Integer.parseInt(second.substring(k, k+1));
				digit = num1 * num2;
				
				sums[i][j-padding+1] += digit % 10;
				if (j-padding >= 0) {
					sums[i][j-padding] += digit / 10;
				}
			}
			padding++;
		}
		
		//int carry = false;
		return BigInteger.sum(sums);
	}
	
	/**
	 * Sum two variables
	 * 
	 * @param   first    first number as string
	 * @param   second   second number as string
	 * @return  returns sumed numbers
	 */
	public static String sum(String first, String second) {
		
		while (first.length() != second.length()) {
			if (first.length() > second.length()) {
				second = "0" + second;
			} else {
				first = "0" + first;
			}
		}
		
		byte[][] bytes = new byte[2][first.length()];
		for (int i=0; i < bytes[0].length; i++) {
			bytes[0][i] = (byte) Integer.parseInt(first.substring(i, i+1));
			bytes[1][i] = (byte) Integer.parseInt(second.substring(i, i+1));
		}
		
		return BigInteger.sum(bytes);
	}
	
	/**
	 * Sum multiple variables stored as bytes
	 * 
	 * @param   bytes   Two dimensional array of numbers stored as bytes
	 * @return  returns sumed numbers
	 */
	public static String sum(byte[][] bytes) {
		byte[] newNum = new byte[bytes[0].length + 1];
		for (int i=bytes[0].length-1; i >= 0; i--) {
			int k = i+1;
			int sum = 0;
			for (int j=0; j < bytes.length; j++) {
				cycles++;
				sum += bytes[j][i];
			}
			newNum[k] += sum % 10;
			if (newNum[k] >= 10) {
				newNum[k-1] = (byte) (newNum[k] / 10);
				newNum[k] = (byte) (newNum[k] % 10);
			}
			if (k > 0) {
				newNum[k-1] += (byte) (sum / 10);
			}
		}
		
		StringBuilder str = new StringBuilder();
		int i=-1; 
		while (++i < newNum.length - 1 && newNum[i] == 0) {}
		for (; i < newNum.length; i++) {
			str.append(Integer.toString(newNum[i]));
		}
		return str.toString();
		
	}
	
	public static int[] divisors(long num) {
		ArrayList<Integer> divisors = new ArrayList<Integer>();
		for (int i=1; i <= num / 2; i++) {
			cycles++;
			if (num % i == 0) {
				divisors.add(i);
			}
		}
		divisors.add((int) num);
		
		int[] retArray = new int[divisors.size()];
		for (int i = 0; i < divisors.size(); i++) {
			retArray[i] = divisors.get(i);
		}
		return retArray;
	}
	
}
