package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Spark leftIntake;
	Spark rightIntake;
	
	Solenoid claw;
	
	public void initDefaultCommand() {
		
	}
	
	//initialize, doesn't do anything special
	public Intake() {
		leftIntake = new Spark(HW.leftIntake);
		rightIntake = new Spark(HW.rightIntake);
		
		claw = new Solenoid(HW.claw);
	}
	
	//close - closes the claw
	public void close() {
		claw.set(true);
	}
	
	//open - opens the claw
	public void open() {
		claw.set(false);
	}
	
	
}
