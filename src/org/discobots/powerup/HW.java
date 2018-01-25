/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.discobots.powerup;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class HW {
	//NOTE: commented out because 2017 bot has y-cables to just use 2 motor ports
	
	
	//PWM ports
	public static int frontLeftDrive = 0;
	//public static int backLeftDrive = 2;
	
	public static int frontRightDrive = 1;
	//public static int backRightDrive = 3;
	
	
	//PCM ports
	public static int solenoid1 = 0;
	
	public static int dsolenoid1 = 1;
	public static int dsolenoid2 = 2;
}
