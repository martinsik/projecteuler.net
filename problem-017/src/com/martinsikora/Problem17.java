package com.martinsikora;

public class Problem17 {

	static int[] numbers = {0,3,3,5,4,4,3,5,5,4};
	
	/*
	 * 10 - ten
	 * 11 - eleven
	 * 12 - twelve
	 * 13 - thirteen
	 * 14 - fourteen
	 * 15 - fifteen
	 * 16 - sixteen
	 * 17 - seventeen
	 * 18 - eighteen
	 * 19 - nineteen
	 */
	static int[] numbersTeens = {3,6,6,8,8,7,7,9,8,8};
	
	/*
	 * 20 - twenty
	 * 30 - thirty
	 * 40 - forty
	 * 50 - fifty
	 * 60 - sixty
	 * 70 - seventy
	 * 80 - eighty
	 * 90 - ninety
	 */
	static int[] tens = {6,6,5,5,5,7,6,6};
	
	static int hundred = 7;
	
	static int thousand = 8;
	
	static int and = 3; 
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int total = 0;
		for (int i=1; i < 1000; i++) {
			total += getValue(i);
		}
		total += numbers[1] + thousand;
		
		System.out.println("Total: " + total);
		
		/*
		System.out.println("4: "   + getValue(4));
		System.out.println("12: "  + getValue(12));
		System.out.println("123: " + getValue(123));
		System.out.println("505: " + getValue(505));
		*/
		/*
		System.out.println("342: " + getValue(342)); // 23
		System.out.println("115: " + getValue(115)); // 20
		*/
	}
	
	protected static int getValue(int num) {
		int total = 0;
		if (num >= 100) {
			total += numbers[num/100] + hundred;
			num -= (num/100) * 100;
			
			if (num > 0) {
				total += and;
			}
		}
		
		if (num >= 10) {
			if (num >= 10 && num <= 19) {
				total += numbersTeens[num-10];
				return total;
			} else {
				total += tens[num/10 - 2];
			}
			num -= (num/10) * 10;
		}
		
		total += numbers[num];
		return total;
	}

}

