package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.lib.AutonChooser;

public class GyroChooser extends AutonChooser {

	@Override
	protected void left() {
		// TODO Auto-generated method stub
		if(scoreSide[1]) {
			autonCommand = new GyroScale(Robot.position.LEFT);
		} else if(!scoreSide[1]) {
			
		}
	}

	@Override
	protected void right() {
		// TODO Auto-generated method stub
		if(!scoreSide[1]) {
			autonCommand = new GyroScale(Robot.position.RIGHT);
		} else {
			autonCommand = new ArcadeGyroDriveTurningComp(140.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0);
		}
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
