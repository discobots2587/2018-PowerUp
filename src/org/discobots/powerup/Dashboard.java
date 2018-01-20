package org.discobots.powerup;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public static void init() {
		SmartDashboard.putNumber("TEST", 1);
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
	}
	
	public static void update() {
		SmartDashboard.putNumber("Test", 2);
	}
	
	public static void updatePeriodic(double ms, int thr) {
		update();
	}
}
