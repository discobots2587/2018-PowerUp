package org.discobots.powerup.commands.autonomous.encoder;

import org.discobots.powerup.Autonomous;
import org.discobots.powerup.Dashboard;
import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;
import org.discobots.powerup.commands.Launch;
import org.discobots.powerup.commands.autonomous.subcommands.AutonArcadeDriveTimed;
import org.discobots.powerup.commands.autonomous.subcommands.AutonTankDriveEncoder;
import org.discobots.powerup.commands.autonomous.subcommands.EncoderDriveDistance;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class EncoderCrossLineScale extends CommandGroup {
	boolean[] scoreSide;
	
	public EncoderCrossLineScale() {
		this.scoreSide = Autonomous.scoreSide;
		
		addSequential(new AutonTankDriveEncoder(0.7,20,20));
	}
	
	@Override
	public void initialize() {
		Robot.pos = Dashboard.positionChooser.getSelected();
		switch(Robot.pos) {
			case RIGHT:
				right();
				break;
			case LEFT:
				left();
				break;
			case CENTER:
				center();
				break;
			default:
				break;
		}
	}
	
	public void right() {
		//check if the right switch is ours
		if(!scoreSide[0]) {
			addSequential(new EncoderDriveDistance(141,0));
			Timer.delay(0.3);
			addSequential(new AutonArcadeDriveTimed(0,-0.5,700));
			Timer.delay(0.3);
			addSequential(new EncoderDriveDistance(20,0));
			Timer.delay(0.3);
			//addSequential(new Launch(Launch.type.SWITCH));
		} else if(!scoreSide[0]){ //check the scale
			addSequential(new EncoderDriveDistance(254,0));
			Timer.delay(0.3);
			addSequential(new AutonArcadeDriveTimed(0,-0.5,500));
			//addSequential(new Launch(Launch.type.SCALE));
		} else { //if neither, aim for the switch
			addSequential(new EncoderDriveDistance(180,0));
			Timer.delay(0.3);
			addSequential(new AutonArcadeDriveTimed(0,-0.5,700));
			Timer.delay(0.3);
			addSequential(new EncoderDriveDistance(200,0));
			Timer.delay(0.3);
			addSequential(new AutonArcadeDriveTimed(0,-0.5,700));
			Timer.delay(0.3);
			addSequential(new EncoderDriveDistance(20,0));
		}
	}
	
	public void center() {
		
	}
	
	public void left() {
		
	}
}
