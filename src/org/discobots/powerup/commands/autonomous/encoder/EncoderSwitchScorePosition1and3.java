package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitchScorePosition1and3 extends CommandGroup{
	int position;
	public void EncoderSwitchScorePostion1and3(int position) {
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		
		//positon 1 and we can score switch
		if( position == 1 && Autonomous.gameData.charAt(0) == 'L') {
			
			//go forward
			this.addSequential(new EncoderDriveDistanceTurningComp(450, 2, 1, 0.01, 0.01));		
			
			//turn right
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, true));
			
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(100, 2, 1, 0.01, 0.01));		

			//shoot
			this.addSequential(new Launch(Launch.type.SCALE));

		}
		//position 1 just cross the line
		else if (position == 1 && Autonomous.gameData.charAt(0) == 'R') {
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(600, 2, 1, 0.01, 0.01));		
		}
		//position 3 and we can score switch
		else if (position == 3 && Autonomous.gameData.charAt(0) == 'R') {
			
			
			//go forward
			this.addSequential(new EncoderDriveDistanceTurningComp(450, 2, 1, 0.01, 0.01));		
			
			//turn left
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, false));
			
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(100, 2, 1, 0.01, 0.01));		

			//shoot
			this.addSequential(new Launch(Launch.type.SCALE));
			
		}
		//position 3 just cross the line 
		else if (position == 3 && Autonomous.gameData.charAt(0) == 'L') {
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(600, 2, 1, 0.01, 0.01));	
		}
	}
}
