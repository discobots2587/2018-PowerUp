package org.discobots.powerup;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	public static void init() {
		SmartDashboard.putNumber("Match Time", Timer.getMatchTime());
	}
	
	public static void update() {
		SmartDashboard.putNumber("xSpeed", Robot.oi.getLY());
		SmartDashboard.putNumber("zRotation", Robot.oi.getRX());
		SmartDashboard.putNumber("Encoder", Robot.testEncoder.getRaw());
	}
	
	public static void updatePeriodic(double ms, int thr) {
		update();
	}
}
