package org.discobots.powerup.utils;

//Constants - useful numbers put into a place that makes them easy to change
public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs
	public static double kDeadband = 0.05;
	
	//kRampband - used mainly in the drive, this is the most the drive motor can change by
	public static double kRampband = 0.2;
	
	//kScaleWait and kLaunchWait - the delay for launching with the switch versus launching with the scale
	public static long kScaleWait = 85;
	public static long kSwitchWait = 43;
	
	//kLaunchCooldown - waits this period of time (milliseconds) after launching 
	public static long kLaunchCooldown = 1000;
	
	//kDistPerTick - the distance (in inches) per drive encoder tick
	public static double kDistPerTick = 1.0;
	
	//kIntakeSpeed - the speed that the intake motors operate at (both forward and backward)
	public static double kIntakeSpeed = 0.5;
}
