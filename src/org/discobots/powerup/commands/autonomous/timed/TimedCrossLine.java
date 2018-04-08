package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;

//TODO - Dial in values
public class TimedCrossLine extends CommandGroup{
	
	public TimedCrossLine(position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeTimedDrive(0.5,0,4000));
				break;
			case LEFT:
				addSequential(new ArcadeTimedDrive(0.5,0,4000));
				break;
			case CENTER:
				addSequential(new Nothing());
				break;
		}
	}
}
