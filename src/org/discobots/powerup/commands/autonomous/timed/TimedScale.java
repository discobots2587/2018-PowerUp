package org.discobots.powerup.commands.autonomous.timed;

import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedScale extends CommandGroup {
	public TimedScale() {
		addSequential(new AutonArcadeDriveTimed(0.7,0,3700));
		addSequential(new AutonArcadeDriveTimed(0,-0.5,300));
		addSequential(new AutonArcadeDriveTimed(0,0,400));
		//addSequential(new Launch(Launch.type.SCALE));
		System.out.println("complete");
	}
}
