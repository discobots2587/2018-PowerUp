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
	public static int leftDrive = 9;	
	public static int rightDrive = 0;
	public static int leftArm = 8;
	public static int rightArm = 7;
	
	//CAN ports
	public static int talonsrx_pigeon = 0;
	
	//PCM ports
	public static int solenoid1 = 0;
	public static int solenoid2 = 1;
	public static int solenoid3 = 2;
	
	//DIO ports
	public static int left_encoder1 = 0;
	public static int left_encoder2 = 1;
	public static int right_encoder1 = 2;
	public static int right_encoder2 = 3;
	public static int limSwitch1 = 4;
	public static int limSwitch2 = 5;
	
	//Analog ports
	public static int potentiometer = 0;
	public static int supplyPressure = 1;
	public static int launcherPressure = 2;
}
