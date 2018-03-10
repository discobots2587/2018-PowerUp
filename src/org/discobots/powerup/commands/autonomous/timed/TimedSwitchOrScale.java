package org.discobots.powerup.commands.autonomous.timed;
import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedSwitchOrScale extends CommandGroup {
	public TimedSwitchOrScale() {
		switch(Robot.pos) {
		case LEFT:
			left();
			break;
		case RIGHT:
			right();
			break;
		case CENTER:
			break;
		default:
			break;
		}
	}
	
	public void left() {
		//check if the switch is on the left
		if(Autonomous.scoreSide[0])
			(new TimedSwitch(Robot.pos)).start();
		else if(Autonomous.scoreSide[1]) //check if the scale is on the left
			(new TimedCrossLineShoot(Autonomous.gameData,Robot.pos)).start();
	}
	
	public void right() {
		//check if the switch is on the right
		if(!Autonomous.scoreSide[0])
			(new TimedSwitch(Robot.pos)).start();
		else if(!Autonomous.scoreSide[1]) //check if the scale is on the right
			(new TimedCrossLineShoot(Autonomous.gameData,Robot.pos)).start();
	}
}
