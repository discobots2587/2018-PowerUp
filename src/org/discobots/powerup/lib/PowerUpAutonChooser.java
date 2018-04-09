package org.discobots.powerup.lib;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.commands.Launch.type;

public abstract class PowerUpAutonChooser extends AutonChooser {

	protected boolean[] scoreSide;
	protected boolean scalePriority;
	
	@Override
	protected void gameSpecificInit() {
		scoreSide = Autonomous.scoreSide;
		scalePriority = Dashboard.priorityChooser.getSelected().equals(type.SCALE);
	}
}
