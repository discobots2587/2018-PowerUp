package org.discobots.powerup;

import java.text.DecimalFormat;

import org.discobots.powerup.commands.autonomous.DrivePastLine;
import org.discobots.powerup.commands.autonomous.ScoreSwitch;
import org.discobots.powerup.commands.autonomous.ScoreSwitchAndScale;
import org.discobots.powerup.utils.Constants;

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
	
	public static boolean test = false;
	
	public static void init() {
		autonChooser.addObject("Drive Past Line (Timed)", new DrivePastLine(true));
		autonChooser.addDefault("Drive Past Line", new DrivePastLine(false));
		autonChooser.addObject("Score Switch (Timed)", new ScoreSwitch(true));
		autonChooser.addObject("Score Switch", new ScoreSwitch(false));
		autonChooser.addObject("Score Switch & Scale (Timed)", new ScoreSwitchAndScale(true));
		autonChooser.addObject("Score Switch and Scale", new ScoreSwitchAndScale(false));
		
		positionChooser.addDefault("Left", Robot.position.LEFT);
		positionChooser.addObject("Center", Robot.position.CENTER);
		positionChooser.addObject("Right", Robot.position.RIGHT);
		
		SmartDashboard.putData("Auton Chooser", autonChooser);
		SmartDashboard.putData("Position", positionChooser);
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
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
		SmartDashboard.putNumber("Pressure", Robot.launcher.getPressure(Robot.launcher.pressureSensor));
	}
	
	public static void updateLong() {
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
		
		
	}
}
