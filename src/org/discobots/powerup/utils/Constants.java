package org.discobots.powerup.utils;

public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs (0.1 covers most joystick "default" positions)
	public static double kDeadband = 0.1;
	
	//kScaleWait and kLaunchWait - the delay for launching with the switch versus launching with the scale
	public static long kScaleWait = 250;
	public static long kSwitchWait = 250;
	
	//kSwitchCooldown - waits this period of time (milliseconds) after launching 
	public static long kLaunchCooldown = 0;
	
	//millisToSeconds - converts milliseconds to seconds, method because this shows up everywhere
	public static double millisToSeconds(long ms) {
		return ((double)ms)/1000;
	}
}
