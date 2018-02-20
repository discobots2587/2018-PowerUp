package org.discobots.powerup.lib.map;

public class Coordinate2D {

	//EVERYTHING IS IN INCHES
	
	private double x;
	private double y;
	
	/*
	 * Field
	 */
	
	/*
	 * 0, 0 is center of field
	 * anything left and down is negative
	 * anything right and up is negative
	 * compare down to up
	 * compare left to right
	 */
	
	// Field Dimensions 360 x 648 on diagram
	private double xMin = -162.86;
	private double xMax = 162.86;
	private double yMin = -324.0;
	private double yMax = 324.0;
	
	private double startingLine = -204.0;
	
	private double switch_xStart = -77.61;
	private double switch_xEnd   = 77.61;
	private double nearSwitch_yStart = -184;
	private double nearSwitch_yEnd   = -128;
	private double farSwitch_yStart  = 128;
	private double farSwitch_yEnd    = 184;
	
	private double nullZone_yStart = -36.0;
	private double nullZone_yEnd   = 36.0; 
	private double nullZone_xLeft  = -91.26;
	private double nullZone_xRight = 91.26;
	
	private double portal_xLeft  = -133.17;
	private double portal_xRight = 133.17;
	private double portal_y      = 289.0;
	
	private double exchange_xStart = 12.0;
	private double exchange_xEnd   = 60.0;
	private double exchange_y      = 288.0;
	
	public Coordinate2D() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public Coordinate2D(double x, double y) {
		this.x = (double) x;
		this.y = (double) y;
	}
	
	public double getX() {
		return this.x;
	}
	
	public double getY() {
		return this.y;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public boolean isInNearSwitch() {
		if(y >= nearSwitch_yStart && y <= nearSwitch_yEnd) {
			if(y >= switch_xStart && x <= switch_xEnd) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInFarSwitch() {
		if(y >= farSwitch_yStart && y <= farSwitch_yEnd) {
			if(y >= switch_xStart && x <= switch_xEnd) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInAnySwitch() {
		return isInNearSwitch() || isInFarSwitch();
	}
	
	public boolean isInNullZone() {
		if(y > nullZone_yStart && y < nullZone_yEnd) {
			if((x > xMin && x < nullZone_xLeft) || (x > nullZone_xRight && x < xMax)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInLeftPortal() {
		if(y > portal_y && y < yMax) {
			if(x > xMin && x < portal_xLeft) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInRightPortal() {
		if(y > portal_y && y < yMax) {
			if(x > portal_xRight && x < xMax) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInAnyPortal() {
		return isInLeftPortal() || isInRightPortal();
	}
	
	public boolean isInExchange() {
		if(y > exchange_y && y < yMax) {
			if(x > exchange_xStart && x < exchange_xEnd) {
				return true;
			}
		}
		return false;
	}
	
}
