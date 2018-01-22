package org.discobots.powerup.commands.autonomous.subcommands;

import edu.wpi.first.wpilibj.command.Command;
import org.discobots.powerup.Robot;


public class AutonArcadeDrive extends Command {
	
	private int time;
	private long endTime;
	private double speed, rotation;
	private boolean finished=false;
	public boolean end=false;
	
	//speed is forward speed, rotation is y rotation, time is in milliseconds
	public AutonArcadeDrive(double speed, double rotation, int time) {
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
		while(endTime >= System.currentTimeMillis())
    	{
			Robot.drive.arcadeDrive(speed,rotation);
    	}
    	finished=true;
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return finished;
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
