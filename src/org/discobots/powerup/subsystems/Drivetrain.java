package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;
import org.discobots.powerup.utils.Constants;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

public class Drivetrain extends PIDSubsystem {

	public DifferentialDrive drive;
	
	public DoubleSolenoid gearShifter = new DoubleSolenoid(HW.shifter1,HW.shifter2);
	
	public Spark m_left;
	public Spark m_right;
	
	public Encoder m_left_encoder;
	public Encoder m_right_encoder;
	
	public PigeonIMU pigeon;
	public TalonSRX talon_pigeon;
	
	public static double kP = 0.1;
	public static double kI = 0;
	public static double kD = 0;
	
	double cp, ci, cd;
	
	public double[] gyro_xyz = new double[3];
	
	public Drivetrain() {
		super(kP, kI, kD);
		m_left = new Spark(HW.leftDrive);  //set all three left ports to what is configured in the HW
		SpeedControllerGroup left = new SpeedControllerGroup(m_left);
		left.setInverted(true);

		m_right = new Spark(HW.rightDrive);  //set all three right ports to what is configured in the HW
		SpeedControllerGroup right = new SpeedControllerGroup(m_right);
		right.setInverted(true);
		
		drive = new DifferentialDrive(left, right);
		
		drive.setDeadband(Constants.kDeadband);
		
		m_left_encoder = new Encoder(HW.left_encoder1, HW.left_encoder2, false, CounterBase.EncodingType.k4X);
		m_right_encoder = new Encoder(HW.right_encoder1, HW.right_encoder2, false, CounterBase.EncodingType.k4X);
		
		m_left_encoder.setDistancePerPulse(Constants.kDistPerTick);
		m_right_encoder.setDistancePerPulse(Constants.kDistPerTick);
		
		talon_pigeon = new TalonSRX(HW.talonsrx_pigeon);
		pigeon = new PigeonIMU(talon_pigeon);
		
	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void arcadeDrive(double xSpeed, double zRotation) { //contrary to the documentation, but that is ok
		drive.arcadeDrive(zRotation, xSpeed, true); //forward, clockwise = positive; decrease sensitivity at low speed is TRUE
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right, true); //forward = positive; decrease sensitivity at low speed is TRUE
	}

	@Override
	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return gyro_xyz[2];
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		m_left.pidWrite(output);
		m_right.pidWrite(output);
	}
	
	public enum shift {
		OFF,HIGH,LOW;
	}
	
	public void shift(Drivetrain.shift s) {
		switch (s) {
		case OFF:
			this.gearShifter.set(DoubleSolenoid.Value.kOff);
			break;
		case HIGH:
			this.gearShifter.set(DoubleSolenoid.Value.kForward);
			break;
		case LOW:
			this.gearShifter.set(DoubleSolenoid.Value.kReverse);
			break;
		default:
			break;
		}
		
	}
}
