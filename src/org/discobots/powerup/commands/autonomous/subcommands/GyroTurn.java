package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.AverageEncoderPIDSource;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.GyroPIDSource;
import org.discobots.powerup.lib.TurningEncoderPIDSource;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command{
	private Encoder left;
	private Encoder right;

	private double turningThreshold;
	private double turningSetPoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	

	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private GyroPIDSource turningGyroPIDSource;

	
	public GyroTurn(double turningSetPoint, double turningThreshold, double tP, double tI, double tD) {
		System.out.println("GyroEncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.turningSetPoint = turningSetPoint;
		this.turningThreshold = turningThreshold;
		
		turningGyroPIDOutput = new DummyPIDOutput();

		turningGyroPIDSource =  new GyroPIDSource();
		turningGyroPID = new PIDController(tP, tI, tD, turningGyroPIDSource, turningGyroPIDOutput);
		turningGyroPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		System.out.println("Init GyroEncoderDriveDistance");
		left.reset();
		right.reset();
		turningGyroPID.setSetpoint(turningSetPoint);
		turningGyroPID.enable();
		
		turningEncoderError = Math.abs(turningSetPoint - turningGyroPIDOutput.getOutput());
	}
	
	@Override
	protected void execute() {
		if(!turningGyroPID.isEnabled()) {
			turningGyroPID.enable();
		}
		if(turningEncoderError > turningThreshold) {
			
			new AutonArcadeDriveTimed(turningGyroPIDOutput.getOutput(), 0.0, 10); //small amount of time
			turningEncoderError = Math.abs(turningSetPoint - turningGyroPIDOutput.getOutput());
			System.out.println("GyroTurn PID output: " + turningGyroPIDOutput.getOutput());
			System.out.println("GyroTurn Error: " + distanceEncoderError);
			System.out.println("GyroTurn Setpoint: "  + turningSetPoint);
		} else {
			isFinished();
		}
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
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