package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.TimedDrop;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroSwitch extends CommandGroup {
	public GyroSwitch(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				System.out.println("gyro switch right");
				addSequential(new ArcadeGyroDriveTurningComp(160.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
				addSequential(new ArcadeGyroTurn(190.0, 1.0, 1.0, 0.0, 0.0, true));
				addSequential(new ArcadeTimedDrive(0.7, 0.0, 1000));
				addSequential(new Launch(Launch.type.SCALE));
				//addSequential(new TimedDrop());
			case LEFT:
				addSequential(new ArcadeGyroDriveTurningComp(160.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
				addSequential(new ArcadeGyroTurn(90.0, 1.0, 1.0, 0.0, 0.0, true));
				addSequential(new ArcadeTimedDrive(0.7, 0.0, 500));
				addSequential(new Launch(Launch.type.SWITCH));
				break;
			case CENTER:
				break;
		}
		//addSequential(new ArcadeEncoderDriveTurningComp(61.068, 0.5)); // Go forward for a little turning
	} 
}