package com.martinsikora;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Problem18 {

	protected static int[][] next;
	protected static int[][] path;
	protected static int[] triangle;
	
	protected static int MAX_DISTANCE = 1000000000;

	public static void main(String[] args) throws Exception {
		InputStream stream = Problem18.class.getResourceAsStream("/com/martinsikora/resources/triangle-big.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
		int triangleSize = 100;
		int vertices = triangleSize*(triangleSize+1)/2;
		
		// load triangle
		String line;
		triangle = new int[vertices];
		int index = 0;
		
		while ((line = reader.readLine()) != null) {
			//int lineIndex = 15 - index - 1;
			String[] nums = line.split(" ");
			for (int i=0; i < nums.length; i++) {
				triangle[index++] = 100 - Integer.parseInt(nums[i]);
			}
		}
		
		// init Floyd–Warshall algorithm
		path = new int[vertices][vertices];
		
		//path[0][0] = triangle[0][0];
		for (int i=0; i < triangle.length; i++) {
			for (int j=0; j < triangle.length; j++) {
				// http://en.wikipedia.org/wiki/Triangular_number
				// Triangular roots and tests for triangular numbers
				int r1 = (int) Math.floor((Math.sqrt(8*i + 1) - 1) / 2);
				int r2 = (int) Math.floor((Math.sqrt(8*j + 1) - 1) / 2);
				int c1 = i - r1*(r1+1)/2;
				int c2 = j - r2*(r2+1)/2;
				
				if (i == j) {
					path[i][j] = 0;
				} else if (r1 == r2 -1 && (c1 == c2 || c1 == c2 - 1)) {
					path[i][j] = triangle[j];
				} else {
					path[i][j] = MAX_DISTANCE;
				}
			}
		}
		
		
		next = new int[vertices][vertices];
		
		// Floyd–Warshall algorithm
		for (int k=0; k < vertices; k++) {
			for (int i=0; i < vertices; i++) {
				for (int j=0; j < vertices; j++) {
					if (path[i][k] + path[k][j] < path[i][j]) {
						path[i][j] = path[i][k] + path[k][j];
						next[i][j] = k;					
					}
				}
			}
		}
		
		int max = 0;
		for (int i=vertices - 1; i >= vertices - triangleSize; i--) {
			String path = "0" + getPath(0, i) + i;
			String[] nodes = path.split(" ");
			int localMax = 0;
			for (int j=0; j < nodes.length; j++) {
				localMax += 100 - triangle[Integer.parseInt(nodes[j])];
			}
			if (localMax > max) {
				max = localMax;
			}
			System.out.println("Path: " + path);
		}
		
		System.out.println("Total max: " + max);
	}
	
	protected static String getPath(int i, int j) {
		if (path[i][j] == MAX_DISTANCE) {
			return "no path";
		}
		int intermediate = next[i][j];
		if (intermediate == 0) {
			return " ";
		} else {
			return getPath(i, intermediate) + intermediate + getPath(intermediate, j);
		}
	}
	
	/*protected int getTriangleValue(int n) {
		
	}*/

}
