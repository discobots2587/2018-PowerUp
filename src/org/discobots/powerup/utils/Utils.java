package org.discobots.powerup.utils;

//Utils - methods counterpart to Constants
public class Utils {
	
		//millisToSeconds - converts milliseconds to seconds, method because this shows up everywhere
		public static double millisToSeconds(long ms) {
			return ((double)ms)/1000;
		}
		
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
