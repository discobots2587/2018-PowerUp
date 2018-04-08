package org.discobots.powerup.lib;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch.type;
import org.discobots.powerup.commands.autonomous.Nothing;

import edu.wpi.first.wpilibj.command.Command;

public abstract class AutonChooser extends Command {

	protected boolean[] scoreSide;
	protected position pos;
	protected boolean scalePriority;
	protected Command autonCommand;
	
	@Override
	public void initialize() {
		scoreSide = Autonomous.scoreSide;
		pos = Dashboard.positionChooser.getSelected();
		scalePriority = Dashboard.priorityChooser.getSelected().equals(type.SCALE);
		
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
	protected boolean isFinished() {
		return true;
	}
	
	protected abstract void left();
	protected abstract void right();
	protected abstract void center();
}
