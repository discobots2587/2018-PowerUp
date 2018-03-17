package org.discobots.powerup.lib;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class AXISButton extends Button {
	
	Joystick js;
	double triggerValue;
	boolean greaterThan;
	int port;
	
	public AXISButton(Joystick js, int port, double tValue, boolean gThan) {
		this.port = port;
		this.js = js;
		this.triggerValue = tValue;
		this.greaterThan = gThan;
	}
	
	public AXISButton(Joystick js, int port, double tValue) {
		this(js,port,tValue,true);
	}
	
	public AXISButton(Joystick js, int port) {
		this(js,port,1,true);
	}
	
	@Override
	public boolean get() {
		if(greaterThan)
			return (Math.abs(js.getRawAxis(port))>=triggerValue);
		else
			return (Math.abs(js.getRawAxis(port))<=triggerValue);
	}
	

}
