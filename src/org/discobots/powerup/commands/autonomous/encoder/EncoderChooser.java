package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.gyro.GyroSwitch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.lib.AutonChooser;

public class EncoderChooser extends AutonChooser {
	
	public void right() {
		//check if the right switch is ours
		if(!scoreSide[1]){ //check the scale
			autonCommand = new EncoderScale(Robot.position.RIGHT);
		} else if(!scoreSide[0]) { //if neither, aim for the switch
			autonCommand = new GyroSwitch(Robot.position.RIGHT);
		} else {
			autonCommand = new EncoderCrossLine();
		}
//		if(!scoreSide[0]) {
//			autonCommand = new EncoderSwitch(Robot.position.RIGHT);
//		} else if (!scoreSide[1]) {
//			autonCommand = new EncoderScale(Robot.position.RIGHT);
//		} else {
//			autonCommand = new Nothing();
//		}
	}
	
	public void center() {
		autonCommand = new EncoderSwitch(Robot.position.CENTER);
	}
	
	public void left() {
		//check if the right switch is ours
		if(scoreSide[1]){ //check the scale
			autonCommand = new EncoderScale(Robot.position.LEFT);
		} else if(scoreSide[0]){ //if neither, aim for the switch
			autonCommand = new GyroSwitch(Robot.position.LEFT);
		} else {
			autonCommand = new EncoderCrossLine();
		}
//		if(scoreSide[0]) {
//			autonCommand = new EncoderSwitch(Robot.position.LEFT);
//		} else if (scoreSide[1]) {
//			autonCommand = new EncoderScale(Robot.position.LEFT);
//		} else {
//			autonCommand = new Nothing();
//		}
	}
}
