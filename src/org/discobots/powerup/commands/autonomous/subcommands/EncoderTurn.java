package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.AverageEncoderPIDSource;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.TurningEncoderPIDSource;
import org.discobots.powerup.utils.Constants;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class EncoderTurn extends Command {

	private Encoder left;
	private Encoder right;

	private double threshold;
	private double turnSetpoint;
	
	private double distanceEncoderError;
	private double turningEncoderError;
	
	private DummyPIDOutput distanceEncoderPIDOutput;
	private PIDController distanceEncoderPID;
	private DummyPIDOutput turningEncoderPIDOutput;
	private PIDController turningEncoderPID;
	private AverageEncoderPIDSource avgEncoderPIDSource;
	private TurningEncoderPIDSource turningEncoderPIDSource;
	
	private boolean right_turn;
	
	private double kP;
	private double kI;
	private double kD;
	private double preError;
	
	double integral;
	
	public EncoderTurn(double turnSetpoint, double threshold, double kP, double kI, double kD, boolean right_turn) {
		System.out.println("EncoderDriveDistanceTurningComp Starting");
		left = Robot.drive.m_left_encoder;
		right = Robot.drive.m_right_encoder;
		
		//distanceEncoderPID = new PIDController(kP,kI,kD,avgEncoderPIDSource,distanceEncoderPIDOutput);
		
		
		this.turnSetpoint = turnSetpoint;
		this.threshold = threshold;
		this.right_turn = right_turn;
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.integral = 0;
		this.preError = 0;
		

	}
	
	@Override
	protected void initialize() {
		left.reset();
		right.reset();
		
		this.turningEncoderError = turnSetpoint - ( (right.getDistance() - left.getDistance()) / Constants.kEncoderTurningFactor);

	}
	
	@Override
	protected void execute() {
		/*if(!distanceEncoderPID.isEnabled()) {
			distanceEncoderPID.enable();
		}*/
		
		this.integral = this.integral + (turningEncoderError * 0.004);
		   // determine the amount of change from the last time checked
	    double derivative = (turningEncoderError - preError) / 0.004; 
		   // calculate how much to drive the output in order to get to the 
		   // desired setpoint. 
		double output = (this.kP * turningEncoderError) + (this.kI * integral) + (this.kD * derivative);
		   // remember the error for the next time around.
		preError = turningEncoderError; 
		
		
		if(right_turn)
			Robot.drive.arcadeDrive(0.0, -0.9);
		else
			Robot.drive.arcadeDrive(0.0, 0.9);
		this.turningEncoderError = turnSetpoint - ( (right.getDistance() - left.getDistance()) / Constants.kEncoderTurningFactor);
		Debugger.getInstance().log("Left: " + left.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("Right: " + right.getDistance(), "PID-ENCODER");
		Debugger.getInstance().log("PID output: " + output, "PID-OUTPUT");
		Debugger.getInstance().log("Error TURNING: " + turningEncoderError, "PID-ERROR");
		Debugger.getInstance().log("Setpoint: "  + turnSetpoint, "PID-SETPOINT");
		Timer.delay(0.004);
		
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return (turningEncoderError < 0.1);
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
		end();
	}

}
