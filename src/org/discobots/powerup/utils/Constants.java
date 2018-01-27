package org.discobots.powerup.utils;

public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs (0.1 covers most joystick "default" positions)
	public static double kDeadband = 0.1;
	
	//kLaunchwait - waits this period of time (milliseconds) to let the launching pistons extend
	public static long kLaunchwait = 250;
	
	//kScaleCooldown - waits this period of time (milliseconds) after launching to the scale
	public static long kScaleCooldown = 0;
	
	//kSwitchCooldown - waits this period of time (milliseconds) after launching to the switch
	public static long kSwitchCooldown = 0;
	
	//millisToSeconds - converts milliseconds to seconds, method because this shows up everywhere
	public static double millisToSeconds(long ms) {
		return ((double)ms)/1000;
	}
}
