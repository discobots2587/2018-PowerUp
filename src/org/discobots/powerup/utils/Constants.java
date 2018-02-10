package org.discobots.powerup.utils;

//Constants - useful numbers put into a place that makes them easy to change
public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs (0.1 covers most joystick sticky positions)
	public static double kDeadband = 0.1;
	
	//kScaleWait and kLaunchWait - the delay for launching with the switch versus launching with the scale
	public static long kScaleWait = 100;
	public static long kSwitchWait = 55;
	
	//kLaunchCooldown - waits this period of time (milliseconds) after launching 
	public static long kLaunchCooldown = 1000;
	
	//kDistPerTick - the distance (in inches) per drive encoder tick
	public static double kDistPerTick = 1.0;
}
