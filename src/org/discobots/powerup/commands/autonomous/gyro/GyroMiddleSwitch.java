package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroMiddleSwitch extends CommandGroup 
{
	addSequential(new EncoderDriveDistance()); 
}