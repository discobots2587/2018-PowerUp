package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Gamepad extends Joystick {
	
	public Gamepad(int port) {
		super(port);
	}
}
