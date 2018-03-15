package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.AutonTankDriveEncoder;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLine extends CommandGroup {
	boolean[] scoreSide;
	
	public EncoderCrossLine(Robot.position pos) {
		this.scoreSide = Autonomous.scoreSide;
		switch(pos) {
		case RIGHT:
			right();
			break;
		case LEFT:
			left();
			break;
		case CENTER:
			center();
			break;
		default:
			break;
		}
	}
	
	public void right() {
		addSequential(new EncoderDriveDistance(150.0, 5.0, 1.0, 0.1, 0.1));
	}
	
	public void center() {
		
	}
	
	public void left() {
		right();
	}
}
