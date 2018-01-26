package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.command.Command;


//NOTE: some portions commented out to test Friday

public class LaunchSwitch extends Command {
	
	//time = when the system reaches this time, it will set the solenoid back to 0 (in milliseconds)
	//finished = will become true when the time is reached
	public long time;
	public boolean finished;
	
	public LaunchSwitch() {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.launcher.activateSwitch();
		time = System.currentTimeMillis() + Constants.kLaunchwait;
		//this.wait(Constants.kLaunchwait);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		while(System.currentTimeMillis() < time) {
		}
		finished = true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return finished;
		//return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.launcher.deactivate();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
