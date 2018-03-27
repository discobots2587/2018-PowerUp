package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch90 extends CommandGroup {
	public EncoderSwitch90(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			
			//drive up to switch
			addSequential(new ArcadeEncoderDriveTurningComp(150,0.5));
			Timer.delay(0.3);
			//turn 90
			addSequential(new ArcadeEncoderTurn(90, 0.1, 1, 0.01, 0.01, false));
			Timer.delay(0.3);
			//drive into the switch
			addSequential(new ArcadeEncoderDriveTurningComp(25,0.5));
			Timer.delay(0.3);
			//score with arm
			addSequential(new SwitchDrop());

		} else if(pos.equals(Robot.position.LEFT)) {
			//drive up to switch
			addSequential(new ArcadeEncoderDriveTurningComp(150,0.5));
			Timer.delay(0.3);
			//turn 90
			addSequential(new ArcadeEncoderTurn(90, 0.1, 1, 0.01, 0.01, true));
			Timer.delay(0.3);
			//drive into the switch
			addSequential(new ArcadeEncoderDriveTurningComp(25,0.5));
			Timer.delay(0.3);
			//score with arm
			//drive into the switch
			addSequential(new SwitchDrop());
			
			

		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
