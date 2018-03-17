package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderDumbMiddle extends CommandGroup {
	public void EncoderDumbMiddle() {

	}
	
	@Override
	protected void initialize() {

		if(Autonomous.gameData.charAt(0) == 'L'){
			
			//go forward 
			this.addSequential(new EncoderDriveDistanceTurningComp(400, 2, 1, 0.01, 0.01));
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));
		}else{
			//turn
			this.addSequential(new EncoderTurn(30,2,1.0,0.0,0.0, true));
			
			//forward
			this.addSequential(new EncoderDriveDistanceTurningComp(400, 2, 1, 0.01, 0.01));
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));


		}
	}
}
