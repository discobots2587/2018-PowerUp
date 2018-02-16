package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Spark leftIntake;
	Spark rightIntake;
	
	public Solenoid claw;
	
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
	
	//toggle - toggles the claw
	public void toggle() {
		if(claw.get())
			claw.set(false);
		else
			claw.set(true);
	}
	
	//set - drives in at a given speed
	public void set(double speed) {
		leftIntake.set(speed);
		rightIntake.set(speed);
	}
}
