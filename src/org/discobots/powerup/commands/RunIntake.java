package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class RunIntake extends Command {
	
	public RunIntake() {
		Robot.intake.set(-1);
		Timer.delay(0.5);
		Robot.intake.set(0);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
