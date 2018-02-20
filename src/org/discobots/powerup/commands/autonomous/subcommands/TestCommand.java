package org.discobots.powerup.commands.autonomous.subcommands;
import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.AverageEncoderPIDSource;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
public class TestCommand extends Command{
	
	public TestCommand() {
		System.out.println("/n/n/n/nTESTCOMMAND/n/n/n/n");
	}
	@Override
	protected void initialize() {
		System.out.println("/n/n/n/nTESTCOMMAND INIT/n/n/n/n");

	}
	
	@Override
	protected void execute() {
		
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
		System.out.println("Interrupted");
		end();
	}
}
