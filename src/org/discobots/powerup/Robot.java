/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.discobots.powerup;

import org.discobots.powerup.commands.*;
import org.discobots.powerup.subsystems.Arm;
import org.discobots.powerup.subsystems.Drivetrain;
import org.discobots.powerup.subsystems.Intake;
import org.discobots.powerup.subsystems.Launcher;
import org.discobots.powerup.utils.Logger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */

public class Robot extends TimedRobot {
	public static Arm arm;
	public static Drivetrain drive;
	public static Intake intake;
	public static Launcher launcher;
	
	public static Command driveCommand;
			
	public static OI oi;

	public static enum position {
		LEFT, RIGHT, CENTER
	}
	
	public static enum autonType {
		TIMED, ENCODER, GYRO
	}
	
	public static position pos;
	
	public static Logger logger = Logger.getInstance();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		//subsystem initialization
		arm = new Arm();
		drive = new Drivetrain();
		intake = new Intake();
		launcher = new Launcher();
		
		//OI and dashboard initialization
		oi = new OI();
		Dashboard.init();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		if(Timer.getMatchTime()<0)
		{
			Dashboard.updatePreMatch();
		}	
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		Autonomous.init();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// Make sure to disable autonomous
		
		driveCommand = Dashboard.driveChooser.getSelected();
		driveCommand.start();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Dashboard.update();
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}