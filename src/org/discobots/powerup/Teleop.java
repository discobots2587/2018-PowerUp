package org.discobots.powerup;

import org.discobots.powerup.commands.ArcadeDrive;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.command.Scheduler;

public class Teleop {

	public static void init() {
		// Make sure to disable autonomous
		if(Autonomous.autonCommand != null) {
			Autonomous.autonCommand.cancel();
		}
		
		//choose the drive based off of the dashboard, almost always arcade drive
		Robot.driveCommand = Dashboard.driveChooser.getSelected();
		
		// Instead of a try/catch loop, we can just check if its null
		if(Robot.driveCommand != null) {
			Robot.driveCommand.start();
		} else {
			Debugger.getInstance().log("Drive selector failed, using Arcade Drive","DASH");
			new ArcadeDrive().start();
		}
	}
	
	public static void periodic() {
		//Robot.drive.pigeon.getRawGyro(Robot.drive.gyro_xyz);
		//Robot.drive.pigeon.getYawPitchRoll(Robot.drive.ypr);
		Scheduler.getInstance().run();
		Dashboard.update();
	}
}
