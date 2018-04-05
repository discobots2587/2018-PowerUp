package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.lib.AutonChooser;

public class EncoderChooser extends AutonChooser {
	
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
}
