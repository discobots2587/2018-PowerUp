package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedDrop extends CommandGroup {
	
	@Override
	protected void initialize() {
		Robot.intake.close();
		Timer.delay(0.25);
		Robot.arm.set(-0.8);
		Timer.delay(1);
		Robot.intake.set(-1);
		Timer.delay(0.5);
		Robot.intake.set(0);
	}
	
	@Override
	protected boolean isFinished() {
		//checks if the arm is within its margin of error
		return true;
	}
}
