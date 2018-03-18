package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderChooser extends Command {
	boolean[] scoreSide;
	Robot.position pos;
	Command autonCommand;
	
	public EncoderChooser() {	
	}
	
	@Override
	public void initialize() {
		pos = Dashboard.positionChooser.getSelected();
		scoreSide = Autonomous.scoreSide;
		
		switch(pos) {
		case LEFT:
			left();
			break;
		case CENTER:
			center();
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
	
	public void right() {
		//check if the right switch is ours
		if(!scoreSide[1]){ //check the scale
			autonCommand = new EncoderScale(Robot.position.RIGHT);
		} else { //if neither, aim for the switch
			autonCommand = new ArcadeEncoderDriveTurningComp(180,0);
		}
	}
	
	public void center() {
		autonCommand = new EncoderSwitch(Robot.position.CENTER);
	}
	
	public void left() {
		//check if the right switch is ours
		if(scoreSide[1]){ //check the scale
			autonCommand = new EncoderScale(Robot.position.LEFT);
		} else { //if neither, aim for the switch
			autonCommand = new ArcadeEncoderDriveTurningComp(180,0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
