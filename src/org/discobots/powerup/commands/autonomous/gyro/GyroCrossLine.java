package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroCrossLine extends CommandGroup {
	
	public GyroCrossLine() {
		addSequential(new ArcadeGyroDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1, 1.0, 0.0, 0.0));
	}
	
	public GyroCrossLine(position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeGyroDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1, 1.0, 0.0, 0.0));
				break;
			case LEFT:
				addSequential(new ArcadeGyroDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1, 1.0, 0.0, 0.0));
				break;
			case CENTER:
				addSequential(new Nothing());
				break;
		}
	}
}
