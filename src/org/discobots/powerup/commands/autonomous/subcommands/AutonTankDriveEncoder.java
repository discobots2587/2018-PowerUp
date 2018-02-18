package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutonTankDriveEncoder extends Command {
	//time = drive duration in milliseconds
	//endTime = when the system reaches this time, it will stop driving
	//finished = will become true when the time is reached
	private double leftDistance,rightDistance;
	private double leftDistanceEnd,rightDistanceEnd;
	private double speed;
	
	//speed is forward speed, rotation is y rotation, distance is in ticks(?)
	public AutonTankDriveEncoder(double speed, double leftDistance, double rightDistance) {
		requires(Robot.drive);
		this.speed = speed;
		this.leftDistance = leftDistance;
		this.rightDistance = rightDistance;
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		leftDistanceEnd = Robot.drive.m_left_encoder.getDistance()+leftDistance;
		rightDistanceEnd = Robot.drive.m_right_encoder.getDistance()+rightDistance;
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
		Robot.drive.arcadeDrive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
