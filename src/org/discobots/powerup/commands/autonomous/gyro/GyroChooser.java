package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.lib.PowerUpAutonChooser;

public class GyroChooser extends PowerUpAutonChooser {

	@Override
	protected void left() {
		if(scalePriority) { //if scalePriority is true, we go for the scale ONLY
			autonCommand = new GyroScale(position.LEFT, scoreSide[1]);
		} else { //if not, we try for our switch, otherwise, go for the scale
			autonCommand = new GyroSwitch(position.LEFT, scoreSide[0]);
		}
	}

	@Override
	protected void right() {
		if(scalePriority) { //if scalePriority is true, we go for the scale ONLY
			autonCommand = new GyroScale(position.RIGHT, scoreSide[1]);
		} else { //if not, we try for our switch, otherwise, go for the scale
			autonCommand = new GyroSwitch(position.RIGHT, scoreSide[0]);
		}
	}

	@Override
	protected void center() {
		autonCommand = new GyroSwitch(position.CENTER, scoreSide[0]);
	}

}
