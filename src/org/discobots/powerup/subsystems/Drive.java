package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {

	public DifferentialDrive drive;
	
	public Drive() {
		Spark m_frontLeft = new Spark(1);
		Spark m_midLeft = new Spark(2);
		Spark m_rearLeft = new Spark(3);
		SpeedControllerGroup left = new SpeedControllerGroup(m_frontLeft, m_midLeft, m_rearLeft);

		Spark m_frontRight = new Spark(4);
		Spark m_midRight = new Spark(5);
		Spark m_rearRight = new Spark(6);
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
