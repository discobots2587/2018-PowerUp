package org.discobots.powerup;

import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLine;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLineScale;
import org.discobots.powerup.commands.autonomous.encoder.EncoderDumbMiddle;
import org.discobots.powerup.commands.autonomous.encoder.EncoderSwitchScorePosition1and3;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistanceTurningComp;
import org.discobots.powerup.commands.autonomous.timed.TimedScale;
import org.discobots.powerup.commands.autonomous.timed.TimedSwitch;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
		//Robot.pos = Dashboard.positionChooser.getSelected();
		
		
		//int position =  DriverStation.getInstance().getLocation();
		// if (position == 2)
		//cmdGroup = new EncoderDumbMiddle();
		// else 
		// cmdGroup = new EncoderSwitchScorePosition1and3(position);
		
		//cmdGroup.start();
		
		autonCommand = new AutonArcadeDriveTimed(0.7,0,2000);
		autonCommand.start();
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
