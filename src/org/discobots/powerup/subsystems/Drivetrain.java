package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive;
	
	public Encoder m_left_encoder;
	public Encoder m_right_encoder;
	
	public Drivetrain() {
		Spark m_left = new Spark(HW.leftDrive);  //set all three left ports to what is configured in the HW
		SpeedControllerGroup left = new SpeedControllerGroup(m_left);

		Spark m_right = new Spark(HW.rightDrive);  //set all three right ports to what is configured in the HW
		SpeedControllerGroup right = new SpeedControllerGroup(m_right);
		
		drive = new DifferentialDrive(left, right);
		
		drive.setDeadband(Constants.kDeadband);
		
		m_left_encoder = new Encoder(HW.left_encoder1, HW.left_encoder2);
		m_right_encoder = new Encoder(HW.right_encoder1, HW.right_encoder2);
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
