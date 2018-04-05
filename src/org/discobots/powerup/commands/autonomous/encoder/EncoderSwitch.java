package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch extends CommandGroup {
	public EncoderSwitch(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				this.addSequential(new ArcadeEncoderDriveTurningComp(141,0));
				Timer.delay(0.3);
				this.addSequential(new ArcadeTimedDrive(0,-0.7,575));
				Timer.delay(0.3);
				this.addSequential(new ArcadeTimedDrive(0.7,0,1000));
				Timer.delay(0.3);
				this.addSequential(new Launch(Launch.type.SWITCH));
				break;
			case LEFT:
				this.addSequential(new ArcadeEncoderDriveTurningComp(141,0));
				Timer.delay(0.3);
				this.addSequential(new ArcadeTimedDrive(0,0.7,575));
				Timer.delay(0.3);
				this.addSequential(new ArcadeTimedDrive(0.7,0,1000));
				Timer.delay(0.3);
				this.addSequential(new Launch(Launch.type.SWITCH));
				break;
			case CENTER:
				this.addSequential(new Nothing());
				break;
		}
	}
}
