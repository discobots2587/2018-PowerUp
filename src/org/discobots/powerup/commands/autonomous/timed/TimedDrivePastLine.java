package org.discobots.powerup.commands.autonomous.timed;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedDrivePastLine extends CommandGroup{
	public TimedDrivePastLine() {
		addSequential(new AutonArcadeDrive(0.5,0,1000));
	}
}
