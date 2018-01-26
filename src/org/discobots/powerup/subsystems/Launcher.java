package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	Solenoid solenoid1;
	DoubleSolenoid dsolenoid1;
	
	public void initDefaultCommand() {
	
	}
	
	//test solenoids for the solenoid test
	public Launcher() {
		solenoid1 = new Solenoid(HW.solenoid1);
		dsolenoid1 = new DoubleSolenoid(HW.dsolenoid1,HW.dsolenoid2);
	}
	
	public void setSolenoid(boolean state) {
		solenoid1.set(state);
	}
	
	public void setDSolenoid(DoubleSolenoid.Value state) {
		dsolenoid1.set(state);
	}
	
	
}
