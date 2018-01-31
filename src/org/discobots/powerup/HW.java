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
	//PWM ports
	public static int leftDrive = 0;	
	public static int rightDrive = 1;
	
	
	//PCM ports
	public static int solenoid1 = 0;
	public static int solenoid2 = 1;
	public static int solenoid3 = 2;
}
