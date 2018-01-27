package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


public class LaunchSwitch extends Command {
	
	//time = when the system reaches this time, it will set the solenoid back to 0 (in milliseconds)
	//finished = will become true when the time is reached
	public long time;
	
	public LaunchSwitch() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		//skip the whole command if the launcher is already activated (to avoid repeats)
		if(!(Robot.launcher.anyActivated() || Robot.launcher.checkOnCooldown())) {
			Robot.launcher.activateSwitch();
			Timer.delay(Constants.kLaunchwait);
			Robot.launcher.startCooldown(Constants.kSwitchCooldown);
		}
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
