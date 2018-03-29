package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLine extends CommandGroup {
	boolean[] scoreSide;
	
	public EncoderCrossLine() {
		Robot.pos = Dashboard.positionChooser.getSelected();
		this.scoreSide = Autonomous.scoreSide;
		switch(Robot.pos) {
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
	
	@Override
	public void initialize() {
		
	}
	
	public void right() {
		addSequential(new ArcadeEncoderDriveTurningComp(150.0, 5.0, 1.0, 0.1, 0.1));
	}
	
	public void center() {
		
	}
	
	public void left() {
		right();
	}
}
