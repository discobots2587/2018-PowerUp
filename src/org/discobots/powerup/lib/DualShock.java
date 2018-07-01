package org.discobots.powerup.lib;

public class DualShock extends Gamepad {

	public DualShock() {
		super(DEFAULT_USB_PORT);
	}
	
	public DualShock(int port) {
		super(port);
	}
	
	public DualShock(int port, String name) {
		super(port, name);
	}
}
