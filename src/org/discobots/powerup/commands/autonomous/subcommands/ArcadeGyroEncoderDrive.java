package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.lib.PIDSourceTurningEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeGyroEncoderDrive extends Command{
	private Encoder left;
	private Encoder right;

	private double threshold;
	private double turningThreshold;
	private double encoderSetpoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	
	private DummyPIDOutput distanceEncoderPIDOutput;
	private PIDController distanceEncoderPID;
	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private PIDSourceAverageEncoder avgEncoderPIDSource;
	private PIDSourceGyro turningGyroPIDSource;

	
	public ArcadeGyroEncoderDrive(double encoderSetpoint, double threshold, double kP, double kI, double kD, double turningThreshold, double tP, double tI, double tD) {
		System.out.println("GyroEncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = threshold;
		this.turningThreshold = turningThreshold;
		
		distanceEncoderPIDOutput = new DummyPIDOutput();
		turningGyroPIDOutput = new DummyPIDOutput();
		
		avgEncoderPIDSource = new PIDSourceAverageEncoder(left, right);
		distanceEncoderPID = new PIDController(kP, kI, kD, avgEncoderPIDSource, distanceEncoderPIDOutput);
		distanceEncoderPID.setOutputRange(-0.3,0.3);
		
		turningGyroPIDSource =  new PIDSourceGyro();
		turningGyroPID = new PIDController(tP, tI, tD, turningGyroPIDSource, turningGyroPIDOutput);
		turningGyroPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		System.out.println("Init GyroEncoderDriveDistance");
		left.reset();
		right.reset();
		turningGyroPID.setSetpoint(0.0);
		distanceEncoderPID.setSetpoint(encoderSetpoint);
		distanceEncoderPID.enable();
		turningGyroPID.enable();
		
		distanceEncoderError = encoderSetpoint - (left.getDistance() + right.getDistance())/2;
		turningEncoderError = Math.abs(0 - turningGyroPIDOutput.getOutput());
	}
	
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(distanceEncoderPIDOutput.getOutput(), turningGyroPIDOutput.getOutput());
		distanceEncoderError = encoderSetpoint - (left.getDistance() + right.getDistance());
		turningEncoderError = Math.abs(0 - turningGyroPIDOutput.getOutput());
		System.out.println("Left: " + left.getDistance());
		System.out.println("Right: " + right.getDistance());
		System.out.println("PID output: " + distanceEncoderPIDOutput.getOutput());
		System.out.println("Error: " + distanceEncoderError);
		System.out.println("Setpoint: "  + encoderSetpoint);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (distanceEncoderError > threshold && turningEncoderError > turningThreshold);
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		distanceEncoderPID.disable();
		turningGyroPID.disable();
		Robot.drive.arcadeDrive(0, 0);
	}
		
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		System.out.println("Interrupted");
		end();
	}

}