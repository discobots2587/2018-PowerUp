package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceTurningEncoder;
import org.discobots.powerup.utils.Debugger;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeEncoderDriveTurningComp extends Command {

	private Encoder left;
	private Encoder right;

	private double threshold;
	private double encoderSetpoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	
//	private DummyPIDOutput distanceEncoderPIDOutput;
//	private PIDController distanceEncoderPID;
//	private DummyPIDOutput turningEncoderPIDOutput;
//	private PIDController turningEncoderPID;
//	private AverageEncoderPIDSource avgEncoderPIDSource;
//	private TurningEncoderPIDSource turningEncoderPIDSource;
	
	private double kP;
	private double kI;
	private double kD;
	private double preError;
	
	double integral;
	
	/**
	 * P = 1, I = 0, D = 0
	 * 
	 * @param encoderSetpoint Distance setpoint in inches
	 * @param threshold Error threshold
	 */
	public ArcadeEncoderDriveTurningComp(double encoderSetpoint, double threshold) {
		this(encoderSetpoint, threshold, 1.0, 0.0, 0.0);
	}
	
	/**
	 * 
	 * @param encoderSetpoint Distance setpoint in inches
	 * @param threshold Error threshold
	 * @param kP Proportional value
	 * @param kI Integral value
	 * @param kD Derivative value
	 */
	public ArcadeEncoderDriveTurningComp(double encoderSetpoint, double threshold, double kP, double kI, double kD) {
		System.out.println("EncoderDriveDistanceTurningComp Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = threshold;
		
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.integral = 0;
		this.preError = 0;
		
//		distanceEncoderPIDOutput = new DummyPIDOutput();
//		turningEncoderPIDOutput = new DummyPIDOutput();
//		
//		avgEncoderPIDSource = new AverageEncoderPIDSource(left, right);
//		distanceEncoderPID = new PIDController(kP, kI, kD, avgEncoderPIDSource, distanceEncoderPIDOutput);
//		distanceEncoderPID.setOutputRange(-0.3,0.3);
//		
//		turningEncoderPIDSource =  new TurningEncoderPIDSource(left, right);
//		turningEncoderPID = new PIDController(kP, kI, kD, turningEncoderPIDSource, turningEncoderPIDOutput);
//		turningEncoderPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		left.reset();
		right.reset();
//		distanceEncoderPID.setSetpoint(encoderSetpoint);
//		turningEncoderPID.setSetpoint(0.0);
//		distanceEncoderPID.enable();
//		turningEncoderPID.enable();
		
		distanceEncoderError = Math.abs(encoderSetpoint) - Utils.encoderAvg(Math.abs(left.getDistance()), Math.abs(right.getDistance()));
		this.turningEncoderError = 0.0 - ( (Math.abs(right.getDistance()) - Math.abs(left.getDistance())) / 1.0);
	}
	
	@Override
	protected void execute() {
		this.integral = this.integral + (turningEncoderError * 0.004);
		   // determine the amount of change from the last time checked
	    double derivative = (turningEncoderError - preError) / 0.004; 
		   // calculate how much to drive the output in order to get to the 
		   // desired setpoint. 
		double output = (this.kP * turningEncoderError) + (this.kI * integral) + (this.kD * derivative);
		   // remember the error for the next time around.
		preError = turningEncoderError; 
		
		
		if(output > 0.2)
			output = 0.2;
		if(output < -0.2)
			output = -0.2;

		if(encoderSetpoint<0) {
			Robot.drive.arcadeDrive(-0.6, output);
		} else {
			Robot.drive.arcadeDrive(0.6, output);
		}
		
		
		distanceEncoderError = Math.abs(encoderSetpoint) - Utils.encoderAvg(Math.abs(left.getDistance()), Math.abs(right.getDistance()));
		this.turningEncoderError = 0.0 - ( (Math.abs(right.getDistance()) - Math.abs(left.getDistance())) / 1.0);
		Debugger.getInstance().log("Distance Remaining: "+distanceEncoderError,"PID-ERROR");
	//	Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
	//	Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
	//	Debugger.getInstance().log("PID turning output: " + output, "PID-OUTPUT");
	//	Debugger.getInstance().log("Error Turning: " + turningEncoderError, "PID-ERROR");
	//	Debugger.getInstance().log("Error Distance: " + distanceEncoderError, "PID-ERROR");
		Debugger.getInstance().log("Setpoint: "  + encoderSetpoint, "PID-SETPOINT");
		Timer.delay(0.004);
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (Math.abs(distanceEncoderError) < threshold);
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
//		distanceEncoderPID.disable();
//		turningEncoderPID.disable();
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
