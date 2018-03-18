package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderDumbMiddle extends CommandGroup {
	public void EncoderDumbMiddle() {

	}
	
	@Override
	protected void initialize() {

		if(Autonomous.gameData.charAt(0) == 'L'){
			
			//go forward 
			this.addSequential(new ArcadeEncoderDriveTurningComp(400, 2, 1, 0.01, 0.01));
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));
		}else{
			//turn
			this.addSequential(new ArcadeEncoderTurn(30,2,1.0,0.0,0.0, true));
			
			//forward
			this.addSequential(new ArcadeEncoderDriveTurningComp(400, 2, 1, 0.01, 0.01));
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));


		}
	}
}
