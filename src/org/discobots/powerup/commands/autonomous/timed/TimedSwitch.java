package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedSwitch extends CommandGroup {
	public TimedSwitch(Robot.position pos) {
		if(pos.equals(Robot.position.RIGHT)) {
			addSequential(new AutonArcadeDriveTimed(0.7,0,2000));
			addSequential(new AutonArcadeDriveTimed(0,-0.5,300));
			addSequential(new AutonArcadeDriveTimed(0,0,400));
			addSequential(new AutonArcadeDriveTimed(0.7,0,1000));
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.LEFT)) {
			addSequential(new AutonArcadeDriveTimed(0.7,0,2000));
			addSequential(new AutonArcadeDriveTimed(0,0.5,300));
			addSequential(new AutonArcadeDriveTimed(0,0,400));
			addSequential(new AutonArcadeDriveTimed(0.7,0,1000));
			addSequential(new Launch(Launch.type.SWITCH));
		} else if(pos.equals(Robot.position.CENTER)) {
			addSequential(new Nothing());
		}
	}
}
