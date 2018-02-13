package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.buttons.Button;

public class DPADButton extends Button {

	Gamepad gp;
	double pov;
	
	public DPADButton(Gamepad gp, double pov) {
		this.gp = gp;
		this.pov = pov;
	}
	
	@Override
	public boolean get() {
		double val = gp.getDPAD();
		if(val == this.pov) {
			Debugger.getInstance().log("DPAD" + val);
			return true;
		}
		return false;
	}

}
