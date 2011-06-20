package com.martinsikora;

public class Problem30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 2;
		int total = 0;
		while (num != 0) {
			int powered = sumPower(num, 5);
			if (powered == num) {
				total += powered;
				System.out.println("Num: " + num);
				System.out.println("Total: " + total);
			}
			num++;
		}
	}
	
	protected static byte[] numbers(int num) {
		byte[] numbers = Integer.toString(num).getBytes();
		for (int i=0; i < numbers.length; i++) {
			numbers[i] = (byte) (numbers[i] - '0'); 
		}
		return numbers;
	}
	
	protected static int sumPower(int num, int pow) {
		int total = 0;
		byte[] numbers = Problem30.numbers(num);
		for (int i=0; i < numbers.length; i++) {
			total += Math.pow(numbers[i], pow);
		}
		return total;
	}

}
