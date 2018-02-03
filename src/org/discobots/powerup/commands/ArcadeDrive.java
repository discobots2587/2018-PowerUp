package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;


//ArcadeDrive - drives the robot via a split arcade drive
public class ArcadeDrive extends Command {
	
	public ArcadeDrive() {
		requires(Robot.drive);
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(Robot.oi.getLY(), Robot.oi.getRX());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.drive.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
