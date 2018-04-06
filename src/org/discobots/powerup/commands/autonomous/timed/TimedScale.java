package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedScale extends CommandGroup {
	public TimedScale(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new ArcadeTimedDrive(0.7,0.1,3700));
			//addSequential(new AutonArcadeDriveTimed(0,0.5,300));
			addSequential(new ArcadeTimedDrive(0,0,400));
			//addSequential(new AutonArcadeDriveTimed(0.7,0,1000));
			if(!Autonomous.scoreSide[1]) {
				addSequential(new ArcadeTimedDrive(0.5,-0.1, 2000));
			}
			//addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new ArcadeTimedDrive(0.7,0.1,3700));
			//addSequential(new AutonArcadeDriveTimed(0,0.5,300));
			addSequential(new ArcadeTimedDrive(0,0,400));
			if(Autonomous.scoreSide[1]) {
				addSequential(new ArcadeTimedDrive(0.5,-0.1, 2000));
			}
			//addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}

