package org.discobots.powerup.utils;

//Constants - useful numbers put into a place that makes them easy to change
public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs
	public static double kDeadband = 0;
	
	//kRampband - used only in auton, this is the most the drive motor can change by (2.0 or higher makes this negligible)
	public static double kRampband = 0.05;
	
	//kScaleWait and kLaunchWait - the delay for launching with the switch versus launching with the scale
	public static long kScaleWait = 85;
	public static long kSwitchWait = 43;
	
	//kIntakeWait - the delay between setting the intake to open and launching the cube
	public static long kIntakeWait = 250;
	
	//kLaunchCooldown - waits this period of time (milliseconds) after launching 
	public static long kLaunchCooldown = 1000;
	
	//kDistPerTick - the distance (in inches) per drive encoder tick
	public static double kDistPerTick = 1;
	
	//kIntakeSpeed - the speed that the intake motors operate at (both forward and backward)
	public static double kIntakeSpeed = 0.5;
}
