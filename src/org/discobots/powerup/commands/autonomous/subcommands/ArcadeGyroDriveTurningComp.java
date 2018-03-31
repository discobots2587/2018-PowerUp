package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.PIDSourceGyro;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeGyroDriveTurningComp extends Command {
	private double encoderThreshold;
	private double encoderSetpoint;
	
	private double turningThreshold;
	
	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private PIDSourceGyro turningGyroPIDSource;
	
	private DummyPIDOutput encoderPIDOutput;
	private PIDController encoderPID;
	private PIDSourceAverageEncoder encoderPIDSource;
	
	private Encoder left,right;
	
	public ArcadeGyroDriveTurningComp(double encoderSetpoint)
	{
		this(encoderSetpoint, 1, 1, 0.01, 0.01, 0, 1, 0.01, 0.01);
	}
	
	public ArcadeGyroDriveTurningComp(double encoderSetpoint, double encoderThreshold, double kP, double kI, double kD)
	{
		this(encoderSetpoint, encoderThreshold, kP, kI, kD, 0, 1, 0.01, 0.01);
	}
	
	//you'll probably never need the full constructor
	public ArcadeGyroDriveTurningComp(double encoderSetpoint, double encoderThreshold, double kP, double kI, double kD, double turningThreshold, double tP, double tI, double tD)
	{
		turningGyroPIDOutput = new DummyPIDOutput();
		turningGyroPIDSource =  new PIDSourceGyro();
		turningGyroPID = new PIDController(tP, tI, tD, turningGyroPIDSource, turningGyroPIDOutput, 50.0);
		turningGyroPID.setOutputRange(-0.3, 0.3);
		
		encoderPIDOutput = new DummyPIDOutput();
		encoderPIDSource = new PIDSourceAverageEncoder(Robot.drive.m_left_encoder,Robot.drive.m_right_encoder);
		encoderPID = new PIDController(kP,kI,kD,encoderPIDSource,encoderPIDOutput,50.0);
		encoderPID.setOutputRange(-0.7, 0.7);
	}
	
	@Override
	protected void initialize() {
		
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	

}
