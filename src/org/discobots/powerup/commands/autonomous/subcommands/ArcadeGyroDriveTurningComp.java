package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceAverageEncoder;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.utils.Debugger;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeGyroDriveTurningComp extends Command {
	private double encoderThreshold;
	private double encoderSetpoint;
	private double turningThreshold;
	private double threshold;
	private Encoder left,right;
	
	
	private double kP;
	private double kI;
	private double kD;
	private double preError;
	
	double integral;
	
	private double tP;
	private double tI;
	private double tD;
	private double turningPreError;
	
	double turningIntegral;
	
	private double turningGyroError;
	private double distanceEncoderError;
	private double turningGyroSetpoint;
	
	/**
	 * 
	 * @param encoderSetpoint Distance setpoint in inches
	 * @param encoderThreshold Distance error threshold
	 * @param kP Distance proportional value
	 * @param kI Distance integral value
	 * @param kD Distance derivative value
	 * @param tP Turning proportional value
	 * @param tI Turning integral value
	 * @param tD Turning derivative value
	 */
	public ArcadeGyroDriveTurningComp(double encoderSetpoint, double encoderThreshold, double kP, double kI, double kD, double tP, double tI, double tD)
	{
		this.left = Robot.drive.m_left_encoder;
		this.right = Robot.drive.m_right_encoder;
		
		this.encoderSetpoint = encoderSetpoint;
		this.threshold = encoderThreshold;
		this.turningGyroSetpoint = Robot.drive.getYaw();
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.tP = tP;
		this.tI = tI;
		this.tD = tD;
		this.integral = 0;
		this.preError = 0;
	}
	
	@Override
	protected void initialize() {
		this.left.reset();
		this.right.reset();
		//distanceEncoderError = Math.abs(encoderSetpoint) - Utils.encoderAvg(Math.abs(left.getDistance()), Math.abs(right.getDistance()));
		distanceEncoderError = Math.abs(encoderSetpoint) - Math.abs(right.getDistance());

		turningGyroError = 0.0;

	}
	
	@Override
	protected void execute() {
		
		distanceEncoderError = Math.abs(encoderSetpoint) - Math.abs(right.getDistance());
		turningGyroError = Math.abs(turningGyroSetpoint - Robot.drive.getYaw());
	
		this.turningIntegral = this.turningIntegral + (turningGyroError * 0.004);
		   // determine the amount of change from the last time checked
	    double turningDerivative = (turningGyroError - turningPreError) / 0.004; 
		   // calculate how much to drive the output in order to get to the 
		   // desired setpoint. 
		double turningOutput = (this.tP * turningGyroError) + (this.tI * turningIntegral) + (this.tD * turningDerivative);
		   // remember the error for the next time around.
		turningPreError = turningGyroError; 
		
		this.integral = this.integral + (distanceEncoderError * 0.004);
		   // determine the amount of change from the last time checked
	    double derivate = (distanceEncoderError - preError) / 0.004; 
		   // calculate how much to drive the output in order to get to the 
		   // desired setpoint. 
		double output = (this.kP * distanceEncoderError) + (this.kI * integral) + (this.kD * derivate);
		   // remember the error for the next time around.
		turningPreError = distanceEncoderError; 
		
		
		if(turningOutput > 0.2)
			turningOutput = 0.2;
		if(turningOutput < -0.2)
			turningOutput = -0.2;
		
		if(output > 0.7)
			output = 0.7;
		if(output < -0.7)
			output = -0.7;

		if(encoderSetpoint<0) {
			Robot.drive.arcadeDrive(output*-1, turningOutput);
			Debugger.getInstance().log("encoderSetpoint<0: "+ " true","PID-ERROR");

		} else {
			Robot.drive.arcadeDrive(output, turningOutput);
		}
		
		
		Debugger.getInstance().log("Distance Remaining: "+distanceEncoderError,"PID-ERROR");
		Debugger.getInstance().log("Encoder PID output: "+output,"PID-OUTPUT");
		Debugger.getInstance().log("Heading Error: " + turningGyroError,"PID-ERROR");
		Debugger.getInstance().log("Turning output: " + turningOutput,"PID-OUTPUT");
	//	Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
	//	Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
	//	Debugger.getInstance().log("PID turning output: " + output, "PID-OUTPUT");
	//	Debugger.getInstance().log("Error Turning: " + turningEncoderError, "PID-ERROR");
	//	Debugger.getInstance().log("Error Distance: " + distanceEncoderError, "PID-ERROR");
		Timer.delay(0.004);
	}
	@Override
	protected boolean isFinished() {
		return distanceEncoderError < threshold;
	}
	

}
