package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmPIDReset extends Command {
	@Override
	protected void initialize() {
		Robot.arm.teleopInit();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
