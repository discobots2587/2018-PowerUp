package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;
import org.discobots.powerup.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class SwitchDrop extends Command {

	public SwitchDrop() {
	}
	
	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.arm.setPos(1);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		//nothing is in the execute loop, so the robot will effectively wait until the arm reaches its target
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		//checks if the arm is within its margin of error
		return (Math.abs(Robot.arm.getPos() - Robot.arm.target) < (0.01*Robot.arm.scaleFactor));
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		Robot.intake.set(-1);
		Timer.delay(0.5);
		Robot.intake.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
	}
}
