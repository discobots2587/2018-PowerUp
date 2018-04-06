package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TestGyroTurn extends PIDCommand {

	public TestGyroTurn(double setpoint, double p, double i, double d) {
		this(setpoint, p, i, d, 0.05);
	}
	
	public TestGyroTurn(double setpoint, double p, double i, double d, double period) {
		super(p, i, d, period);
		setSetpoint(setpoint);
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return Robot.drive.getYaw();
	}

	@Override
	protected void usePIDOutput(double output) {
		Robot.drive.arcadeDrive(0.0, output);
	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}

}
