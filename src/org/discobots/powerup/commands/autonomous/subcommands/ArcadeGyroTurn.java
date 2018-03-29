package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.lib.PIDSourceTurningEncoder;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeGyroTurn extends Command{
	private Encoder left;
	private Encoder right;

	private double turningThreshold;
	private double turningSetPoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	

	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private PIDSourceGyro turningGyroPIDSource;

	private double kP;
	private double kI;
	private double kD;
	private double preError;

	double integral;
	
	public ArcadeGyroTurn(double turningSetPoint, double turningThreshold, double kP, double kI, double kD) {
		System.out.println("GyroEncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.turningSetPoint = turningSetPoint;
		this.turningThreshold = turningThreshold;
		
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.integral = 0;
		
		//turningGyroPIDOutput = new DummyPIDOutput();

		//turningGyroPIDSource =  new PIDSourceGyro();
		//turningGyroPID = new PIDController(tP, tI, tD, turningGyroPIDSource, turningGyroPIDOutput);
		//turningGyroPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		System.out.println("Init GyroEncoderDriveDistance");
		left.reset();
		right.reset();
		//turningGyroPID.setSetpoint(turningSetPoint);
		//turningGyroPID.enable();
		
		turningEncoderError = Math.abs(turningSetPoint - Robot.drive.getYaw());
	}
	
	@Override
	protected void execute() {
		this.integral = this.integral + (turningEncoderError * 0.004);
		   // determine the amount of change from the last time checked
	    double derivative = (turningEncoderError - preError) / 0.004; 
		   // calculate how much to drive the output in order to get to the 
		   // desired setpoint. 
		double output = (this.kP * turningEncoderError) + (this.kI * integral) + (this.kD * derivative);
		turningEncoderError = Math.abs(turningSetPoint - Robot.drive.getYaw());
		
		if(output > 0.5)
			output = 0.5;
		if(output < -0.5)
			output = -0.5;
		
		
		
		Robot.drive.arcadeDrive(0, output);
		System.out.println("GyroTurn PID output: " + output);
		System.out.println("GyroTurn Error: " + turningEncoderError);
		System.out.println("GyroTurn Setpoint: "  + turningSetPoint);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return 	(turningEncoderError < Math.abs(turningThreshold));
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
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