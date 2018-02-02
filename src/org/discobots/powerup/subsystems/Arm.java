package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends PIDSubsystem {
	
	AnalogPotentiometer armPot = new AnalogPotentiometer(HW.potentiometer);
	
	
	public Arm() {
		super("Arm",2,0,0);
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public double returnPIDInput() {
		return armPot.get();
	}
	
	public void usePIDOutput(double output) {
		
	}
}
