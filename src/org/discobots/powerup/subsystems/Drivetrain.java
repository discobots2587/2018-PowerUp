package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive;
	
	//NOTE: commented out because the motor ports have y cables to split it
	
	public Drivetrain() {
		Spark m_frontLeft = new Spark(HW.frontLeftDrive);  //set all three left ports to what is configured in the HW
		//Spark m_rearLeft = new Spark(HW.backLeftDrive);
		SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft);

		Spark m_frontRight = new Spark(HW.frontRightDrive);  //set all three right ports to what is configured in the HW
		//Spark m_rearRight = new Spark(HW.backRightDrive);
		SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight);
		
		drive = new DifferentialDrive(left, right);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void arcadeDrive(double x, double y) {
		drive.arcadeDrive(x, y, true); //forward, clockwise = positive; decrease sensitivity at low speed is FALSE
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right, true); //forward = positive; decrease sensitivity at low speed is FALSE
	}
}
