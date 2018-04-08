package org.discobots.powerup.commands.autonomous.subcommands;
import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.PIDSourceGyro;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Command;

public class NewGyroTurn extends Command {
	
	PIDController turnPID;
	PIDOutput turnOutput = this::turnPIDOutput;
	PIDSourceGyro turnInput = new PIDSourceGyro();
	
	double turningSetpoint;
	double turningOutput;

	public NewGyroTurn(double turningSetpoint) {
		this(turningSetpoint,true,1,0,0);
	}
	
	public NewGyroTurn(double turningSetpoint, boolean relative) {
		this(turningSetpoint,relative,1,0,0);
	}
	
	public NewGyroTurn(double turningSetpoint, boolean relative, double kP, double kI, double kD) {
		if(relative) {
			this.turningSetpoint = Robot.drive.getYaw()+turningSetpoint;
		} else {
			this.turningSetpoint = turningSetpoint;
		}
		
		turnPID = new PIDController(kP,kI,kD,turnInput,turnOutput);
		turnPID.setAbsoluteTolerance(1);
		turnPID.setOutputRange(-0.3, 0.3);
		turnPID.setSetpoint(turningSetpoint);
	}
	
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(0, turningOutput);
	}
	
	@Override
	protected boolean isFinished() {
		return turnPID.onTarget();
	}
	
	@Override
	protected void end() {
		Robot.drive.arcadeDrive(0, 0);
	}
	
	private void turnPIDOutput(double output) {
		turningOutput = output;
	}
}
