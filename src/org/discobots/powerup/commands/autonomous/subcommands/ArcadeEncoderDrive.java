package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.utils.Debugger;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeEncoderDrive extends Command {

	private Encoder left;
	private Encoder right;
	
	private double encoderSetpoint;
	private double threshold;
	private double encoderError;
	
	private DummyPIDOutput distanceEncoderPIDOutput;
	private PIDController distanceEncoderPID;
	private PIDSourceAverageEncoder avgEncoderPIDSource;
	
	public ArcadeEncoderDrive(double encoderSetpoint, double threshold) {
		this(encoderSetpoint, threshold, 1.0, 0.0, 0.0);
		
	}
	
	public ArcadeEncoderDrive(double encoderSetpoint, double threshold, double kP, double kI, double kD) {
		System.out.println("EncoderDriveDistance Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = threshold;
		
		distanceEncoderPIDOutput = new DummyPIDOutput();
		
		avgEncoderPIDSource = new PIDSourceAverageEncoder(left, right);
		distanceEncoderPID = new PIDController(kP, kI, kD, Robot.drive.m_right_encoder, distanceEncoderPIDOutput);
		distanceEncoderPID.setOutputRange(-0.3,0.3);
	}
	
	@Override
	protected void initialize() {
		left.reset();
		right.reset();
		distanceEncoderPID.setSetpoint(encoderSetpoint);
		distanceEncoderPID.enable();
		encoderError = encoderSetpoint - Utils.encoderAvg(left.getDistance(), right.getDistance());
	}
	
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(0.7, 0);
		encoderError = encoderSetpoint - Utils.encoderAvg(left.getDistance(), right.getDistance());
		/*Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("PID output: " + distanceEncoderPIDOutput.getOutput(), "PID-OUTPUT");
		Debugger.getInstance().log( "Error Encoder Drive Distance: " + encoderError, "PID-ERROR");
		Debugger.getInstance().log("Setpoint: "  + encoderSetpoint, "PID-SETPOINT");*/
	
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (encoderError < threshold);
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