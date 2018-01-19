package org.discobots.powerup;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public static void init() {
		SmartDashboard.putNumber("TEST", 1);
	}
	
	public static void update() {
		
	}
	
	public static void updatePeriodic(double ms) {
		update();
	}
}
