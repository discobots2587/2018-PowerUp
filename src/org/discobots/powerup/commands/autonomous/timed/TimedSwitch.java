package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedSwitch extends CommandGroup {
	public TimedSwitch(Robot.position pos, boolean left) {
		switch(pos) {
			case RIGHT:
				if(!left) {
					addSequential(new ArcadeTimedDrive(0.7,0,1500));
					addSequential(new ArcadeTimedDrive(0,-0.5,500));
					addSequential(new ArcadeTimedDrive(0,0,400));
					addSequential(new ArcadeTimedDrive(0.7,0,1500));
					addSequential(new Launch(Launch.type.SWITCH));
				} else {
					addSequential(new TimedCrossLine(pos));
				}
				break;
			case LEFT:
				if(left) {
					addSequential(new ArcadeTimedDrive(0.7,0,1500));
					addSequential(new ArcadeTimedDrive(0,0.5,500));
					addSequential(new ArcadeTimedDrive(0,0,400));
					addSequential(new ArcadeTimedDrive(0.7,0,1500));
					addSequential(new Launch(Launch.type.SWITCH));
				} else {
					addSequential(new TimedCrossLine(pos));
				}
				break;
			case CENTER:
				if(left) {
					addSequential(new ArcadeTimedDrive(0.7, 0, 500));
					addSequential(new ArcadeTimedDrive(0, -0.5, 2500));
					addSequential(new ArcadeTimedDrive(0.7, 0, 3000));
					addSequential(new ArcadeTimedDrive(0, 0.5, 2500));
					addSequential(new ArcadeTimedDrive(0.7, 0, 1500));
					addSequential(new Launch(Launch.type.SWITCH));
				} else {
					addSequential(new ArcadeTimedDrive(0.7, 0, 500));
					addSequential(new ArcadeTimedDrive(0, 0.5, 2500));
					addSequential(new ArcadeTimedDrive(0.7, 0, 3000));
					addSequential(new ArcadeTimedDrive(0, -0.5, 2500));
					addSequential(new ArcadeTimedDrive(0.7, 0, 1500));
					addSequential(new Launch(Launch.type.SWITCH));
				}
				break;
		}
	}
}
