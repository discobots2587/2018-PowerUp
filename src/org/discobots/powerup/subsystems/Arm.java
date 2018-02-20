package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends PIDSubsystem {
	
	public AnalogPotentiometer armPot = new AnalogPotentiometer(HW.potentiometer,10);
	
	public double zeroPoint = 0;
	
	public Spark armMotor = new Spark(HW.armMotor);
	
	public DigitalInput switch_bottom = new DigitalInput(HW.arm_switch_bottom);
	
	private int index = 0;
	
	public double output = 0;
	
	public double target = 0;
	
	public Arm() {
		super("Arm",1,0,0);
		this.getPIDController().setOutputRange(-0.7,0.7);
		setAbsoluteTolerance(0.05);
		armMotor.setInverted(true);
		
		this.index = 0;
		zeroPoint = armPot.get();
		this.setPos(index);
		this.enable();
	}
	
	public void teleopInit() {
		this.index = 0;
		zeroPoint = armPot.get();
		this.setPos(index);
		this.enable();
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
			this.setSetpoint(zeroPoint);
			this.target = (zeroPoint);
			break;
		case 1:
			//intake ready to unload to switch
			this.setSetpoint(zeroPoint-.57);
			this.target = (zeroPoint-.57);
			break;
		case 2:
			//intake holding cube above catapult
			this.setSetpoint(zeroPoint-2.45);
			this.target = (zeroPoint-2.45);
			break;
		default:
			this.setSetpoint(0);
			break;
		}
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
		//this.output = output;
	}
	
	public void set(double output) {
		/*if(switch_bottom.get()) {
			armMotor.set(0.0);
		} else {
			armMotor.set(output);
		}*/
		armMotor.set(output);
	}
}
