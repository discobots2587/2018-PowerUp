package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderScale extends CommandGroup {
	
	public EncoderScale(position pos, boolean left) {
		switch(pos) {
			case RIGHT:
				if(!left) { //if the scale is ours, we go for it
					addSequential(new ArcadeEncoderDriveTurningComp(273,0));
					//addSequential(new ArcadeGyroDriveTurningComp(273,0.1, 0.7, 0.15, 0.0, 0.35, 0.00, 0.005));
					addSequential(new ArcadeTimedDrive(0,-0.7,425));
					addSequential(new ArcadeTimedDrive(-0.7,0,1000));
					addSequential(new ArcadeTimedDrive(0,0,750));
					addSequential(new Launch(Launch.type.SCALE));
				} else { //otherwise we try the switch
					addSequential(new EncoderSwitch(pos, left));
				}
				break;
			case LEFT:
				if(left) { //if the scale is ours, we go for it
					addSequential(new ArcadeEncoderDriveTurningComp(273,0));
					//addSequential(new ArcadeGyroDriveTurningComp(273,0.1, 0.7, 0.15, 0.0, 0.35, 0.00, 0.005));
					addSequential(new ArcadeTimedDrive(0,0.7,425));
					addSequential(new ArcadeTimedDrive(-0.7,0,1000));
					addSequential(new ArcadeTimedDrive(0,0,750));
					addSequential(new Launch(Launch.type.SCALE));
				} else { //otherwise we try the switch
					addSequential(new EncoderSwitch(pos, left));
				}
				break;
			case CENTER: //we go for the switch
				addSequential(new EncoderSwitch(pos, left));
				break;
		}
	}
}
