package org.discobots.powerup.lib;

import org.discobots.powerup.Robot;
import org.discobots.powerup.Robot.position;

import com.ctre.phoenix.sensors.PigeonIMU;

public class RobotCoordinate2D extends Coordinate2D {

	private Coordinate2D robot_tl; //robot top left corner
	private Coordinate2D robot_tr; //robot top right corner
	private Coordinate2D robot_bl; //robot bottom left corner
	private Coordinate2D robot_br; //robot bottom right corner
	
	private double length;
	private double width;
	
	private double x; //x position of gyro
	private double y; //y position of gyro
	
	/*
	 * Speed, Velocity, Acceleration, Rotation
	 */
	private double xSpd;
	private double ySpd;
	private double xVelo;
	private double yVelo;
	private double xAcel;
	private double yAcel;
	private double zRot;
	
	public RobotCoordinate2D(position pos) {
		switch(pos) {
			case LEFT:
				this.x = 1;
				this.y = 1;
				break;
			case CENTER:
				this.x = 1;
				this.y = 1;
				break;
			case RIGHT:
				this.x = 1;
				this.y = 1;
				break;
		}
		this.setX(x);
		this.setY(y);
		robot_tl = new Coordinate2D(x - width/2, y + length/2);
		robot_tr = new Coordinate2D(x + width/2, y + length/2);
	}
	
	public void updatePosition() {
		//Robot.drive.gyro_xyz;
		//Robot.drive.accel_xyz;
		//Robot.drive.ypr;
	}
	
	public boolean isPartiallyInNullZone() {
		return this.isInNullZone() || robot_tl.isInNullZone() || robot_tr.isInNullZone() || robot_bl.isInNullZone() || robot_br.isInNullZone();
	}
	
	public boolean isFullyInNullZone() {
		return robot_tl.isInNullZone() && robot_tr.isInNullZone() && robot_bl.isInNullZone() && robot_br.isInNullZone();
	}
	
	public boolean isPartiallyInLeftPortal() {
		return this.isInLeftPortal() || robot_tl.isInLeftPortal() || robot_tr.isInLeftPortal() || robot_bl.isInLeftPortal() || robot_br.isInLeftPortal();
	}
	
	public boolean isPartiallyInRightPortal() {
		return this.isInRightPortal() || robot_tl.isInRightPortal() || robot_tr.isInRightPortal() || robot_bl.isInRightPortal() || robot_br.isInRightPortal();
	}
	
	public boolean isPartiallyInAnyPortal() {
		return this.isPartiallyInLeftPortal() || this.isPartiallyInRightPortal();
	}
	
	public boolean isFullyInLeftPortal() {
		return robot_tl.isInLeftPortal() && robot_tr.isInLeftPortal() && robot_bl.isInLeftPortal() && robot_br.isInLeftPortal();
	}
	
	public boolean isFullyInRightPortal() {
		return robot_tl.isInRightPortal() && robot_tr.isInRightPortal() && robot_bl.isInRightPortal() && robot_br.isInRightPortal();
	}
	
	public boolean isFullyInAnyPortal() {
		return this.isFullyInLeftPortal() || this.isFullyInRightPortal();
	}
	
	public boolean isPartiallyInExchange() {
		return robot_tl.isInExchange() || robot_tr.isInExchange() || robot_bl.isInExchange() || robot_br.isInExchange();
	}
	
	public boolean isFullyInExchange() {
		return robot_tl.isInExchange() && robot_tr.isInExchange() && robot_bl.isInExchange() && robot_br.isInExchange();
	}
}