package org.discobots.powerup.lib;

import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class DPADButton extends Button {

	Joystick js;
	POV pov;
	boolean locked;
	
	public enum POV {
		UP(0), DOWN(180), RIGHT(90), LEFT(270), UP_RIGHT(45), DOWN_RIGHT(135), DOWN_LEFT(225), UP_LEFT(315);
		
		private final double val;
		
		private POV(double val) {
			this.val = val;
		}
	}
	
	public DPADButton(Joystick js, POV pov) {
		this(js,pov,true);
	}
	
	public DPADButton(Joystick js, POV pov, boolean locked) {
		this.js = js;
		this.pov = pov;
		
	}
	
	@Override
	public boolean get() {
		double val = this.pov.val;
		double currentVal = js.getPOV();
		if(this.locked)
			currentVal = Gamepad.getDPADfromPOV(currentVal);
		if(currentVal == val) {
			return true;
		}
		return false;
	}

}
