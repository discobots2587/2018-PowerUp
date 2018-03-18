package org.discobots.powerup.utils;

public class Utils {
	
	/**
	 * Converts milliseconds to seconds
	 *
	 * @param  ms The number of milliseconds as a long
	 * @return Returns the number of seconds
	 */
	//millisToSeconds - converts milliseconds to seconds, method because this shows up everywhere
	public static double millisToSeconds(long ms) {
		return ((double)ms)/1000;
	}
	
	/**
	 * Gets time in seconds and returns a formatted string (min:sec)
	 *
	 * @param  sec The number of seconds as a double
	 * @return Returns a formatted string 
	 */
	public static String secToMinAndSec(double sec) {
		sec = (int)sec;
		return String.format("%02d:%02d", sec/60, sec%60);
	}
	
	
	public static double encoderAvg(double left, double right) {
		double error = 1;
		if(Math.abs(left)<error) {
			return right;
		} else if(Math.abs(right)<error) {
			return left;
		} else {
			return (left+right)/2;
		}
	}
}
