package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroMiddleSwitch extends CommandGroup 
{
	public GyroMiddleSwitch()
	{
		addSequential(new EncoderDriveDistance(61.068, 0.5)); // Go forward for a little turning
	} 
}