package org.discobots.powerup.utils;

//Constants - useful numbers put into a place that makes them easy to change
public class Constants {
	
	//kDeadband - driving ignores this value and lower for the controller inputs
	public static double kDeadband = 0.05;
	
	//kRampband - used only in auton, this is the most the drive motor can change by (2.0 or higher makes this negligible)
	public static double kRampband = 0.05;
	
	//kScaleWait and kLaunchWait - the delay for launching with the switch versus launching with the scale
	public static long kScaleWait = 150;
	public static long kSwitchWait = 50;
	
	//kIntakeWait - the delay between setting the intake to open and launching the cube
	public static long kIntakeWait = 250;
	
	//kLaunchCooldown - waits this period of time (milliseconds) after launching 
	public static long kLaunchCooldown = 1000;
	
	//kInchPerTick - the distance (in inches) per drive encoder tick
	//public static double kInchPerTick = (20.0)/(1900.0)*(100.0/140.0)*(112.0/150.0);
	public static double kInchPerTick = 0.01043502;
	public static double kTickPerInch = 1.0/(kInchPerTick);
	
	//kEncoderTuringFactor - the number to divide the encoder diff. by in order to get accurate encoder turns
	public static double kEncoderTurningFactor = 1.0;
	
	//kIntakeSpeed - the speed that the intake motors operate at (both forward and backward)
	public static double kIntakeSpeed = 0.75;
 }
