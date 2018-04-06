package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.lib.AutonChooser;

public class GyroChooser extends AutonChooser {

	@Override
	protected void left() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void right() {
		// TODO Auto-generated method stub
	}

	@Override
	protected void center() {
		// TODO Auto-generated method stub
		if(scoreSide[0]) {
			autonCommand = new GyroMiddle();
		} else {
			autonCommand = new GyroMiddle();
		}
	}

}
