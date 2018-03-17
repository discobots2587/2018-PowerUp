package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.AutonTankDriveEncoder;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

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
			autonCommand = new EncoderDriveDistanceTurningComp(180,0);
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
			autonCommand = new EncoderDriveDistanceTurningComp(180,0);
		}
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
}
