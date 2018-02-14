package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

public class GearShift extends Command {
	
	public Drivetrain.shift s;
	
	public GearShift(Drivetrain.shift input) {
		s = input;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.drive.shift(s);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
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
		end();
	}
}
