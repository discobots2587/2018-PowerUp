package org.discobots.powerup.commands.autonomous.timed;
import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.autonomous.subcommands.ArcadeTimedDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;

//TODO - Dial in values
public class TimedCrossLine extends CommandGroup{
	private String gameData;
	public TimedCrossLine(String gameData, position pos) {
		this.gameData = gameData;
		
		//From Position LEFT or RIGHT
		if(pos == Robot.position.LEFT || pos == Robot.position.RIGHT){
			if(gameData.charAt(0) == 'L'){
				addSequential(new ArcadeTimedDrive(0.5,0,4000));
				addSequential(new ArcadeTimedDrive(0,0.5,500));
			}else{
				//gameData.charAt(0) == 'R'
				addSequential(new ArcadeTimedDrive(0.5,0,4000));
				addSequential(new ArcadeTimedDrive(0,-0.5,500));
			}
		}
		else{
			// Position is CENTER
			if(gameData.charAt(0) == 'L'){
				//If gameData.charAt(0) == 'L' we want to go straight into the switch
				//We will place our robot in front of the left switch always
				addSequential(new ArcadeTimedDrive(0.5,0,2000));
				
			}else{
				//gameData.charAt(0) == 'R'
				//We need to go forward a bit, turn to the right then go straight to cross the line,
				addSequential(new ArcadeTimedDrive(0.5,0,500));
				addSequential(new ArcadeTimedDrive(0,-0.5,500));
				addSequential(new ArcadeTimedDrive(0.5,0, 4000));
			}
		}
		
		
	}
}
