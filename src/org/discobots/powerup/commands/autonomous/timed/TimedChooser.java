package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.lib.AutonChooser;

public class TimedChooser extends AutonChooser {
	
	@Override
	protected void left() {
		if(scoreSide[0]) {
			autonCommand = new TimedSwitch(Robot.position.LEFT);
		} else if(scoreSide[1]) {
			autonCommand = new TimedScale(Robot.position.LEFT);
		} else {
			autonCommand = new ArcadeTimedDrive(0.7,0,2000);
		}
	}
	
	@Override
	protected void right() {
		if(!scoreSide[0]) {
			autonCommand = new TimedSwitch(Robot.position.RIGHT);
		} else if(!scoreSide[1]) {
			autonCommand = new TimedScale(Robot.position.RIGHT);
		} else {
			autonCommand = new ArcadeTimedDrive(0.7,0,2000);
		}
	}
	
	@Override
	protected void center() {
		autonCommand = new TimedSwitch(Robot.position.CENTER);
	}
}
