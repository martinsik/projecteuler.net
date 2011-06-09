package com.martinsikora;

/*
Cycles: 538257874439
Routes: 137846528820

real    41m40.934s
user    41m41.050s
sys     0m0.060s
*/


public class Problem15 {

	protected static long cycles = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long routes = seek(0, 0, 20);
		System.out.println("Cycles: " + cycles);
		System.out.println("Routes: " + routes);
	}
	
	protected static long seek(int x, int y, int gridSize) {
		cycles++;
		if (x == gridSize && y == gridSize) {
			return 1;
		}
		
		long total = 0;
		if (x < gridSize) {
			total += seek(x+1, y, gridSize);
		}
		if (y < gridSize) {
			total += seek(x, y+1, gridSize);
		}
		
		return total;
	}

}
