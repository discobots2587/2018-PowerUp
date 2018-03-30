package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;

public class ArcadeGyroTurn extends Command {

	private double turningThreshold;
	private double turningSetpoint;

	private DummyPIDOutput turningGyroPIDOutput;
	private PIDController turningGyroPID;
	private PIDSourceGyro turningGyroPIDSource;
	
	public ArcadeGyroTurn(double turningSetpoint, double turningThreshold, double kP, double kI, double kD) {
		this(turningSetpoint, turningThreshold, kP, kI, kD, 50.0);
	}
	
	public ArcadeGyroTurn(double turningSetpoint, double turningThreshold, double kP, double kI, double kD, double period) {
		this.turningSetpoint = turningSetpoint;
		turningGyroPIDOutput = new DummyPIDOutput();
		turningGyroPIDSource =  new PIDSourceGyro();
		turningGyroPID = new PIDController(kP, kI, kD, turningGyroPIDSource, turningGyroPIDOutput, period);
		turningGyroPID.setOutputRange(-0.3, 0.3);
	}
	
	@Override
	protected void initialize() {
		turningGyroPID.setSetpoint(turningSetpoint);
		turningGyroPID.enable();
	}
	
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(0, turningGyroPID.get());
		
		Debugger.getInstance().log("PID output: " + turningGyroPID.get(), "PID-OUTPUT");
		Debugger.getInstance().log("Error TURNING: " + turningGyroPID.getError(), "PID-ERROR");
		Debugger.getInstance().log("Setpoint: "  + turningSetpoint, "PID-SETPOINT");
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return 	(turningGyroPID.getError() < Math.abs(turningThreshold));
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
		end();
	}

}