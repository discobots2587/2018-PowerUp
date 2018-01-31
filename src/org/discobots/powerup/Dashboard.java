package org.discobots.powerup;

import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public static void init() {
		
		
	}
	
	public static void update() {
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
	}
	
	public static void updatePeriodic(double ms, int thr) {
		update();
	}
}
