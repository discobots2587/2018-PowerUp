package org.discobots.powerup.commands.autonomous.gyro;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroMiddle extends CommandGroup {
	public GyroMiddle() {
		addSequential(new ArcadeEncoderDriveTurningComp(-12,0));
		Timer.delay(0.3);

//		addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,true));
//		Timer.delay(0.3);
//
//		addSequential(new ArcadeEncoderDriveTurningComp(-96,0));
//		Timer.delay(0.3);
//
//		addSequential(new  ArcadeGyroTurn(-30,1,0.25,0,0,50,true));
//		Timer.delay(0.3);
//
//		addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//		Timer.delay(0.3);


	}
}
