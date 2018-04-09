package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.lib.PowerUpAutonChooser;

public class EncoderChooser extends PowerUpAutonChooser {
	
	@Override
	protected void left() {
		if(scalePriority) { //if scalePriority is true, we go for our scale, otherwise, we go for our switch
			autonCommand = new EncoderScale(position.LEFT, scoreSide[1]);
		} else { //if not, we try for our switch, otherwise, cross the line
			autonCommand = new EncoderSwitch(position.LEFT, scoreSide[0]);
		}
	}

	@Override
	protected void right() {
		if(scalePriority) { //if scalePriority is true, we go for our scale, otherwise, we go for our switch
			autonCommand = new EncoderScale(position.RIGHT, scoreSide[1]);
		} else { //if not, we try for our switch, otherwise, cross the line
			autonCommand = new EncoderSwitch(position.RIGHT, scoreSide[0]);
		}
	}

	@Override
	protected void center() {
		autonCommand = new EncoderSwitch(position.CENTER, scoreSide[0]);
	}
}
