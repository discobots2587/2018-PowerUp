package org.discobots.powerup.subsystems;

import org.discobots.powerup.Robot;
import org.discobots.powerup.utils.Debugger;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Electrical extends Subsystem {

	private PowerDistributionPanel pdp;
	private PDPChannel[] pdpCurrents;
	
	public Electrical() {
		initPDP();
	}
	
	private void initPDP() {
		pdp = new PowerDistributionPanel();
		
		pdpCurrents = new PDPChannel[8];
		pdpCurrents[0] = new PDPChannel(0, Robot.drive.m_left, "Drivetrain", 100);
		pdpCurrents[1] = new PDPChannel(1, Robot.drive.m_left, "Drivetrain", 100);
		pdpCurrents[2] = new PDPChannel(13, Robot.drive.m_right, "Drivetrain", 100);
		pdpCurrents[3] = new PDPChannel(14, Robot.drive.m_right, "Drivetrain", 100);
		pdpCurrents[4] = new PDPChannel(2, Robot.arm.armMotor, "Arm", 100);
		pdpCurrents[5] = new PDPChannel(7, Robot.drive.m_left, "Drivetrain", 100);
		pdpCurrents[6] = new PDPChannel(8, Robot.intake.leftIntake, "Intake", 100);
		pdpCurrents[7] = new PDPChannel(9, Robot.intake.rightIntake, "Intake", 100);
	}
	
	public double getPDPTotalCurrent() {
		return pdp.getTotalCurrent();
	}
	
	public void preventMotorBurnout() {
		for(PDPChannel channel : pdpCurrents) {
			if(channel != null) {
				if(pdp.getCurrent(channel.getChannel()) >= channel.getMaxCurrent()) {
					channel.getMotor().set(0.0);
					Debugger.getInstance().log(channel.getMotorName() + ": Automatic motor shutdown due to pulling too much current", "Electrical");
				}
			}
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	private class PDPChannel {
		
		private int pdpChannel;
		private PWMSpeedController motor;
		private String motorName;
		private double maxCurrent;
		
		public PDPChannel(int channel, PWMSpeedController m, String mN, double mC) {
			pdpChannel = channel;
			motor = m;
			motorName = mN;
			maxCurrent = mC;
		}
		
		public int getChannel() {
			return pdpChannel;
		}
		
		public PWMSpeedController getMotor() {
			return motor;
		}
		
		public String getMotorName() {
			return motorName;
		}
		
		public double getMaxCurrent() {
			return maxCurrent;
		}
	}

}
