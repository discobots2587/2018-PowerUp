package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.buttons.Button;

public class DPADButton extends Button {

	Gamepad gp;
	POV pov;
	
	public enum POV {
		UP(0), DOWN(180), RIGHT(90), LEFT(270);
		
		private final double val;
		
		private POV(double val) {
			this.val = val;
		}
	}
	
	public DPADButton(Gamepad gp, POV pov) {
		this.gp = gp;
		this.pov = pov;
	}
	
	@Override
	public boolean get() {
		double val = gp.getDPAD();
		if(val == this.pov.val) {
			Debugger.getInstance().log("DPAD" + val);
			return true;
		}
		return false;
	}

}
