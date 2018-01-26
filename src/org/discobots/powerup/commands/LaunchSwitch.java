package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LaunchSwitch extends Command {
	
	public boolean state;
	long timeStart,timeEnd;
	
	public LaunchSwitch() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.launcher.activateSwitch();
		timeStart = System.currentTimeMillis();
		timeEnd = timeStart + 500;
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
	}
}
