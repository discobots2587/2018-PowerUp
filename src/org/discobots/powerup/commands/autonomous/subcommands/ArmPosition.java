package org.discobots.powerup.commands.autonomous.subcommands;
import edu.wpi.first.wpilibj.command.Command;
import org.discobots.powerup.Robot;

public class ArmPosition extends Command{
	int position;
	public ArmPosition(int position) {
		// TODO Auto-generated constructor stub
		this.position = position;
	}
	
	@Override
	protected void initialize() {
		if(position == 0)
			Robot.arm.setPos(0);
		if(position == 1)
			Robot.arm.setPos(1);
		if(position == 2)
			Robot.arm.setPos(2);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		//return false;
		return true;
	}

}
