package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLine extends CommandGroup {
	
	public EncoderCrossLine() {
		addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
	}
	
	public EncoderCrossLine(position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
				break;
			case LEFT:
				addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
				break;
			case CENTER:
				addSequential(new Nothing());
				break;
			default:
				break;
		}
	}
}
