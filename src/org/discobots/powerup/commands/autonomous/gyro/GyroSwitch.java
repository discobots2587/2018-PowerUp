package org.discobots.powerup.commands.autonomous.gyro;

import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.SwitchDrop;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class GyroSwitch extends CommandGroup {
	
	public GyroSwitch(position pos, boolean left) {
		switch(pos) {
			case RIGHT:
				if(!left) { //if the switch is on our side
					addSequential(new ArcadeGyroDriveTurningComp(160.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
					addSequential(new ArcadeGyroTurn(190.0, 1.0, 1.0, 0.0, 0.0, true));
					addSequential(new ArcadeTimedDrive(0.7, 0.0, 1000));
					addSequential(new Launch(Launch.type.SCALE));
				} else { //if the switch is NOT on our side, we attempt scale
					addSequential(new GyroScale(pos, left));
				}
			case LEFT:
				if(left) { //if the switch is on our side
					addSequential(new ArcadeGyroDriveTurningComp(160.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
					addSequential(new ArcadeGyroTurn(90.0, 1.0, 1.0, 0.0, 0.0, true));
					addSequential(new ArcadeTimedDrive(0.7, 0.0, 500));
					addSequential(new Launch(Launch.type.SWITCH));
				} else { //if the switch is NOT on our side, we attempt scale
					addSequential(new GyroScale(pos, left));
				}
				break;
			case CENTER:
				if(left) {
//					this.addSequential(new ArcadeEncoderDriveTurningComp(-6,0));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
//					this.addSequential(new ArcadeEncoderDriveTurningComp(-30,0));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
					//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
					this.addSequential(new ArcadeTimedDrive(0.5, 0, 3000));
					this.addSequential(new SwitchDrop());
//					this.addSequential(new ArcadeGyroDriveTurningComp(-6,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"R"));
//					this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"L"));
//					//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//					this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//					this.addParallel(new SwitchDrop());
				} else {
					this.addSequential(new ArcadeGyroDriveTurningComp(-6.0,0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
//					this.addSequential(new ArcadeEncoderDriveTurningComp(-30,0));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0, "L"));
					//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
					this.addSequential(new ArcadeTimedDrive(0.5, 0, 3000));
					this.addSequential(new SwitchDrop());
//					this.addSequential(new ArcadeGyroDriveTurningComp(-6,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"R"));
//					this.addSequential(new ArcadeGyroDriveTurningComp(-40,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005));
//					this.addSequential(new  ArcadeGyroTurn(30,1,0.25,0,0,50,"L"));
//					//this.addSequential(new ArcadeEncoderDriveTurningComp(-10,0));
//					this.addParallel(new ArcadeTimedDrive(0.5, 0, 3000));
//					this.addParallel(new SwitchDrop());
				}
				break;
		}
	}
}