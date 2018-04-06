package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Arm extends PIDSubsystem {
	
	//scale factor for everything in the PID - higher values make for faster and less accurate
	public double scaleFactor = 50;
	
	public AnalogPotentiometer armPot = new AnalogPotentiometer(HW.potentiometer,scaleFactor);
	
	public double zeroPoint = 0;
	
	public Spark armMotor = new Spark(HW.armMotor);

	public DigitalInput switch_top    = new DigitalInput(HW.arm_switch_top);
	public DigitalInput switch_bottom = new DigitalInput(HW.arm_switch_bottom);
	
	private int index = 0;
	
	public double output = 0;
	
	public double target = 0;
	
	public Arm() {
		super("Arm",1,0,0.01);
		this.getPIDController().setOutputRange(-.75,.75);
		setAbsoluteTolerance(0.01*scaleFactor);
		armMotor.setInverted(true);
	}
	
	public void init() {
		this.index = 2;
		zeroPoint = armPot.get();
		this.setPos(index);
		this.enable();
		//this.disable();
	}
	
	public double getPos() {
		return armPot.get()-zeroPoint;
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setPos(int pos) {
		switch(pos) {
		case 0:
			//intake parallel to ground
			this.setSetpoint(zeroPoint+0.25*scaleFactor);
			this.target = (zeroPoint+0.25*scaleFactor);
			break;
		case 1:
			//intake ready to unload to switch
			this.setSetpoint(zeroPoint+.055*scaleFactor);
			this.target = (zeroPoint+.055*scaleFactor);
			break;
		case 2:
			//intake holding cube above catapult
			this.setSetpoint(zeroPoint+0.02*scaleFactor);
			this.target = (zeroPoint+0.02*scaleFactor);
			break;
		default:
			this.setSetpoint(0);
			break;
		}
		this.index = pos;
	}
	
	public void up() {
		index = Math.min(++index, 2);
		setPos(index);
	}
	
	public void down() {
		index = Math.max(--index, 0);
		setPos(index);
	}
	
	public double returnPIDInput() {
		return armPot.get();
	}
	
	public void usePIDOutput(double output) {
		this.set(output);
		this.output = output;
	}
	
	public void set(double output) {
		/*if(!switch_top.get()) {
			armMotor.set(Math.min(output, 0));
		} else {
			armMotor.set(output);
		}*/
		armMotor.set(output);
		this.output = output;
	}
	
	public int index() {
		return this.index;
	}
	
	public void setIndex(int input) {
		this.index = input;
		this.setPos(this.index);
	}
}
