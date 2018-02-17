package org.discobots.powerup.commands.autonomous.subcommands;

import edu.wpi.first.wpilibj.command.Command;
import org.discobots.powerup.Robot;


public class AutonArcadeDriveTimed extends Command {
	
	//time = drive duration in milliseconds
	//endTime = when the system reaches this time, it will stop driving
	//finished = will become true when the time is reached
	private int time;
	private long endTime;
	private double speed, rotation;
	
	//speed is forward speed, rotation is y rotation, time is in milliseconds
	public AutonArcadeDriveTimed(double speed, double rotation, int time) {
		requires(Robot.drive);
		this.speed = speed;
		this.rotation = rotation;
		this.time = time;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		endTime =  System.currentTimeMillis() + time;
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		while(endTime >= System.currentTimeMillis()) {
			Robot.drive.arcadeDrive(speed,rotation);
    	}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
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
