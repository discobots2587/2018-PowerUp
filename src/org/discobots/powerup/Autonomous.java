package org.discobots.powerup;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Autonomous {

	//gameData - FMS game data input
	public static String gameData;
	
	//scoreSide - 3 booleans, left = TRUE (right = FALSE)
	public static boolean[] scoreSide = new boolean[3];
	
	public static void init() {
		gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		//a for loop would be overkill here, just sets the scoreSide array
		scoreSide[0] = (gameData.charAt(0) == 'L');
		scoreSide[1] = (gameData.charAt(1) == 'L');
		scoreSide[2] = (gameData.charAt(2) == 'L');
		
		//test field layout (for once the 
		SmartDashboard.putBooleanArray("Left Side", scoreSide);
	}
	
}
