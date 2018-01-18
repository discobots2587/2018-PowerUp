package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Gamepad extends Joystick {
	
	private static final int DEFAULT_USB_PORT = 1;
	
	public Gamepad() {
		super(DEFAULT_USB_PORT);
	}
	
	public Gamepad(int port) {
		super(port);
	}
}
