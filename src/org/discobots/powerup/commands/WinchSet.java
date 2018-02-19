package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class WinchSet extends Command {
	double value;
	
	public WinchSet(double inputVal) {
		value = inputVal;
	}
	
	@Override
	public void initialize() {
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void execute() {
		Robot.winch.set(value);
	}
	
	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.winch.set(0);
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
