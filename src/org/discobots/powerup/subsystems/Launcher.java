package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	public void initDefaultCommand() {
	
	}
	
	//test solenoids for the solenoid test
	public Launcher() {
		Solenoid solenoid1 = new Solenoid(HW.solenoid1);
		DoubleSolenoid dsolenoid1 = new DoubleSolenoid(HW.dsolenoid1,HW.dsolenoid2);
	}
}
