package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.command.PIDCommand;

public class TestEncoderDrive extends PIDCommand {

	private double setpoint;
	
	public TestEncoderDrive(double setpoint) {
		this(setpoint, 1.0, 0.0, 0.0);
	}
	
	public TestEncoderDrive(double setpoint, double p, double i, double d) {
		this(setpoint, p, i, d, 0.05);
	}
	
	public TestEncoderDrive(double setpoint, double p, double i, double d, double period) {
		super(p, i, d, period);
		this.setpoint = setpoint;
		setSetpoint(setpoint);
		Robot.drive.resetBothEncoders();
	}

	@Override
	protected double returnPIDInput() {
		return Utils.encoderAvg(Robot.drive.getLeftDistance(), Robot.drive.getRightDistance());
	}

	@Override
	protected void usePIDOutput(double output) {
		if(setpoint > 0) {
			Robot.drive.arcadeDrive(0.7, output);
		} else {
			Robot.drive.arcadeDrive(-0.7, output);
		}
	}

	@Override
	protected boolean isFinished() {
		return getPIDController().onTarget();
	}

	@Override
	protected void end() {
		getPIDController().disable();
		Robot.drive.arcadeDrive(0.0, 0.0);
	}
}
