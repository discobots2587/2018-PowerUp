package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Debugger;
import org.discobots.powerup.utils.Utils;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Launcher extends Subsystem {
	
	public boolean initSuccessful = true;
	
	//Solenoids - all three are used for both launching distances
	Solenoid sol1;
	Solenoid sol2;
	Solenoid sol3;
	
	//Compressor, so we can get readings off of it
	static Compressor compressor;
	
	//Analog input for pressure sensor
	public AnalogInput pressureSensor;
	
	private double targetTime;
	
	private Timer timer;
	
	public void initDefaultCommand() {
	
	}
	
	//launcher solenoids, and creates a timer for measuring the cooldown delay
	public Launcher() {
		init();
		
		//initialize timer to make sure that it will be false after the cooldown
		pressureSensor = new AnalogInput(HW.pressureSensor);
		timer = new Timer();
		this.startCooldown(0);
		
	}
	
	public void init() {
		try {
			compressor = new Compressor(HW.pcm12v);
			compressor.start();
			sol1 = new Solenoid(HW.pcm12v, HW.launcher1);
			sol2 = new Solenoid(HW.pcm12v, HW.launcher2);
			sol3 = new Solenoid(HW.pcm12v, HW.launcher3);
		} catch (Exception e) {
			Debugger.getInstance().log("Init error. Is the PCM plugged in?","PCM");
			initSuccessful = false;
		}
	}
	
	//activates the launcher
	public void activate() {
		if(initSuccessful) {
			if(!(anyActivated())) {
				sol1.set(true);
				sol2.set(true);
				sol3.set(true);
			}
		}
	}
	
	//deactivates the launcher
	public void deactivate() {
		if(initSuccessful) {
			sol1.set(false);
			sol2.set(false);
			sol3.set(false);
		}
	}
	
	//returns TRUE if any solenoid is activated (its state is TRUE)
	public boolean anyActivated() {
		try {
			return (sol1.get())||(sol2.get())||(sol3.get());
		} catch (NullPointerException e) {
			Debugger.getInstance().log("Can't get solenoid values. Is the PCM plugged in?","PCM");
			return true;
		}
	}
	
	//starts a cooldown (disables activating the launcher again) for time amount of milliseconds
	public void startCooldown(long time) {
		timer.reset();
		targetTime = Utils.millisToSeconds(time);
		timer.start();
	}
	
	//reuturns TRUE if the launcher is currently in a cooldown state
	public boolean checkOnCooldown() {
		if(timer.get() > targetTime) {
			timer.stop();
			return false;
		}
		return true;
	}
	
	//returns pressure from voltage on analog pressure sensor
	public double getPressure(AnalogInput pressureSensor) {
		try {
			return 250*(pressureSensor.getVoltage()/5)-25;
		} catch (NullPointerException e){
			Debugger.getInstance().log("Can't get sensor pressure. Is the PCM plugged in?","PCM");
			return -1;
		}
	}
	
	public static Compressor getCompressorInstance() {
		if(compressor == null) {
			compressor = new Compressor(HW.pcm12v);
		}
		return compressor;
	}
}
