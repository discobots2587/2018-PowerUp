package org.discobots.powerup.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	Solenoid switch1;
	Solenoid switch2;
	Solenoid scale1;
	Solenoid scale2;
	
	Solenoid switch3;
	
	private double targetTime;
	
	private Timer timer;
	
	public void initDefaultCommand() {
	
	}
	
	//launcher solenoids, and creates a timer for measuring the cooldown delay
	public Launcher() {
		switch1 = new Solenoid(HW.solenoid1);
		switch2 = new Solenoid(HW.solenoid2);
		scale1 = new Solenoid(HW.solenoid3);
		scale2 = new Solenoid(HW.solenoid4);
		
		switch3 = new Solenoid(4);
		
		//initialize timer to make sure that it will be after the cooldown
		timer = new Timer();
		this.startCooldown(0);
	}
	
	//activates the switch solenoids, only if all four are deactivated
	public void activateSwitch() {
		if(!(anyActivated())) {
			switch1.set(true);
			switch2.set(true);
			
			switch3.set(true);
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
		
		switch3.set(true);
	}
	
	//returns TRUE if any solenoid is activated (its state is TRUE)
	public boolean anyActivated() {
		return (switch1.get())||(switch2.get())||(scale1.get())||(scale2.get());
	}
	
	public void startCooldown(long time) {
		timer.reset();
		targetTime = Constants.millisToSeconds(time);
		timer.start();
	}
	
	public boolean checkOnCooldown() {
		if(timer.get() > targetTime) {
			timer.stop();
			return false;
		}
		return true;
		//return false;
	}
}
