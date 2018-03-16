package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;

import edu.wpi.first.wpilibj.command.Command;

public class TimedChooser extends Command {
	
	Robot.position pos;
	boolean[] scoreSide;
	Command autonCommand;
	
	@Override
	protected void initialize() {
		pos = Dashboard.positionChooser.getSelected();
		scoreSide = Autonomous.scoreSide;
		
		switch(pos) {
		case LEFT:
			left();
			break;
		case CENTER:
			autonCommand = new Nothing();
			break;
		case RIGHT:
			right();
			break;
		default:
			autonCommand = new Nothing();
			break;
		}
		
		autonCommand.start();
	}
	
	protected void left() {
		if(scoreSide[0]) {
			autonCommand = new TimedSwitch(Robot.position.LEFT);
		} else if(scoreSide[1]) {
			autonCommand = new TimedScale(Robot.position.LEFT);
		} else {
			autonCommand = new AutonArcadeDriveTimed(0.7,0,2000);
		}
	}
	
	protected void right() {
		if(!scoreSide[0]) {
			autonCommand = new TimedSwitch(Robot.position.RIGHT);
		} else if(!scoreSide[1]) {
			autonCommand = new TimedScale(Robot.position.RIGHT);
		} else {
			autonCommand = new AutonArcadeDriveTimed(0.7,0,2000);
		}
	}
	
	protected void center() {
		autonCommand = new TimedSwitch(Robot.position.CENTER);
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
