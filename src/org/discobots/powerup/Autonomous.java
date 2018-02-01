package org.discobots.powerup;

import edu.wpi.first.wpilibj.DriverStation;

public class Autonomous {

	public static String gameData;
	
	public static void init() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
	}
	
}
