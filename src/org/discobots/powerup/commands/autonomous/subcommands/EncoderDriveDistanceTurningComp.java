package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.AverageEncoderPIDSource;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.TurningEncoderPIDSource;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderDriveDistanceTurningComp extends Command {

	private Encoder left;
	private Encoder right;

	private double threshold;
	private double encoderSetpoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	
	private DummyPIDOutput distanceEncoderPIDOutput;
	private PIDController distanceEncoderPID;
	private DummyPIDOutput turningEncoderPIDOutput;
	private PIDController turningEncoderPID;
	private AverageEncoderPIDSource avgEncoderPIDSource;
	private TurningEncoderPIDSource turningEncoderPIDSource;
	
	public EncoderDriveDistanceTurningComp(double encoderSetpoint, double threshold) {
		this(encoderSetpoint, threshold, 1, 0, 0);
		
	}
	
	public EncoderDriveDistanceTurningComp(double encoderSetpoint, double threshold, double kP, double kI, double kD) {
		System.out.println("EncoderDriveDistanceTurningComp Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = threshold;
		
		distanceEncoderPIDOutput = new DummyPIDOutput();
		turningEncoderPIDOutput = new DummyPIDOutput();
		
		avgEncoderPIDSource = new AverageEncoderPIDSource(left, right);
		distanceEncoderPID = new PIDController(kP, kI, kD, avgEncoderPIDSource, distanceEncoderPIDOutput);
		distanceEncoderPID.setOutputRange(-0.3,0.3);
		
		turningEncoderPIDSource =  new TurningEncoderPIDSource(left, right);
		turningEncoderPID = new PIDController(kP, kI, kD, turningEncoderPIDSource, turningEncoderPIDOutput);
		turningEncoderPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		left.reset();
		right.reset();
		distanceEncoderPID.setSetpoint(encoderSetpoint);
		turningEncoderPID.setSetpoint(0.0);
		distanceEncoderPID.enable();
		turningEncoderPID.enable();
		
		distanceEncoderError = encoderSetpoint - (left.getDistance() + right.getDistance());
		turningEncoderError = Math.abs(0 - turningEncoderPIDOutput.getOutput());
	}
	
	@Override
	protected void execute() {
		if(!distanceEncoderPID.isEnabled()) {
			distanceEncoderPID.enable();
		}
	
		new AutonArcadeDriveTimed(turningEncoderPIDOutput.getOutput(), distanceEncoderPIDOutput.getOutput(), 10); //small amount of time
		distanceEncoderError = encoderSetpoint - (left.getDistance() + right.getDistance());
		turningEncoderError = Math.abs(0 - turningEncoderPIDOutput.getOutput());
		Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("PID output: " + distanceEncoderPIDOutput.getOutput(), "PID-OUTPUT");
		Debugger.getInstance().log( "Error: " + distanceEncoderError, "PID-ERROR");
		Debugger.getInstance().log("Setpoint: "  + encoderSetpoint, "PID-SETPOINT");
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (distanceEncoderError > threshold && turningEncoderError > threshold);
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
