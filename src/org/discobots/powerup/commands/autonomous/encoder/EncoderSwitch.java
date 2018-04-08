package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch extends CommandGroup {
	
	public EncoderSwitch(position pos, boolean left) {
		switch(pos) {
			case RIGHT:
				if(!left) { //if the switch is ours, we go for it
					addSequential(new ArcadeEncoderDriveTurningComp(141,0));
					Timer.delay(0.3);
					addSequential(new ArcadeTimedDrive(0,-0.7,575));
					Timer.delay(0.3);
					addSequential(new ArcadeTimedDrive(0.7,0,1000));
					Timer.delay(0.3);
					addSequential(new Launch(Launch.type.SWITCH));
				} else { //otherwise we cross the line
					addSequential(new EncoderCrossLine(pos));
				}
				break;
			case LEFT:
				if(left) { //if the switch is ours, we for go for it
					this.addSequential(new ArcadeEncoderDriveTurningComp(141,0));
					Timer.delay(0.3);
					this.addSequential(new ArcadeTimedDrive(0,0.7,575));
					Timer.delay(0.3);
					this.addSequential(new ArcadeTimedDrive(0.7,0,1000));
					Timer.delay(0.3);
					this.addSequential(new Launch(Launch.type.SWITCH));
				} else { //otherwise we cross the line
					addSequential(new EncoderCrossLine(pos));
				}
				break;
			case CENTER:
				if(left) {
					//go forward
					this.addSequential(new ArcadeEncoderDriveTurningComp(400, 2, 1, 0.01, 0.01));
					//score
					this.addSequential(new Launch(Launch.type.SCALE));
				} else {
					//turn
					this.addSequential(new ArcadeEncoderTurn(30,2,1.0,0.0,0.0, true));
					//forward
					this.addSequential(new ArcadeEncoderDriveTurningComp(400, 2, 1, 0.01, 0.01));
					//score
					this.addSequential(new Launch(Launch.type.SCALE));
				}
				break;
		}
	}
}
