package org.discobots.powerup.commands.autonomous;

import org.discobots.powerup.Robot;
import org.discobots.powerup.commands.Launch.type;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class TimedAuton extends Command {

		private type dir;
		private long time;
	
		public enum type {
			FORWARD, BACKWARD, LEFT, RIGHT
		};
		
		public TimedAuton(type dir, long t) {
			requires(Robot.drive);
			this.dir = dir;
			this.time = t;
		}
	
		// Called just before this Command runs the first time
		@Override
		protected void initialize() {
			if(dir.equals(type.FORWARD)) {
				Robot.drive.arcadeDrive(1, 0);
			} else if(dir.equals(type.BACKWARD)) {
				Robot.drive.arcadeDrive(-1, 0);
			} else if(dir.equals(type.LEFT)) {
				Robot.drive.arcadeDrive(1, 1);
			} else if(dir.equals(type.RIGHT)) {
				Robot.drive.arcadeDrive(1, -1);
			}

			Timer.delay(time);
			Robot.drive.arcadeDrive(0, 0);
		}

		// Called repeatedly when this Command is scheduled to run
		@Override
		protected void execute() {
		}

		// Make this return true when this Command no longer needs to run execute()
		@Override
		protected boolean isFinished() {
			return false;
		}

		// Called once after isFinished returns true
		@Override
		protected void end() {
		}

		// Called when another command which requires one or more of the same
		// subsystems is scheduled to run
		@Override
		protected void interrupted() {
		}
	}
