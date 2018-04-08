package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TestGyroTurn extends PIDCommand {

	private double setpoint;
	private double oldYaw;
	
	public TestGyroTurn(double setpoint) {
		this(setpoint, 1.0, 0.0, 0.0);
	}
	
	public TestGyroTurn(double setpoint, double p, double i, double d) {
		this(setpoint, p, i, d, 0.05);
	}
	
	public TestGyroTurn(double setpoint, double p, double i, double d, double period) {
		super(p, i, d, period);
		this.setpoint = setpoint;
		this.oldYaw = Robot.drive.getYaw();
		setSetpoint(oldYaw+setpoint);
		getPIDController().setPercentTolerance(0.0);
		getPIDController().setOutputRange(-0.7, 0.7);
		getPIDController().enable();
	}

	@Override
	protected double returnPIDInput() {
		return Robot.drive.getYaw();
	}

	@Override
	protected void usePIDOutput(double output) {
		if(setpoint < 0) {
			output *= -1;
		}
		Robot.drive.arcadeDrive(0.0, output);
	}

	@Override
	protected boolean isFinished() {
		/*if(setpoint < 0) {
			return Robot.drive.getYaw() < oldYaw + setpoint;
		} else if (setpoint > 0) {
			return Robot.drive.getYaw() > oldYaw + setpoint;
		}
		return true;*/
		return getPIDController().onTarget();
	}
	
	@Override
	protected void end() {
		getPIDController().disable();
		Robot.drive.arcadeDrive(0.0, 0.0);
	}

}
