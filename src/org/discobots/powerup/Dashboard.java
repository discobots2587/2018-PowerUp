package org.discobots.powerup;

import java.text.DecimalFormat;

import org.discobots.powerup.commands.ArcadeDrive;
import org.discobots.powerup.commands.TankDrive;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLine;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLineScale;
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
		
		driveChooser.addDefault("Arcade Drive", new ArcadeDrive());
		driveChooser.addObject("Tank Drive", new TankDrive());
		
		SmartDashboard.putData("Position", positionChooser);
		SmartDashboard.putData("Auton Type",typeChooser);
		SmartDashboard.putData("Drive",driveChooser);
		
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
	
	//only gets called periodically before the match
	public static void updatePreMatch() {
		/*if(Robot.pos == null) {
			Robot.pos = Robot.position.CENTER;
		}
		
		//check if selected type is null (will always run this on the first time) or check if it changes
		if((!typeChooser.getSelected().equals(selectedType))||(selectedType == null)) {
			selectedType = typeChooser.getSelected();
			
			SmartDashboard.delete("Auton Chooser");
			
			autonChooser = new SendableChooser<>();
			autonChooser.addDefault("Nothing", new Nothing());
			
			switch(typeChooser.getSelected()) {
			case TIMED:
				autonChooser.addObject("[Timed] Drive Past Line", new TimedCrossLine(Autonomous.gameData, Robot.pos));
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
		}*/
	}
	
	//encoderOptions, gyroOptions both list out options
	public static void encoderOptions() {
		autonChooser.addObject("[Enc] Drive Past Line", new EncoderCrossLine());
		autonChooser.addObject("[Enc] Scale", new EncoderCrossLineScale());
	}
	
	public static void gyroOptions() {
		//autonChooser.addObject("Drive Past Line", new GyroDrivePastLine());
	}
	
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
		SmartDashboard.putNumber("Supply PSI", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.supplyPressure))));
		SmartDashboard.putNumber("Launcher PSI", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.launcherPressure))));
	}
	
	public static void updateLong() {
		SmartDashboard.putString("Time Left", (Timer.getMatchTime() >= 0.0) ? Utils.secToMinAndSec(Timer.getMatchTime()) : "-1");
		
		SmartDashboard.putNumber("Switch Delay", Constants.kSwitchWait);
		SmartDashboard.putNumber("Scale Delay", Constants.kScaleWait);
		
		/*SmartDashboard.putNumber("GYRO X", Robot.drive.gyro_xyz[0]);
		SmartDashboard.putNumber("GYRO Y", Robot.drive.gyro_xyz[1]);
		SmartDashboard.putNumber("GYRO Z", Robot.drive.gyro_xyz[2]);
		
		SmartDashboard.putNumber("Yaw", Robot.drive.ypr[0]);
		SmartDashboard.putNumber("Pitch", Robot.drive.ypr[1]);
		SmartDashboard.putNumber("Roll", Robot.drive.ypr[2]);*/
		
		SmartDashboard.putNumber("Potentiometer Value", Robot.arm.armPot.get());
		SmartDashboard.putNumber("Left Encoder Value", Robot.drive.m_left_encoder.get());
		SmartDashboard.putNumber("Right Encoder Value", Robot.drive.m_right_encoder.get());
	}
}

