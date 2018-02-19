package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Winch extends Subsystem {

	public Spark winchMotor;
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public Winch() {
		winchMotor = new Spark(HW.winch);
	}
	
	public void set(double value) {
		winchMotor.set(value);
	}
}
