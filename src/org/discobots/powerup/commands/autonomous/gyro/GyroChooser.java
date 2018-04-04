package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.lib.AutonChooser;
import org.discobots.powerup.commands.autonomous.gyro.*;
import edu.wpi.first.wpilibj.command.Command;

public class GyroChooser extends AutonChooser {
	boolean[] scoreSide;
	Robot.position pos;
	Command autonCommand;
	
	
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
		if(Autonomous.gameData.charAt(1) == 'L')
			autonCommand = new GyroMiddle("L");
		else 
			autonCommand = new GyroMiddle("R");
	}

}
