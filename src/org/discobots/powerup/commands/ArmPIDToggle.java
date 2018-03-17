package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmPIDToggle extends Command {

	@Override
	protected void initialize() {
		if(Robot.arm.getPIDController().isEnabled())
			Robot.arm.getPIDController().disable();
		else
			Robot.arm.getPIDController().enable();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}

}
