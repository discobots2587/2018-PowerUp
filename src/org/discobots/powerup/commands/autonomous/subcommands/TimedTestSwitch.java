package org.discobots.powerup.commands.autonomous.subcommands;

import org.discobots.powerup.commands.Launch;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class TimedTestSwitch extends CommandGroup {
	public TimedTestSwitch() {
		addSequential(new AutonArcadeDriveTimed(0.7,0,2000));
		addSequential(new AutonArcadeDriveTimed(0,-0.5,300));
		addSequential(new AutonArcadeDriveTimed(0,0,400));
		addSequential(new Launch(Launch.type.SWITCH));
		//System.out.println("complete");
	}
}
