package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderScale extends CommandGroup {
	public EncoderScale(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			this.addSequential(new EncoderDriveDistanceTurningComp(273,0));
			this.addSequential(new AutonArcadeDriveTimed(0,-0.7,425));
			this.addSequential(new AutonArcadeDriveTimed(-0.7,0,1000));
			this.addSequential(new AutonArcadeDriveTimed(0,0,750));
			addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.LEFT)) {
			this.addSequential(new EncoderDriveDistanceTurningComp(273,0));
			this.addSequential(new AutonArcadeDriveTimed(0,0.7,425));
			this.addSequential(new AutonArcadeDriveTimed(-0.7,0,1000));
			this.addSequential(new AutonArcadeDriveTimed(0,0,750));
			addSequential(new Launch(Launch.type.SCALE));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
