package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedSwitch extends CommandGroup {
	public TimedSwitch(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new ArcadeTimedDrive(0.7,0,2000));
			addSequential(new ArcadeTimedDrive(0,-0.5,300));
			addSequential(new ArcadeTimedDrive(0,0,400));
			addSequential(new ArcadeTimedDrive(0.7,0,1000));
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new ArcadeTimedDrive(0.7,0,2000));
			addSequential(new ArcadeTimedDrive(0,0.5,300));
			addSequential(new ArcadeTimedDrive(0,0,400));
			addSequential(new ArcadeTimedDrive(0.7,0,1000));
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new ArcadeTimedDrive(0.7, 0, 700));
			if(Autonomous.scoreSide[0]) {
				addSequential(new ArcadeTimedDrive(0, -0.5, 800));
			} else {
				addSequential(new ArcadeTimedDrive(0, 0.5, 800));
			}
			addSequential(new ArcadeTimedDrive(0.7, 0, 1300));
			addSequential(new ArcadeTimedDrive(0,0,400));
			if(Autonomous.scoreSide[0]) {
				addSequential(new ArcadeTimedDrive(0, 0.5, 800));
			} else {
				addSequential(new ArcadeTimedDrive(0, -0.5, 800));
			}
			addSequential(new ArcadeTimedDrive(0.7, 0, 1500));
			//addSequential(new Launch(Launch.type.SWITCH));
		}
	}
}
