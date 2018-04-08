package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmMove extends Command {
	boolean up;
	
	/*
	 * Moves the arm's PID target up or down one position based off of Arm's PIDSubsystem
	 * @param up Whether the arm is moving up or not.
	 */
	public ArmMove(boolean up) {
		this.up = up;
	}
	
	@Override
	public void initialize() {
		if(this.up) {
			Robot.arm.up();
		} else {
			Robot.arm.down();
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
