package org.discobots.powerup.commands;

import org.discobots.powerup.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeState extends Command {

	//state - the state you want to make the intake go to (TRUE = open)
	public boolean state;
	
	public IntakeState(boolean stateInput) {
		state = stateInput;
	}
	
	@Override
	public void initialize() {
		if(state)
			Robot.intake.close();
		else
			Robot.intake.open();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
			
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
