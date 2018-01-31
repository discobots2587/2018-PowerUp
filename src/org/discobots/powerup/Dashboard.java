package org.discobots.powerup;

import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public static void init() {
	}
	
	public static void update() {
		updateLong();
		updateShort();
	}
	
	public static void updateLong() {
		
	}
	
	public static void updateShort() {
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
	}
}
