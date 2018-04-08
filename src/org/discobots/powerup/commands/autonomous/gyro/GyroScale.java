package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroScale extends CommandGroup{

	public GyroScale(position pos, boolean left) {
		switch(pos) {
			case RIGHT:
				if(!left) { //same side
					addSequential(new ArcadeGyroDriveTurningComp(400,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//turn towards scale 
					addSequential(new ArcadeGyroDriveTurningComp(90,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//drive to field border
					addSequential(new ArcadeGyroDriveTurningComp(-17,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//score
					addSequential(new Launch(Launch.type.SCALE));
				} else {
					//approach middle
					addSequential(new ArcadeGyroDriveTurningComp(250,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//turn towards away from opposite, 
//					this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0, "L"));
					// drive backwards  towards opposite side
					addSequential(new ArcadeGyroDriveTurningComp(-350,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					// turn 30 to align to drive into position
//					this.addSequential(new  ArcadeGyroTurn(45,1,0.25,0,0));
//					//get closer to the scale
//					this.addSequential(new ArcadeGyroDriveTurningComp(-30,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					//Straighten up 
//					this.addSequential(new  ArcadeGyroTurn(-45,1,0.25,0,0));
//					//back up to field border
//					this.addSequential(new ArcadeTimedDrive(-0.5, 0, 1000));
//					//score 
//					this.addSequential(new Launch(Launch.type.SCALE));
				}
				break;
			case LEFT:
				if(left) { //same side
					//approach scale
					addSequential(new ArcadeGyroDriveTurningComp(400,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//turn towards scale 
					addSequential(new ArcadeGyroDriveTurningComp(-90,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//drive to field border
					addSequential(new ArcadeGyroDriveTurningComp(-17,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//score
					addSequential(new Launch(Launch.type.SCALE));
				} else {
					//approach middle
					addSequential(new ArcadeGyroDriveTurningComp(250,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
					//turn towards away from opposite, 
//					this.addSequential(new  ArcadeGyroTurn(-90,1,0.25,0,0, "L"));
					// drive backwards  towards opposite side
					addSequential(new ArcadeGyroDriveTurningComp(-350,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					// turn 30 to align to drive into position
//					this.addSequential(new  ArcadeGyroTurn(-45,1,0.25,0,0));
//					//get closer to the scale
//					this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					//straighten up 
//					this.addSequential(new  ArcadeGyroTurn(45,1,0.25,0,0));
//					//back up to field border
//					this.addSequential(new ArcadeTimedDrive(-0.5, 0, 1000));
//					//score 
//					this.addSequential(new Launch(Launch.type.SWITCH));
				}
				break;
			case CENTER:
				addSequential(new GyroSwitch(pos, left));
				break;
		}
	}
}
