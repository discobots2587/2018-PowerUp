package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroSwitch extends CommandGroup {
	public GyroSwitch(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeGyroDriveTurningComp(140.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
				break;
			case LEFT:
				break;
			case CENTER:
				break;
		}
		addSequential(new ArcadeEncoderDriveTurningComp(61.068, 0.5)); // Go forward for a little turning
	} 
}