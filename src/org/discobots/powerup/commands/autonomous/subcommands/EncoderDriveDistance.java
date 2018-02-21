package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.AverageEncoderPIDSource;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveDistance extends Command {

	private Encoder left;
	private Encoder right;
	
	private double encoderSetpoint;
	private double threshold;
	private double encoderError;
	
	private DummyPIDOutput distanceEncoderPIDOutput;
	private PIDController distanceEncoderPID;
	private AverageEncoderPIDSource avgEncoderPIDSource;
	
	public EncoderDriveDistance(double encoderSetpoint, double threshold) {
		this(encoderSetpoint, threshold, 1.0, 0.0, 0.0);
		
	}
	
	public EncoderDriveDistance(double encoderSetpoint, double threshold, double kP, double kI, double kD) {
		System.out.println("EncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = threshold;
		
		distanceEncoderPIDOutput = new DummyPIDOutput();
		
		//avgEncoderPIDSource = new AverageEncoderPIDSource(left, right);
		distanceEncoderPID = new PIDController(kP, kI, kD, Robot.drive.m_right_encoder, distanceEncoderPIDOutput);
		distanceEncoderPID.setOutputRange(-0.3,0.3);
	}
	
	@Override
	protected void initialize() {
		left.reset();
		right.reset();
		distanceEncoderPID.setSetpoint(encoderSetpoint);
		distanceEncoderPID.enable();
		encoderError = encoderSetpoint - (left.getDistance() + right.getDistance());
	}
	
	@Override
	protected void execute() {
		if(!distanceEncoderPID.isEnabled()) {
			distanceEncoderPID.enable();
		}
		if(encoderError > threshold) {
			new AutonArcadeDriveTimed(0, distanceEncoderPIDOutput.getOutput(), 10); //small amount of time
			encoderError = encoderSetpoint - (left.getDistance() + right.getDistance());
			/*Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
			Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
			Debugger.getInstance().log("PID output: " + distanceEncoderPIDOutput.getOutput(), "PID-OUTPUT");
			Debugger.getInstance().log( "Error: " + encoderError, "PID-ERROR");
			Debugger.getInstance().log("Setpoint: "  + encoderSetpoint, "PID-SETPOINT");*/
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
		distanceEncoderPID.disable();
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
