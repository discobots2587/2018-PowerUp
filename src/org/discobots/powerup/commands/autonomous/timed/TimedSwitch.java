package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedSwitch extends CommandGroup {
	public TimedSwitch(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeTimedDrive(0.7,0,2000));
				addSequential(new ArcadeTimedDrive(0,-0.5,300));
				addSequential(new ArcadeTimedDrive(0,0,400));
				addSequential(new ArcadeTimedDrive(0.7,0,1500));
				addSequential(new Launch(Launch.type.SWITCH));
				break;
			case LEFT:
				addSequential(new ArcadeTimedDrive(0.7,0,2000));
				addSequential(new ArcadeTimedDrive(0,0.5,300));
				addSequential(new ArcadeTimedDrive(0,0,400));
				addSequential(new ArcadeTimedDrive(0.7,0,1500));
				addSequential(new Launch(Launch.type.SWITCH));
				break;
			case CENTER:
//				addSequential(new ArcadeTimedDrive(0.7, 0, 500));
//				if(Autonomous.scoreSide[0]) {
//					addSequential(new ArcadeTimedDrive(0, -0.5, 2100));
//				} else {
//					addSequential(new ArcadeTimedDrive(0, 0.5, 2100));
//				}
//				addSequential(new ArcadeTimedDrive(0.7, 0, 2300));
//				if(Autonomous.scoreSide[0]) {
//					addSequential(new ArcadeTimedDrive(0, 0.5, 2100));
//				} else {
//					addSequential(new ArcadeTimedDrive(0, -0.5, 2100));
//				}
//				addSequential(new ArcadeTimedDrive(0.7, 0, 1500));
//				addSequential(new Launch(Launch.type.SWITCH));

				addSequential(new ArcadeTimedDrive(-0.7, 0, 1500));
				addSequential(new SwitchDrop());
				break;			
			default:
				addSequential(new Nothing());
				break;
		}
	}
}
