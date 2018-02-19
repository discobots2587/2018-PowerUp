package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.AutonTankDriveEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLineScale extends CommandGroup {
	boolean[] scoreSide;
	
	public EncoderCrossLineScale() {
		this.scoreSide = Autonomous.scoreSide;
		switch(Robot.pos) {
		case RIGHT:
			right();
			break;
		case LEFT:
			left();
			break;
		case CENTER:
			center();
			break;
		default:
			break;
		}
	}
	
	public void right() {
		//check if the right scale is ours
		if(!scoreSide[1]) {
			addSequential(new AutonTankDriveEncoder(0.7,254,254));
			addSequential(new AutonArcadeDriveTimed(0,1,500));
			addSequential(new Launch(Launch.type.SCALE));
		} else if(!scoreSide[0]){
			
		} else {
			
		}
	}
	
	public void center() {
		
	}
	
	public void left() {
		
	}
}
