package org.discobots.powerup;

import java.text.DecimalFormat;

import org.discobots.powerup.commands.autonomous.DrivePastLine;
import org.discobots.powerup.commands.autonomous.ScoreSwitch;
import org.discobots.powerup.commands.autonomous.ScoreSwitchAndScale;
import org.discobots.powerup.commands.autonomous.timed.TimedDrivePastLine;
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
	
	static SendableChooser<Command> autonChooser = new SendableChooser<>();
	static SendableChooser<Robot.position> positionChooser = new SendableChooser<>();
	static SendableChooser<Robot.autonType> typeChooser = new SendableChooser<>();
	
	public static boolean test = false;
	
	public static void init() {
		positionChooser.addDefault("Left", Robot.position.LEFT);
		positionChooser.addObject("Center", Robot.position.CENTER);
		positionChooser.addObject("Right", Robot.position.RIGHT);
		
		typeChooser.addDefault("Timed", Robot.autonType.TIMED);
		typeChooser.addObject("Encoder", Robot.autonType.ENCODER);
		typeChooser.addObject("Gyro", Robot.autonType.GYRO);		
		
		SmartDashboard.putData("Position", positionChooser);
		SmartDashboard.putData("Auton Type",typeChooser);
	}
	
	public static void autoInit() {
		for(int k = 0; k < 6; k++)
			SmartDashboard.putBoolean(k+"",Autonomous.scoreSide[k]);
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
	
	//only gets called periodically before the match
	public static void updatePreMatch() {
		autonChooser.addDefault("Nothing", new DrivePastLine(true));
		
		switch(Robot.aType) {
		case TIMED:
			autonChooser.addObject("Drive Past Line", new TimedDrivePastLine(Robot.pos));
			break;
		case ENCODER:
			encoderOptions();
			break;
		case GYRO:
			gyroOptions();
			break;
		default:
			break;
		}
		SmartDashboard.putData("Auton Chooser", autonChooser);
	}
	
	//encoderOptions, gyroOptions both list out options
	public static void encoderOptions() {
		//autonChooser.addObject("Drive Past Line", new EncoderDrivePastLine(Robot.pos));
	}
	
	public static void gyroOptions() {
		//autonChooser.addObject("Drive Past Line", new GyroDrivePastLine(Robot.pos));
	}
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
		SmartDashboard.putNumber("Supply PSI", Robot.launcher.getPressure(Robot.launcher.supplyPressure));
		SmartDashboard.putNumber("Launcher PSI", Robot.launcher.getPressure(Robot.launcher.launcherPressure));
	}
	
	public static void updateLong() {
		SmartDashboard.putString("Time Left", (Timer.getMatchTime() >= 0.0) ? Utils.secToMinSec(Timer.getMatchTime()) : "-1");
		
		
	}
}
