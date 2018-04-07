package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderScale extends CommandGroup {
	public EncoderScale(Robot.position pos) {
		switch(pos) {
			case RIGHT:
				//this.addSequential(new ArcadeEncoderDriveTurningComp(273,0));
				this.addSequential(new ArcadeGyroDriveTurningComp(273,0.1, 0.7, 0.15, 0.0, 0.35, 0.00, 0.005));
				this.addSequential(new ArcadeTimedDrive(0,-0.7,425));
				this.addSequential(new ArcadeTimedDrive(-0.7,0,1000));
				this.addSequential(new ArcadeTimedDrive(0,0,750));
				this.addSequential(new Launch(Launch.type.SCALE));
				break;
			case LEFT:
				//this.addSequential(new ArcadeEncoderDriveTurningComp(273,0));
				this.addSequential(new ArcadeGyroDriveTurningComp(273,0.1, 0.7, 0.15, 0.0, 0.35, 0.00, 0.005));
				this.addSequential(new ArcadeTimedDrive(0,0.7,425));
				this.addSequential(new ArcadeTimedDrive(-0.7,0,1000));
				this.addSequential(new ArcadeTimedDrive(0,0,750));
				this.addSequential(new Launch(Launch.type.SCALE));
				break;
			case CENTER:
				addSequential(new Nothing());
				break;
		}
	}
}
