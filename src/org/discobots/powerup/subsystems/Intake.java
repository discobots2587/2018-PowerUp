package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {
	
	Spark leftIntake;
	Spark rightIntake;
	
	Solenoid leftClaw;
	Solenoid rightClaw;
	
	public void initDefaultCommand() {
		
	}
	
	//initialize, doesn't do anything special
	public Intake() {
		leftIntake = new Spark(HW.leftIntake);
		rightIntake = new Spark(HW.rightIntake);
		
		leftClaw = new Solenoid(HW.leftClaw);
		rightClaw = new Solenoid(HW.rightClaw);
	}
	
	//close - closes the claw
	public void close() {
		leftClaw.set(true);
		rightClaw.set(true);
	}
	
	//open - opens the claw
	public void open() {
		leftClaw.set(false);
		rightClaw.set(false);
	}
	
		
}
