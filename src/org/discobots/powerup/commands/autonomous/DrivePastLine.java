package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DrivePastLine extends CommandGroup {
	
	private boolean timed;
	
	public DrivePastLine(boolean timed) {
		requires(Robot.drive);

		this.timed = timed;
		
		switch(Robot.pos) {
			case LEFT:
				left();
				break;
			case CENTER:
				center();
			case RIGHT:
				right();
		}
	}
	
	private void left() {
		if(this.timed) {
			
		} else {
			
		}
	}
	
	private void center() {
	}
	
	private void right() {
	}
}
