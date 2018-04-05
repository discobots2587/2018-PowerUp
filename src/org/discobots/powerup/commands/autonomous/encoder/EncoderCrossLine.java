package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLine extends CommandGroup {
	
	public EncoderCrossLine() {
		Robot.position pos = Dashboard.positionChooser.getSelected(); 
		switch(pos) {
			case RIGHT:
				this.addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
				break;
			case LEFT:
				this.addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
				break;
			case CENTER:
				this.addSequential(new Nothing());
				break;
			default:
				break;
		}
	}
}
