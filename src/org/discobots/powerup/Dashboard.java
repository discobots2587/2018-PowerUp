package org.discobots.powerup;

import java.text.DecimalFormat;

import org.discobots.powerup.commands.ArcadeDrive;
import org.discobots.powerup.commands.TankDrive;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLine;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLineScale;
import org.discobots.powerup.commands.autonomous.encoder.EncoderSwitchScorePosition1and3;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;
import org.discobots.powerup.commands.autonomous.subcommands.GyroEncoderDriveDistance;
import org.discobots.powerup.commands.autonomous.timed.TimedCrossLine;
import org.discobots.powerup.subsystems.Arm;
import org.discobots.powerup.utils.Constants;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static final double SHORT_DELAY = 0.1;
	private static final double LONG_DELAY = 0.5;
	
	private static double shortTime = 0.0;
	private static double longTime = 0.0;
	
	public static SendableChooser<Command> autonChooser = new SendableChooser<>();
	public static SendableChooser<Robot.position> positionChooser = new SendableChooser<>();
	public static SendableChooser<Robot.autonType> typeChooser = new SendableChooser<>();
	
	public static SendableChooser<Command> driveChooser = new SendableChooser<>();
	
	public static Robot.autonType selectedType;
	
	public static void init() {
		positionChooser.addDefault("Left", Robot.position.LEFT);
		positionChooser.addObject("Center", Robot.position.CENTER);
		positionChooser.addObject("Right", Robot.position.RIGHT);
		
		typeChooser.addDefault("Timed", Robot.autonType.TIMED);
		typeChooser.addObject("Encoder", Robot.autonType.ENCODER);
		typeChooser.addObject("Gyro", Robot.autonType.GYRO);	
		
		
		autonChooser.addDefault("Nothing", new Nothing());
		autonChooser.addObject("Cross Line Only", new EncoderCrossLine(Robot.pos));
		autonChooser.addObject("Cross Line or Switch (1/3 Only)", new EncoderSwitchScorePosition1and3(Robot.pos));
		
		
		driveChooser.addDefault("Arcade Drive", new ArcadeDrive());
		driveChooser.addObject("Tank Drive", new TankDrive());
		
		SmartDashboard.putData("Position", positionChooser);
		//SmartDashboard.putData("Auton Type",typeChooser);
		SmartDashboard.putData("Autonomous",autonChooser);
		SmartDashboard.putData("Drive",driveChooser);
		
		//SmartDashboard.putData("ENCODER DRIVE DISTANCE", new EncoderDriveDistance(50.0, 5.0, 1.0, 0.0, 0.0));
		//SmartDashboard.putData("GYRO ENCODER", new GyroEncoderDriveDistance(50.0, 5.0, 1.0, 0.0, 0.0, 5.0, 1.0, 0.0, 0.0));
		
	}
	
	public static void autoInit() {
		for(int k = 0; k < 6; k++)
			SmartDashboard.putBoolean(k+"", Autonomous.scoreSide[k]);
	}
	
	//Short & Long dashboard update based of off 3847's dashboard
	public static void update() {
		if((Timer.getFPGATimestamp() - shortTime) > SHORT_DELAY) {
			shortTime = Timer.getFPGATimestamp();
			updateShort();
		}
		if((Timer.getFPGATimestamp() - longTime) > LONG_DELAY) {
			longTime = Timer.getFPGATimestamp();
			updateLong();
		}
	}
	
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
		//SmartDashboard.putNumber("Supply PSI", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.supplyPressure))));
		//SmartDashboard.putNumber("Launcher PSI", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.launcherPressure))));
	}
	
	public static void updateLong() {
		SmartDashboard.putString("Time Left", (Timer.getMatchTime() >= 0.0) ? Utils.secToMinAndSec(Timer.getMatchTime()) : "-1");
		
		SmartDashboard.putNumber("Switch Delay", Constants.kSwitchWait);
		SmartDashboard.putNumber("Scale Delay", Constants.kScaleWait);
		
		//SmartDashboard.putNumber("Yaw", Robot.drive.getYaw());
		
		//SmartDashboard.putNumber("Potentiometer Value", Robot.arm.getPos());
		//SmartDashboard.putNumber("Left Encoder Value", Robot.drive.m_left_encoder.getDistance());
		//SmartDashboard.putNumber("Right Encoder Value", Robot.drive.m_right_encoder.getDistance());
		//SmartDashboard.putNumber("PID arm",Robot.arm.output);
		//SmartDashboard.putNumber("Zeropoint", Robot.arm.zeroPoint);
		//SmartDashboard.putNumber("Potentiometer TRUE value", Robot.arm.armPot.get());
		//SmartDashboard.putNumber("Target", Robot.arm.target);
		
		//SmartDashboard.putNumber("test",Constants.kInchPerTick);
	}
}

