package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.SpeedController;

//rampedMotor, which is based pretty heavily on FRC-pdr's ramped motor wrapper
public class RampedMotor implements SpeedController {
	private PWMSpeedController motor;
	private double previousOutput = 0;
	private double rampBand;
	
	public RampedMotor(PWMSpeedController m, double rb) {
		motor = m;
		rampBand = rb;
	}
	
	public double getRampBand() {
		return this.rampBand;
	}
	
	public void setRampBand(double rb) {
		this.rampBand = rb;
	}
	
	public void pidWrite(double input) {
		this.set(input);
	}
	
	public void set(double input) {		
		//if the change is larger than rampBand
		if(Math.abs(input-previousOutput)>this.rampBand) {
			//only change it by rampBand
			motor.set(previousOutput+(Math.copySign(rampBand, input-previousOutput)));
		} else {
			//if not, just set it to the input
			motor.set(input);
		}
	}

	@Override
	public double get() {
		// TODO Auto-generated method stub
		return this.motor.get();
	}

	@Override
	public boolean getInverted() {
		// TODO Auto-generated method stub
		return this.motor.getInverted();
	}
	
	@Override
	public void setInverted(boolean isInverted) {
		this.motor.setInverted(isInverted);
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		this.motor.disable();
	}

	@Override
	public void stopMotor() {
		// TODO Auto-generated method stub
		this.motor.stopMotor();
	}
}
