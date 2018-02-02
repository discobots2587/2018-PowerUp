package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends PIDSubsystem {
	
	public AnalogPotentiometer armPot = new AnalogPotentiometer(HW.potentiometer);
	
	public DigitalInput limSwitch1 = new DigitalInput(HW.limSwitch1);
	public DigitalInput limSwitch2 = new DigitalInput(HW.limSwitch2);
	
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
