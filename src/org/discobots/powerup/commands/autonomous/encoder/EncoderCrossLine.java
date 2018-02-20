package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.AutonTankDriveEncoder;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLine extends CommandGroup {
	boolean[] scoreSide;
	
	public EncoderCrossLine() {
		this.scoreSide = Autonomous.scoreSide;
//		switch(Robot.pos) {
//		case RIGHT:
//			right();
//			break;
//		case LEFT:
//			left();
//			break;
//		case CENTER:
//			center();
//			break;
//		default:
//			break;
//		}
		right();
	}
	
	public void right() {
		addSequential(new EncoderDriveDistance(150.0, 5.0, 1.0, 0.0, 0.0));
	}
	
	public void center() {
		
	}
	
	public void left() {
		right();
	}
}
