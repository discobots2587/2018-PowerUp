package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GryoScale extends CommandGroup{

	public GryoScale() {
		// TODO Auto-generated constructor stub
		
		
		//ASSUMING  robot is facing "forward" (this is the way we'd face a cube to pick it up)s
		
		if (Robot.pos == Robot.position.LEFT) {
			if( Autonomous.gameData.charAt(1) == 'L') 
				straight();
			else 
				oppositeSide();
		}
		else if (Robot.pos == Robot.position.RIGHT) {
			if( Autonomous.gameData.charAt(1) == 'R') 
				straight();
			else 
				oppositeSide();
		}

		
	}

	private void oppositeSide() {
		// TODO Auto-generated method stub
		
		//if robot pos left then score on the opposite scale (right)
		
		if( Robot.pos == Robot.position.LEFT) {
			
			//approach middle
			this.addSequential(new ArcadeGyroDriveTurningComp(250,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//turn towards away from opposite, 
			this.addSequential(new  ArcadeGyroTurn(-90,1,0.25,0,0, "L"));
			
			// drive backwards  towards opposite side
			this.addSequential(new ArcadeGyroDriveTurningComp(-350,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
//			// turn 30 to align to drive into position
//			this.addSequential(new  ArcadeGyroTurn(-45,1,0.25,0,0));
//			
//			//get closer to the scale
//			this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//			
//			
//			//strighten up 
//			this.addSequential(new  ArcadeGyroTurn(45,1,0.25,0,0));
//			
//			
//			//back up to field border
//			this.addSequential(new ArcadeTimedDrive(-0.5, 0, 1000));
//
//			//score 
//			
//			this.addSequential(new Launch(Launch.type.SWITCH));

		}
		//else robot is starting on the right, score on the opposite scale (left)
		else {
			
			//approach middle
			this.addSequential(new ArcadeGyroDriveTurningComp(250,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//turn towards away from opposite, 
			this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0, "L"));
			
			// drive backwards  towards opposite side
			this.addSequential(new ArcadeGyroDriveTurningComp(-350,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//			
//			// turn 30 to align to drive into position
//			this.addSequential(new  ArcadeGyroTurn(45,1,0.25,0,0));
//			
//			//get closer to the scale
//			this.addSequential(new ArcadeGyroDriveTurningComp(-30,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//			
//			
//			//Straighten up 
//			this.addSequential(new  ArcadeGyroTurn(-45,1,0.25,0,0));
//			
//			
//			//back up to field border
//			this.addSequential(new ArcadeTimedDrive(-0.5, 0, 1000));
//
//			//score 
//			
//			this.addSequential(new Launch(Launch.type.SCALE));
		}
		
	}

	private void straight() {
		// TODO Auto-generated method stub
		
		//if robot pos is left, score on left scale
		if (Robot.pos == Robot.position.LEFT) {
			//approach scale
			this.addSequential(new ArcadeGyroDriveTurningComp(400,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//turn towards scale 
			this.addSequential(new ArcadeGyroDriveTurningComp(-90,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//drive to field border
			this.addSequential(new ArcadeGyroDriveTurningComp(-17,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));


		}
		//else robot pos is right, score on right scale
		else {
			this.addSequential(new ArcadeGyroDriveTurningComp(400,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//turn towards scale 
			this.addSequential(new ArcadeGyroDriveTurningComp(90,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			//drive to field border
			this.addSequential(new ArcadeGyroDriveTurningComp(-17,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
			
			
			//score
			this.addSequential(new Launch(Launch.type.SCALE));

		}
	}

}
