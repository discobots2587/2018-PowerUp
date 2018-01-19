package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;


//ArcadeDrive - drives the robot via a split arcade drive
public class ArcadeDrive extends Command {
	public ArcadeDrive() {
		requires(Robot.Drive);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.Drive.arcadeDrive(Robot.oi.getLY(), Robot.oi.getRX());
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
