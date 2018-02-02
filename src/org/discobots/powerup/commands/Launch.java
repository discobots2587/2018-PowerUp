package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.Constants;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class Launch extends Command {
	
	//time = when the system reaches this time, it will set the solenoid back to 0 (in milliseconds)
	//finished = will become true when the time is reached
	public long time;
	
	public enum type {
		SCALE, SWITCH;
	}
	
	private type lt;
	
	public Launch(type lt) {
		// Use requires() here to declare subsystem dependencies
		requires(Robot.launcher);
		this.lt = lt;
		
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		
		//skip the whole command if the launcher is already activated (to avoid repeats)
		if(!(Robot.launcher.anyActivated() || Robot.launcher.checkOnCooldown())) {
			//start cooldown
			Robot.launcher.startCooldown(Constants.kLaunchCooldown);
			
			//chooses which one to launch
			switch(lt) {
				case SWITCH:
					Robot.launcher.activate();
					Timer.delay(Utils.millisToSeconds(Constants.kSwitchWait));
					break;
				case SCALE:
					Robot.launcher.activate();
					Timer.delay(Utils.millisToSeconds(Constants.kScaleWait));
					break;
				default:
					break;
			}
			Robot.launcher.deactivate();
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
		
		//fix the launcher in the event it is up and stuck there
		if(!(Robot.launcher.checkOnCooldown())) {
			Robot.launcher.deactivate();
		}
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
