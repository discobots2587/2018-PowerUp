package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.command.Command;

public class Nothing extends Command {

	public Nothing() {
		Debugger.getInstance().log("Nothing was done for autonomous.","AUTON");
	}

	public boolean isFinished() {
		return true;
	}
}
