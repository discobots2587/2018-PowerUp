package org.discobots.powerup.lib;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.SpeedController;

//rampedMotor, which is based pretty heavily on FRC-pdr's ramped motor wrapper
public class RampedMotor implements SpeedController {
	private PWMSpeedController motor;
	private double previousOutput = 0;
	private double rampBand;
	private double scaleConstant;
	
	public RampedMotor(PWMSpeedController m, double rb) {
		this(m,rb,1);
	}
	
	public RampedMotor(PWMSpeedController m, double rb, double sc) {
		motor = m;
		rampBand = rb;
		scaleConstant = sc;
	}
	
	public double getRampband() {
		return this.rampBand;
	}
	
	public void setRampband(double rb) {
		this.rampBand = rb;
	}
	
	public double getScaleConstant() {
		return this.scaleConstant;
	}
	
	public void getScaleConstant(double sc) {
		this.scaleConstant = sc;
	}
	
	public void pidWrite(double input) {
		this.set(input);
	}
	
	public void set(double input) {		
		double result = 0.0;
		
		//if the change is larger than rampBand (also if the robot is speeding up and not slowing down)
		if((Math.abs(input-previousOutput)>this.rampBand)&&!(Math.abs(input)<Math.abs(previousOutput))) {
			//only change it by rampBand
			result = previousOutput+(Math.copySign(rampBand, input-previousOutput));
		} else {
			//if not, just set it to the input
			result = input;
		}
		motor.set(result*this.scaleConstant);
		this.previousOutput = result*this.scaleConstant;
	}

	@Override
	public double get() {
		return this.motor.get();
	}

	@Override
	public boolean getInverted() {
		return this.motor.getInverted();
	}
	
	@Override
	public void setInverted(boolean isInverted) {
		this.motor.setInverted(isInverted);
	}

	@Override
	public void disable() {
		this.motor.disable();
	}

	@Override
	public void stopMotor() {
		this.motor.stopMotor();
	}
}
