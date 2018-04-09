package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Nothing extends Command {

	public Nothing() {
		Robot.drive.arcadeDrive(0,0);
	}

	public boolean isFinished() {
		return true;
	}
}
