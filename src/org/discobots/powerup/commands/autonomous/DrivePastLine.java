package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrivePastLine extends CommandGroup {
	
	public DrivePastLine(boolean timed) {
		requires(Robot.drive);
	}
}
