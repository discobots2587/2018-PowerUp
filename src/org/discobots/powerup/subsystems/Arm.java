package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends PIDSubsystem {
	
	public AnalogPotentiometer armPot = new AnalogPotentiometer(HW.potentiometer,-360,236);
	
	public Spark armMotor = new Spark(HW.armMotor);
	
	public DigitalInput switch_bottom = new DigitalInput(HW.arm_switch_bottom);
	
	private int index = 0;
	
	public Arm() {
		super("Arm",2,0,0);
		setAbsoluteTolerance(0.05);
		disable();
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void setPos(int pos) {
		switch(pos) {
		case 0:
			//intake parallel to ground
			this.setSetpoint(80);
			break;
		case 1:
			//intake ready to unload to switch
			this.setSetpoint(60);
			break;
		case 2:
			//intake holding cube above catapult
			this.setSetpoint(0);
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
