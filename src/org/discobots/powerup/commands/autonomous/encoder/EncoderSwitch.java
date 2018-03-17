package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderTurn;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderSwitch extends CommandGroup{
	
	public EncoderSwitch() {
		
	}
	
	@Override
	protected void initialize() {
		Robot.pos = Dashboard.positionChooser.getSelected();
		
		switch(Robot.pos) {
		case LEFT:
			left();
			break;
		case CENTER:
			center();
			break;
		case RIGHT:
			right();
			break;
		default:
			break;
		}
	}
	
	public void left() {
		//position 1 and we can score switch
		if(Autonomous.scoreSide[0]) {
			//go forward
			//this.addSequential(new EncoderDriveDistanceTurningComp(140, 2, 1, 0.01, 0.01));
			this.addSequential(new EncoderDriveDistanceTurningComp(168, 2, 1, 0.01, 0.01));
			//turn right
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, true));
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(30, 2, 1, 0.01, 0.01));
			//shoot
			this.addSequential(new Launch(Launch.type.SWITCH));
		} else { //position 1 just cross the line
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(190, 2, 1, 0.01, 0.01));		
		}
	}
	
	public void right() {
		//position 3 just cross the line 
		if (Autonomous.scoreSide[0]) {
			//go forward and get us close to the scale
			this.addSequential(new EncoderDriveDistanceTurningComp(190, 2, 1, 0.01, 0.01));	
		} else {  //position 3 and we can score switch
			//go forward
			//this.addSequential(new EncoderDriveDistanceTurningComp(140, 2, 1, 0.01, 0.01));
			this.addSequential(new EncoderDriveDistanceTurningComp(168, 2, 1, 0.01, 0.01));
			//turn left
			this.addSequential(new EncoderTurn(90,2,1.0,0.0,0.0, false));
			//go forward a little more
			this.addSequential(new EncoderDriveDistanceTurningComp(30, 2, 1, 0.01, 0.01));		
			//shoot
			this.addSequential(new Launch(Launch.type.SWITCH));
		}
	}
	
	public void center() {
	}
}
