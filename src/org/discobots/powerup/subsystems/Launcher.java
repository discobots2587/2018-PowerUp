package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	Solenoid switch1;
	Solenoid switch2;
	Solenoid scale1;
	Solenoid scale2;
	
	public void initDefaultCommand() {
	
	}
	
	//test solenoids for the solenoid test
	public Launcher() {
		switch1 = new Solenoid(HW.solenoid1);
		switch2 = new Solenoid(HW.solenoid2);
		scale1 = new Solenoid(HW.solenoid3);
		scale2 = new Solenoid(HW.solenoid4);
	}
	
	//activates the switch solenoids, only if all four are deactivated
	public void activateSwitch() {
		if(!(anyActivated())) {
			switch1.set(true);
			switch2.set(true);
		}
	}
	
	//activates all four solenoids, only if all four are deactivated
	public void activateScale() {
		if(!(anyActivated())) {
			switch1.set(true);
			switch2.set(true);
			scale1.set(true);
			scale2.set(true);
		}
	}
	
	//deactivates all four solenoids
	public void deactivate() {
		switch1.set(false);
		switch2.set(false);
		scale1.set(false);
		scale2.set(false);
	}
	
	//returns TRUE if any solenoid is activated (its state is TRUE)
	public boolean anyActivated() {
		return (switch1.get())||(switch2.get())||(scale1.get())||(scale2.get());
	}
}
