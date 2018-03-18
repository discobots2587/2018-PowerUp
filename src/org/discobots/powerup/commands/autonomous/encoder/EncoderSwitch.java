package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch extends CommandGroup {
	public EncoderSwitch(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new ArcadeEncoderDriveTurningComp(141,0));
			Timer.delay(0.3);
			this.addSequential(new ArcadeTimedDrive(0,-0.7,575));
			Timer.delay(0.3);
			addSequential(new ArcadeTimedDrive(0.7,0,1000));
			Timer.delay(0.3);
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new ArcadeEncoderDriveTurningComp(141,0));
			Timer.delay(0.3);
			this.addSequential(new ArcadeTimedDrive(0,0.7,575));
			Timer.delay(0.3);
			addSequential(new ArcadeTimedDrive(0.7,0,1000));
			Timer.delay(0.3);
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
