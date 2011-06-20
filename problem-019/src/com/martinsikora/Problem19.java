package com.martinsikora;

import java.util.Calendar;

public class Problem19 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("1900-01-01");
		Calendar cal = Calendar.getInstance();
		cal.set(1901, 1, 1);
		
		int days = 0;
		while (cal.get(Calendar.YEAR) < 2001) {
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY && cal.get(Calendar.DAY_OF_MONTH) == 1) {
				days++;
			}
			cal.add(Calendar.MONTH, 1);
		}
		
		System.err.println("Days: " + days);
	}

}
