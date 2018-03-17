package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderScale extends CommandGroup {
	public EncoderScale(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new EncoderDriveDistanceTurningComp(254,0));
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, false));
			this.addSequential(new EncoderDriveDistanceTurningComp(-20,0));
			//addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new EncoderDriveDistanceTurningComp(254,0));
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, true));
			this.addSequential(new EncoderDriveDistanceTurningComp(-20,0));
			//addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
