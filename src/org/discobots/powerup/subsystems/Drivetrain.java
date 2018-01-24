package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive;
	
	
	
	public Drivetrain() {
		Spark m_frontLeft = new Spark(HW.frontLeftDrive);  //set all three left ports to what is configured in the HW
		//Spark m_rearLeft = new Spark(HW.backLeftDrive);
		SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft);

		Spark m_frontRight = new Spark(HW.frontRightDrive);  //set all three right ports to what is configured in the HW
		//Spark m_rearRight = new Spark(HW.backRightDrive);
		SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight);
		
		drive = new DifferentialDrive(left, right);
		
		drive.setDeadband(Constants.kDeadband);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void arcadeDrive(double xSpeed, double zRotation) { //contrary to the documentation, but that is ok
		drive.arcadeDrive(zRotation, xSpeed, true); //forward, clockwise = positive; decrease sensitivity at low speed is FALSE
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right, true); //forward = positive; decrease sensitivity at low speed is FALSE
	}
}
