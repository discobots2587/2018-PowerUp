package org.discobots.powerup.lib;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class PIDDrive extends DifferentialDrive {
	
	private double p;
	private double i;
	private double d;
	private PIDController drivePID;
	private Encoder left_encoder;
	private Encoder right_encoder;

	public PIDDrive(SpeedController leftMotor, SpeedController rightMotor, double inputP, double inputI, double inputD) {
		super(leftMotor, rightMotor);
		p = inputP;
		i = inputI;
		d = inputD;
		//drivePID = new PIDController(p,i,d);
		left_encoder = Robot.drive.m_left_encoder;
		right_encoder = Robot.drive.m_right_encoder;
	}

	
}
