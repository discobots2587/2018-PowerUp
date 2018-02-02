package org.discobots.powerup;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {

	//gameData - FMS game data input
	public static String gameData;
	
	//scoreSide - 6 booleans, left side close-to-far, then right side close-to-far
	public static boolean[] scoreSide = new boolean[6];
	
	public static void init() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//set up scoreSide array
		for(int k = 0; k < 3; k++) {
			scoreSide[k] = (gameData.charAt(k) == 'L');
			scoreSide[3+k] = !scoreSide[k];
		}

		Dashboard.autoInit();
		
		Robot.autonChooser.getSelected().start();
	}
	
}
