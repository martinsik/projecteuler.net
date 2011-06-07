package com.martinsikora;

import com.martinsikora.shared.Math;

// 

public class Problem16 {

	public static void main(String[] args) {
		//int cycles = 0;
		
		String num = Math.power(2, 1000);
		
		int sum = 0;
		for (int i=0; i < num.length(); i++) {
			sum += Integer.parseInt(num.substring(i, i+1));
		}
		
		//System.out.println("Cycles: " + cycles);
		System.out.println("Result 2^1000: " + num);
		System.out.println("Sum 2^1000: " + sum);
		
	}

}
