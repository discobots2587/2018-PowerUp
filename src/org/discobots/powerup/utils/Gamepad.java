package org.discobots.powerup.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.discobots.powerup.utils.Constants;

public class Gamepad extends Joystick {

	public static String name = "genericHID";
	
	public static int AXIS_LX = 0;
	public static int AXIS_LY = 1;
	public static int AXIS_RX = 2;
	public static int AXIS_RY = 3;
	
	public static int DPAD_X = 4;
	public static int DPAD_Y = 5;
	
	public static int BTN_X = 1;
	public static int BTN_A = 2;
	public static int BTN_B = 3;
	public static int BTN_Y = 4;

	public static int BTN_LB = 5;
	public static int BTN_LT = 7;
	public static int BTN_RB = 6;
	public static int BTN_RT = 8;

	public static int BTN_BACK = 9;
	public static int BTN_START = 10;

	public static int AXISBTN_L = 11;
	public static int AXISBTN_R = 12;
	
	private static final int DEFAULT_USB_PORT = 1;
	
	public Gamepad() {
		super(DEFAULT_USB_PORT);
	}
	
	public Gamepad(int port) {
		super(port);
	}
	
	public Gamepad(int port, String name) {
		super(port);
		this.name = name;
	}
	
	public double getLX() {
		double val = this.getRawAxis(AXIS_LX);
		if(Math.abs(val) <= Constants.kDeadband) {
			return 0.0;
		}
		return val;
	}

	public double getLY() {
		double val = this.getRawAxis(AXIS_LY) * -1;
		if(Math.abs(val) <= Constants.kDeadband) {
			return 0.0;
		}
		return val;
	}

	public double getRX() {
		double val = this.getRawAxis(AXIS_RX);
		if(Math.abs(val) <= Constants.kDeadband) {
			return 0.0;
		}
		return val;
	}

	public double getRY() {
		double val = this.getRawAxis(AXIS_RY) * -1;
		if(Math.abs(val) <= Constants.kDeadband) {
			return 0.0;
		}
		return val;
	}

	public double getDX() {
		return this.getRawAxis(DPAD_X);
	}

	public double getDY() {
		return this.getRawAxis(DPAD_Y) * -1;
	}
	
	public double getDPAD() {
		double val = this.getPOV();
		if(45 <= val && val < 135) {
			val = 90;
		} else if(135 <= val && val < 225) {
			val = 180;
		} else if(225 <= val && val < 315) {
			val = 270;
		} else {
			val = 0;
		}
		return val;
	}
}
