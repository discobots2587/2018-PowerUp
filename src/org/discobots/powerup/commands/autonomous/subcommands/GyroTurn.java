package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command {
	private Encoder left;
	private Encoder right;

	private double turningThreshold;
	private double turningSetPoint;
	
	private double turningEncoderError;
	
	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private PIDSourceGyro turningGyroPIDSource;

	public GyroTurn(double turningSetPoint, double turningThreshold, double tP, double tI, double tD) {
		System.out.println("GyroEncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.turningSetPoint = Robot.drive.getYaw() + turningSetPoint;
		this.turningThreshold = turningThreshold;
		
		turningGyroPIDOutput = new DummyPIDOutput();

		turningGyroPIDSource =  new PIDSourceGyro();
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
		
		turningEncoderError = Math.abs(turningSetPoint - Robot.drive.getYaw());
	}
	
	@Override
	protected void execute() {
		//Robot.drive.arcadeDrive(0, turningGyroPIDOutput.getOutput());
		Robot.drive.arcadeDrive(0, 0.6);
		turningEncoderError = Math.abs(turningSetPoint - Robot.drive.getYaw());
		
		//System.out.println("GyroTurn PID output: " + turningGyroPIDOutput.getOutput());

		Debugger.getInstance().log("GyroTurn Error" + turningEncoderError);
		Debugger.getInstance().log("GyroTurn Error Threshold" + turningThreshold);
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return 	(turningEncoderError <  turningThreshold);
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
