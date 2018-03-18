/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.discobots.powerup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

//importing all the commands
import org.discobots.powerup.commands.*;
import org.discobots.powerup.lib.AXISButton;
import org.discobots.powerup.lib.DPADButton;
import org.discobots.powerup.lib.Gamepad;
import org.discobots.powerup.lib.DPADButton.POV;
import org.discobots.powerup.lib.Fightstick;

//import org.discobots.steamworks.utils.Gamepad.DPadButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */


public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	//Joystick stick = new Joystick(0);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	 
	 //pov = dpad
	 //axis = joystick
	public Gamepad p_gp = new Gamepad(0, "Primary"); //primary driver
	public Fightstick s_fs = new Fightstick(1, "Secondary"); //secondary driver
	
	//create all the buttons for primary controller
	private Button p_btn_RB = new JoystickButton(p_gp, Gamepad.BTN_RB);
	private Button p_btn_LB = new JoystickButton(p_gp, Gamepad.BTN_LB);
	private Button p_btn_RT = new JoystickButton(p_gp, Gamepad.BTN_RT);
	private Button p_btn_LT = new JoystickButton(p_gp, Gamepad.BTN_LT);
	private Button p_btn_back = new JoystickButton(p_gp, Gamepad.BTN_BACK);
	private Button p_btn_start = new JoystickButton(p_gp, Gamepad.BTN_START);
	private Button p_btn_A = new JoystickButton(p_gp, Gamepad.BTN_A);
	private Button p_btn_X = new JoystickButton(p_gp, Gamepad.BTN_X);
	private Button p_btn_B = new JoystickButton(p_gp, Gamepad.BTN_B);
	private Button p_btn_Y = new JoystickButton(p_gp, Gamepad.BTN_Y);
	private DPADButton p_dpad_up = new DPADButton(p_gp, POV.UP);
	private DPADButton p_dpad_down = new DPADButton(p_gp, POV.DOWN);
	private DPADButton p_dpad_right = new DPADButton(p_gp, POV.RIGHT);
	private DPADButton p_dpad_left = new DPADButton(p_gp, POV.LEFT);
	
	//create all the buttons for secondary controller
	private Button s_btn_R1 = new JoystickButton(s_fs, Fightstick.BTN_R1);
	private Button s_btn_L1 = new JoystickButton(s_fs, Fightstick.BTN_L1);
	private Button s_btn_R3 = new JoystickButton(s_fs, Fightstick.BTN_R3);
	private Button s_btn_L3 = new JoystickButton(s_fs, Fightstick.BTN_L3);
	private Button s_btn_share = new JoystickButton(s_fs, Fightstick.BTN_SHARE);
	private Button s_btn_options = new JoystickButton(s_fs, Fightstick.BTN_OPTIONS);
	private Button s_btn_A = new JoystickButton(s_fs, Fightstick.BTN_A);
	private Button s_btn_X = new JoystickButton(s_fs, Fightstick.BTN_X);
	private Button s_btn_B = new JoystickButton(s_fs, Fightstick.BTN_B);
	private Button s_btn_Y = new JoystickButton(s_fs, Fightstick.BTN_Y);
	private DPADButton s_dpad_up = new DPADButton(s_fs, POV.UP);
	private DPADButton s_dpad_down = new DPADButton(s_fs, POV.DOWN);
	private DPADButton s_dpad_right = new DPADButton(s_fs, POV.RIGHT);
	private DPADButton s_dpad_left = new DPADButton(s_fs, POV.LEFT);
	private AXISButton s_btn_L2 = new AXISButton(s_fs, Fightstick.AXIS_L2);
	private AXISButton s_btn_R2 = new AXISButton(s_fs, Fightstick.AXIS_R2);
	
	//in here, give the buttons commands
	public OI() {
		p_btn_B.whenPressed(new Launch(Launch.type.SCALE));
		p_btn_X.whenPressed(new Launch(Launch.type.SWITCH));
		
		p_dpad_right.whenPressed(new IntakeToggle());
		
		p_btn_RB.whenPressed(new IntakeSet(-1));
		p_btn_RB.whenReleased(new IntakeSet(0));
		
		p_btn_RT.whenPressed(new IntakeSet(1));
		p_btn_RT.whenReleased(new IntakeSet(0));
		
		//p_btn_LB.whenPressed(new ArmSet(-1));
		//p_btn_LB.whenReleased(new ArmSet(0));
		
		//p_btn_LT.whenPressed(new ArmSet(1));
		//p_btn_LT.whenReleased(new ArmSet(0));
		
		p_btn_LB.whenPressed(new Command() {
			@Override
			
			public void initialize() {
				Robot.arm.up();
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			}
		});
		
		p_btn_LT.whenPressed(new Command() {
			@Override
			public void initialize() {
				Robot.arm.down();
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			}
		});
		
		//s_btn_B.toggleWhenPressed(new WinchSet(1)); WINCH
		
		s_btn_L1.whenPressed(new LaunchWaitChange(Launch.type.SCALE, 5));
		s_btn_L2.whenPressed(new LaunchWaitChange(Launch.type.SCALE, -5));
		
		s_btn_R1.whenPressed(new IntakeSet(-1));
		s_btn_R1.whenReleased(new IntakeSet(0));
		
		s_btn_R2.whenPressed(new IntakeSet(1));
		s_btn_R2.whenReleased(new IntakeSet(0));
		
		s_btn_A.whenPressed(new ArmPIDToggle());
		
		s_btn_X.whenPressed(new ArmPIDReset());
		s_btn_Y.whenPressed(new IntakeToggle());
		
		s_btn_B.whenPressed(new Command() {
			@Override
			public void initialize() {
				Robot.arm.setIndex(1);
			}
			
			@Override
			protected boolean isFinished() {
				return true;
			}
		});
	}
}
