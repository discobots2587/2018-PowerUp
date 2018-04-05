package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArmSet extends Command {

	private double value;
	
	public ArmSet(double inputVal) {
		value = inputVal;
	}
	
	@Override
	public void initialize() {
		Robot.arm.set(value);
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
