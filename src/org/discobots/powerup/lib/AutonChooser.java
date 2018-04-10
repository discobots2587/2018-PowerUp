package org.discobots.powerup.lib;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AutonChooser extends Command {

	protected Command autonCommand;
	
	@Override
	protected void initialize() {
		gameSpecificInit();
		
		switch(getPosition()) {
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
				Debugger.getInstance().log("Robot position was not selected!", "Auton");
				autonCommand = new Nothing();
				break;
		}
		
		autonCommand.start();
	}
	
	@Override
	protected boolean isFinished() {
		return true;
	}
	
	protected abstract void gameSpecificInit();
	protected abstract position getPosition();
	
	protected abstract void left();
	protected abstract void right();
	protected abstract void center();
}
