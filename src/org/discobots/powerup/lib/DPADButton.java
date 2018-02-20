package org.discobots.powerup.lib;

import org.discobots.powerup.utils.Debugger;

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
		double val = this.pov.val;
		double currentVal = gp.getDPAD();
		if(currentVal == val) {
			Debugger.getInstance().log("POV Current Value: )" + currentVal + " value: " + val, "Gamepad");
			return true;
		}
		return false;
	}

}
