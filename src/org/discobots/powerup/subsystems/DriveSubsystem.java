package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {

	public DifferentialDrive drive;
	
	public DriveSubsystem() {
		Spark m_frontLeft = new Spark(HW.frontLeftDrive);  //set all three left ports to what is configured in the HW
		Spark m_midLeft = new Spark(HW.midLeftDrive);
		Spark m_rearLeft = new Spark(HW.backLeftDrive);
		SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_midLeft, m_rearLeft);

		Spark m_frontRight = new Spark(HW.frontRightDrive);  //set all three right ports to what is configured in the HW
		Spark m_midRight = new Spark(HW.midRightDrive);
		Spark m_rearRight = new Spark(HW.backRightDrive);
		SpeedControllerGroup right = new SpeedControllerGroup(m_frontRight, m_midRight, m_rearRight);
		
		drive = new DifferentialDrive(left, right);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void arcadeDrive(double x, double y) {
		drive.arcadeDrive(x, y, true); //forward, cw = positive; decrease sensitivity at low speed is TRUE
	}
}
