package org.discobots.powerup.lib.map;

public class Path {

	private Coordinate2D start;
	private Coordinate2D end;
	private double rotation;
	
	public Path(Coordinate2D start, Coordinate2D end, double zRotation) {
		this.start = start;
		this.end = end;
		this.rotation = zRotation;
	}
	
	public void getPath() {
	}
	
	public boolean getLinearPath() {
		double slope = (end.getY() - start.getY())/(end.getX() - start.getX());
		Coordinate2D test;
			
		return false;
	}
	
	public void getCircularpath() {
		
	}
	
	public void getQuadraticPath() {
		
	}
	
}
