package org.discobots.powerup.subsystems;

import org.discobots.powerup.HW;
import org.discobots.powerup.lib.RampedMotor;
import org.discobots.powerup.utils.Constants;
import org.discobots.powerup.utils.Debugger;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.sensors.PigeonIMU;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive; //west coast / tank

public class Drivetrain extends Subsystem {

	public DifferentialDrive drive;
	
	public DoubleSolenoid gearShifter = new DoubleSolenoid(HW.shifter1, HW.shifter2);
	
	public Spark m_left;
	public Spark m_right;
	
	public RampedMotor leftDrive;
	public RampedMotor rightDrive;
	
	public Encoder m_left_encoder;
	public Encoder m_right_encoder;
	
	public PigeonIMU pigeon;
	public TalonSRX talon_pigeon;

	public double[] gyro_xyz  = new double[3];
	public double[] ypr       = new double[3];
	public double[] accel_xyz = new double[3];
	
	public enum shift {
		OFF,HIGH,LOW;
	}
	
	public Drivetrain() {
		m_left = new Spark(HW.leftDrive);  //set all three left ports to what is configured in the HW
		
		//SpeedControllerGroup left = new SpeedControllerGroup(m_left);
		//left.setInverted(true);
		leftDrive = new RampedMotor(m_left,Constants.kRampband);
		leftDrive.setInverted(true);

		m_right = new Spark(HW.rightDrive);  //set all three right ports to what is configured in the HW
		
		//SpeedControllerGroup right = new SpeedControllerGroup(m_right);
		//right.setInverted(true);
		rightDrive = new RampedMotor(m_right,Constants.kRampband);
		rightDrive.setInverted(true);
		
		//drive = new DifferentialDrive(left, right);
		drive = new DifferentialDrive(leftDrive, rightDrive);
		
		drive.setDeadband(Constants.kDeadband);
		
		m_left_encoder = new Encoder(HW.left_encoder1, HW.left_encoder2, false, CounterBase.EncodingType.k4X);
		m_right_encoder = new Encoder(HW.right_encoder1, HW.right_encoder2, true, CounterBase.EncodingType.k4X);
		
		m_left_encoder.setDistancePerPulse(Constants.kInchPerTick);
		m_right_encoder.setDistancePerPulse(Constants.kInchPerTick);
		
		talon_pigeon = new TalonSRX(HW.talonsrx_pigeon);
		pigeon = new PigeonIMU(talon_pigeon);
		
		PigeonIMU.GeneralStatus genStatus = new PigeonIMU.GeneralStatus();
		pigeon.getGeneralStatus(genStatus);
		Debugger.getInstance().log(genStatus.toString(), "Pigeon IMU");
		
		drive.setExpiration(0.5);
	}
	
	public void initDefaultCommand() {
	}
	
	public void teleopInit() {
		m_left_encoder.reset();
		m_right_encoder.reset();
	}
	
	public void arcadeDrive(double xSpeed, double zRotation) { //contrary to the documentation, but that is ok
		drive.arcadeDrive(xSpeed, zRotation, true); //forward, clockwise = positive; decrease sensitivity at low speed is TRUE
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right, true); //forward = positive; decrease sensitivity at low speed is TRUE
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
	
	public double getYaw() {
        pigeon.getYawPitchRoll(ypr);
        return -ypr[0];
    }
}
