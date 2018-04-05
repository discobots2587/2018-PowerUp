package org.discobots.powerup.commands.autonomous.gyro;
import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroMiddle extends CommandGroup {
	public GyroMiddle(String side) {
		if(side.equals("L"))
			leftGyroMiddle();
		else
			rightGyroMiddle();
		



	}
	
	public void rightGyroMiddle() {
		
		this.addSequential(new ArcadeEncoderDriveTurningComp(-6,0));
		

		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));

		this.addSequential(new ArcadeEncoderDriveTurningComp(-30,0));

		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));

		//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
		this.addParallel(new SwitchDrop());
		

//		this.addSequential(new ArcadeGyroDriveTurningComp(-6,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"R"));
//
//		this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"L"));
//
//		//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//		this.addParallel(new SwitchDrop());
	
	}
	
	public void leftGyroMiddle() {
		this.addSequential(new ArcadeEncoderDriveTurningComp(-6,0));
		
		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));

		this.addSequential(new ArcadeEncoderDriveTurningComp(-30,0));

		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));

		//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
		this.addParallel(new SwitchDrop());
		
		
		
//		this.addSequential(new ArcadeGyroDriveTurningComp(-6,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"R"));
//
//		this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"L"));
//
//		//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//		this.addParallel(new SwitchDrop());
	}
}
