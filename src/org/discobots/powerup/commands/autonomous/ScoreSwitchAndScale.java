package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ScoreSwitchAndScale extends CommandGroup {
	
	public ScoreSwitchAndScale(boolean timed) {
		requires(Robot.drive);
		requires(Robot.launcher);
	}
}
