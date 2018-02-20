package org.discobots.powerup.lib;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class TurningEncoderPIDSource implements PIDSource {

	private Encoder left;
	private Encoder right;
	
	public TurningEncoderPIDSource(Encoder left, Encoder right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double pidGet() {
		// TODO Auto-generated method stub
		return 0;
	}

}
