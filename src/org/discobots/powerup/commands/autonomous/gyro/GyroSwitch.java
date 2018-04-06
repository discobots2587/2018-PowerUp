package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroSwitch extends CommandGroup {
	public GyroSwitch(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				addSequential(new ArcadeGyroDriveTurningComp(140.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
				addSequential(new ArcadeGyroTurn(90.0, 1.0, 0.0, 0.0, 0.0, "L"));
				addSequential(new ArcadeTimedDrive(-0.7, 0.0, 500));
				addSequential(new SwitchDrop());
			case LEFT:
				addSequential(new ArcadeGyroDriveTurningComp(140.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
				addSequential(new ArcadeGyroTurn(90.0, 1.0, 0.0, 0.0, 0.0, "R"));
				addSequential(new ArcadeTimedDrive(-0.7, 0.0, 500));
				addSequential(new SwitchDrop());
				break;
			case CENTER:
				break;
		}
		//addSequential(new ArcadeEncoderDriveTurningComp(61.068, 0.5)); // Go forward for a little turning
	} 
}