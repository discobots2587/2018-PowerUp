package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitchScorePosition1and3 extends CommandGroup{
	int position;
	public EncoderSwitchScorePosition1and3() {
		switch(Robot.pos) {
		case LEFT:
			this.position = 1;
			break;
		case CENTER:
			this.position = 2;
			break;
		case RIGHT:
			this.position = 3;
			break;
		default:
			break;
		}
	}
	
	@Override
	protected void initialize() {
		
		//positon 1 and we can score switch
		if( position == 1 && Autonomous.gameData.charAt(0) == 'L') {
			
			//go forward
			this.addSequential(new EncoderDriveDistanceTurningComp(140, 2, 1, 0.01, 0.01));		
			
			//turn right
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, true));
			
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(30, 2, 1, 0.01, 0.01));		

			//shoot
			this.addSequential(new Launch(Launch.type.SCALE));

		}
		//position 1 just cross the line
		else if (position == 1 && Autonomous.gameData.charAt(0) == 'R') {
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(190, 2, 1, 0.01, 0.01));		
		}
		//position 3 and we can score switch
		else if (position == 3 && Autonomous.gameData.charAt(0) == 'R') {
			
			
			//go forward
			this.addSequential(new EncoderDriveDistanceTurningComp(140, 2, 1, 0.01, 0.01));		
			
			//turn left
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, false));
			
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(30, 2, 1, 0.01, 0.01));		

			//shoot
			this.addSequential(new Launch(Launch.type.SCALE));
			
		}
		//position 3 just cross the line 
		else if (position == 3 && Autonomous.gameData.charAt(0) == 'L') {
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(190, 2, 1, 0.01, 0.01));	
		}
	}
}
