/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.discobots.powerup;

import org.discobots.powerup.subsystems.*;
import org.discobots.powerup.utils.Logger;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

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
	public static Electrical electrical;
	
	public static Command driveCommand;
			
	public static OI oi;

	public static enum position {
		LEFT, RIGHT, CENTER
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
		electrical = new Electrical();
		
		//OI and dashboard initialization
		Dashboard.init();
		oi = new OI();
		
		new Thread(() -> {
			UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
            camera.setResolution(320, 240);
            camera.setFPS(30);
		}).start();
	}
	
	@Override
	public void robotPeriodic() {
		Robot.drive.pigeon.getYawPitchRoll(Robot.drive.yawPitchRoll);
		Robot.drive.pigeon.getAccelerometerAngles(Robot.drive.accel_xyz);
		Dashboard.update();
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
		Autonomous.periodic();
	}

	@Override
	public void teleopInit() {
		Teleop.init();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Teleop.periodic();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}