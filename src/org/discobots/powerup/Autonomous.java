package org.discobots.powerup;

import org.discobots.powerup.commands.autonomous.subcommands.ArcadeEncoderDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroDriveTurningComp;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeGyroTurn;
import org.discobots.powerup.commands.autonomous.subcommands.GyroTurn;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Autonomous {

	//gameData - FMS game data input
	public static String gameData = "";
	
	//scoreSide - 6 booleans, left side close-to-far, then right side close-to-far
	public static boolean[] scoreSide = new boolean[6];
	
	//autonCommand, so we can access the selected autonomous command
	public static Command autonCommand;
	public static CommandGroup cmdGroup;
	
	public static void init() {
		int count = 0;
		while(gameData.length() < 3 && count < 3) {
			gameData = DriverStation.getInstance().getGameSpecificMessage();
			Timer.delay(0.5);
			count++;
		}
		
		//set up scoreSide array
		for(int k = 0; k < 3; k++) {
			scoreSide[k] = (gameData.charAt(k) == 'L');
			scoreSide[3+k] = !scoreSide[k];
		}

		Dashboard.autoInit();
		
		Robot.drive.m_right_encoder.reset();
		Robot.drive.m_left_encoder.reset();
		//Robot.pos = Dashboard.positionChooser.getSelected();
		
		
		//int position =  DriverStation.getInstance().getLocation();
		// if (position == 2)
		//cmdGroup = new EncoderDumbMiddle();
		// else 
		// cmdGroup = new EncoderSwitchScorePosition1and3(position);
		
		//cmdGroup.start();
		
		Robot.intake.open();
		
		Robot.arm.init();
		
//		autonCommand = Dashboard.autonChooser.getSelected();
		
		//STEP 1 Test ArcadeGyroDriveTurningComp forward
		autonCommand = new ArcadeGyroDriveTurningComp(150,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005);
		
//		
//		//STEP 2 Test ArcadeGyroDriveTurningComp backwards
//		autonCommand = new ArcadeGyroDriveTurningComp(150,0.1, 0.7, 0.0, 0.0, 0.15, 0.00, 0.005);
//		
//		
//		//STEP 3 Test ArcadeGyroTurn right turn. Assuming forward is the way we would face a power cube to intake from floor
//		autonCommand = new  ArcadeGyroTurn(90,1,0.25,0,0,50,"R");
//		
//		//STEP 4 Test ArcadeGyroTurn left turn. Assuming forward is the way we would face a power cube to intake from floor
//		autonCommand = new  ArcadeGyroTurn(90,1,0.25,0,0,50,"L");
				
		autonCommand.start();
//		//autonCommand = new EncoderDriveDistanceTurningComp(40,1,1,.01,.01);
//		//autonCommand = new AutonArcadeDriveTimed(0,0.7,625);
////		double target = Robot.drive.getYaw()+30;
////		autonCommand = new ArcadeGyroTurn(target,1,0.25,0,0);
//		//autonCommand = new GyroTurn(80, 1, 1.0, 0.0, 0.01);
//		CommandGroup group = new CommandGroup();
//		group.addSequential(new ArcadeEncoderDriveTurningComp(-9,0.5));
//		double target = Robot.drive.getYaw()+30;
//		autonCommand = new ArcadeGyroTurn(target,1,0.25,0,0);
//		group.addSequential(new ArcadeEncoderDriveTurningComp(-60,0.5));
//		double target1 = Robot.drive.getYaw()-30;
//		autonCommand = new ArcadeGyroTurn(target1,1,0.25,0,0);
//		group.addSequential(new ArcadeEncoderDriveTurningComp(-9,0.5));
		//group.start();
		
		
	}
	
	public static void periodic() {
		//Robot.drive.pigeon.getRawGyro(Robot.drive.gyro_xyz);
		//Robot.drive.pigeon.getAccelerometerAngles(Robot.drive.accel_xyz);
		//Robot.drive.pigeon.getYawPitchRoll(Robot.drive.ypr);
		Scheduler.getInstance().run();
		Dashboard.update();
	}
	
	public void cancel() {
		Scheduler.getInstance().removeAll();
	}
	
}
