package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroSwitch extends CommandGroup {
	public GyroSwitch() {
		addSequential(new ArcadeEncoderDrive(61.068, 0.5)); // Go forward for a little turning
	} 
}