package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.commands.IntakeToggle;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroMiddleDouble extends CommandGroup {

	public GyroMiddleDouble(String side) {

		if(side.equals("L"))
			leftGyroMiddleDouble();
		else
			rightGyroMiddleDouble();
 	}

	private void rightGyroMiddleDouble() {
		// TODO Auto-generated method stub
		this.addSequential(new ArcadeGyroDriveTurningComp(-12,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
		
		
		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
		


		this.addSequential(new ArcadeGyroDriveTurningComp(-70,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));

		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
		


		this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
		this.addSequential(new SwitchDrop());
		
		//////////////////////////////////////////////////////////////////
//		
//		//put down arm
//		this.addSequential(new ArmPosition(0));
//		
//		//go forward
//		this.addSequential(new  ArcadeGyroDriveTurningComp(40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"R"));
//		
//		
//		//line up to cubes
//		this.addSequential(new  ArcadeGyroDriveTurningComp(20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		//turn towards cubes
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"R"));
//		
//		
//		//drive up to cubes
//		this.addSequential(new  ArcadeGyroDriveTurningComp(20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//		//open intake
//		this.addSequential(new IntakeToggle());
//		
//		//drive up more
//		this.addSequential(new  ArcadeGyroDriveTurningComp(12,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		//close intake
//		this.addSequential(new IntakeToggle());
//		
//		//stow arm
//		this.addSequential(new ArmPosition(2));
//		
//		
//		//// drive back to switch
//		
//		//go backwards
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"L"));
//		
//		
//		//line up with switch
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-30,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"L"));
//		
//		//drive up to swtich
//		
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//		//score
//		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//		this.addParallel(new SwitchDrop());
		
	}

	private void leftGyroMiddleDouble() {
		// TODO Auto-generated method stub
//		this.addSequential(new ArcadeGyroDriveTurningComp(-6,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));
//
//		this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0));
//
//		//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//		this.addParallel(new SwitchDrop());
		
		/////////////////////////////////////////////////////////
		
		
		
		
		
		//put down arm
//		this.addSequential(new ArmPosition(0));
//		
//		//go forward
//		this.addSequential(new  ArcadeGyroDriveTurningComp(40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"L"));
//		
//		
//		//line up to cubes
//		this.addSequential(new  ArcadeGyroDriveTurningComp(20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		//turn towards cubes
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"L"));
//		
//		
//		//drive up to cubes
//		this.addSequential(new  ArcadeGyroDriveTurningComp(20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//		//open intake
//		this.addSequential(new IntakeToggle());
//		
//		//drive up more
//		this.addSequential(new  ArcadeGyroDriveTurningComp(12,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//
//		//close intake
//		this.addSequential(new IntakeToggle());
//		
//		//stow arm
//		this.addSequential(new ArmPosition(2));
//		
//		
//		//// drive back to switch
//		
//		//go backwards
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-20,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"R"));
//		
//		
//		//line up with switch
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-30,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//	
//		
//		this.addSequential(new  ArcadeGyroTurn(90,1,0.25,0,0,50,"R"));
//		
//		//drive up to swtich
//		
//		this.addSequential(new  ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//		
//		//score
//		this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//		this.addParallel(new SwitchDrop());
	}


}
