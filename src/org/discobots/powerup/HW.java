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
	public static int rightDrive  = 0;
	public static int leftDrive   = 9;
	public static int rightIntake = 1;
	public static int leftIntake  = 2;
	public static int armMotor    = 3;
	public static int winch		  = 4;
	
	//CAN ports
	public static int talonsrx_pigeon = 35; //CAN id
	
	//PCM (12V) ports
	public static int pcm12v    = 0; //CAN id
	public static int launcher1 = 0;
	public static int launcher2 = 1;
	public static int launcher3 = 2;
	
	//PCM (24V) ports
	public static int pcm24v   = 1; //CAN id
	public static int claw1    = 0;
	public static int claw2    = 1;
	public static int shifter1 = 6;
	public static int shifter2 = 7;
	
	//DIO ports
	public static int right_encoder1    = 0;
	public static int right_encoder2    = 1;
	public static int left_encoder1     = 2;
	public static int left_encoder2     = 3;
	
	public static int ultrasonic1       = 4;
	public static int utlrasonic2       = 5;
	public static int arm_switch_top    = 8; //temp
	public static int arm_switch_bottom = 9; //temp
	
	//Analog ports
	public static int supplyPressure   = 1;
	public static int launcherPressure = 2;
	public static int potentiometer    = 3;
}
