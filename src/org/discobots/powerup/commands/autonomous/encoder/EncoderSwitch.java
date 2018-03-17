package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch extends CommandGroup {
	public EncoderSwitch(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new EncoderDriveDistanceTurningComp(141,0));
			Timer.delay(0.3);
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, false));
			Timer.delay(0.3);
			addSequential(new EncoderDriveDistanceTurningComp(20,0));
			Timer.delay(0.3);
			//addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new EncoderDriveDistanceTurningComp(141,0));
			Timer.delay(0.3);
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, true));
			Timer.delay(0.3);
			addSequential(new EncoderDriveDistanceTurningComp(20,0));
			Timer.delay(0.3);
			//addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
