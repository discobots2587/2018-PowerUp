package org.discobots.powerup;

import java.text.DecimalFormat;

import org.discobots.powerup.commands.ArcadeDrive;
import org.discobots.powerup.commands.CurvatureDrive;
import org.discobots.powerup.commands.TankDrive;
import org.discobots.powerup.commands.autonomous.Nothing;
import org.discobots.powerup.commands.autonomous.encoder.EncoderCrossLine;
import org.discobots.powerup.commands.autonomous.gyro.GyroChooser;
import org.discobots.powerup.commands.autonomous.gyro.GyroCrossLine;
import org.discobots.powerup.commands.autonomous.encoder.EncoderChooser;
import org.discobots.powerup.commands.autonomous.timed.TimedChooser;
import org.discobots.powerup.utils.Constants;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard {
	
	private static final double SHORT_DELAY = 0.1;
	private static final double LONG_DELAY = 0.5;
	
	private static double shortTime = 0.0;
	private static double longTime = 0.0;
	
	public static SendableChooser<Command> autonChooser = new SendableChooser<>();
	public static SendableChooser<Robot.position> positionChooser = new SendableChooser<>();
	
	public static SendableChooser<Command> driveChooser = new SendableChooser<>();
	
	public static void init() {
		positionChooser.addDefault("Left", Robot.position.LEFT);
		positionChooser.addObject("Center", Robot.position.CENTER);
		positionChooser.addObject("Right", Robot.position.RIGHT);
		
		autonChooser.addDefault("Nothing", new Nothing());
		autonChooser.addObject("Dead Reckoning", new TimedChooser());
		autonChooser.addObject("Cross Line Only (Encoder)", new EncoderCrossLine());
		autonChooser.addObject("Encoder Switch/Scale", new EncoderChooser());
		autonChooser.addObject("Cross Line Only (Gyro)", new GyroCrossLine());
		autonChooser.addObject("Gyro+Encoder Switch/Scale", new GyroChooser());
		
		driveChooser.addDefault("Arcade Drive", new ArcadeDrive());
		driveChooser.addObject("Tank Drive", new TankDrive());
		driveChooser.addObject("Cheesy Drive", new CurvatureDrive());
		
		SmartDashboard.putData("Position", positionChooser);
		SmartDashboard.putData("Autonomous", autonChooser);
		SmartDashboard.putData("Drive", driveChooser);
	}
	
	public static void autoInit() {
		for(int k = 0; k < 6; k++) {
			SmartDashboard.putBoolean(k+"", Autonomous.scoreSide[k]);
		}

		//TO-DO
		/*DriverStation.Alliance color = DriverStation.getInstance().getAlliance();
		if(color.equals(DriverStation.Alliance.Blue)) {
			
		} else if(color.equals(DriverStation.Alliance.Blue)) {
			for(int k = 0; k < 6; k++)
				SmartDashboard.putBoolean(k+"", !Autonomous.scoreSide[k]);
		}*/
	}
	
	//Short & Long dashboard update based of off 3847's dashboard
	public static void update() {
		if((Timer.getFPGATimestamp() - shortTime) > SHORT_DELAY) {
			shortTime = Timer.getFPGATimestamp();
			updateShort();
		}
		if((Timer.getFPGATimestamp() - longTime) > LONG_DELAY) {
			longTime = Timer.getFPGATimestamp();
			updateLong();
		}
	}
	
	
	public static void updateShort() {
		SmartDashboard.putBoolean("Launcher Ready?", !(Robot.launcher.checkOnCooldown()||Robot.launcher.anyActivated()));
		//SmartDashboard.putNumber("Supply PSI", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.supplyPressure))));
		SmartDashboard.putNumber("Pressure", Double.parseDouble(new DecimalFormat("###.##").format(Robot.launcher.getPressure(Robot.launcher.pressureSensor))));
	}
	
	public static void updateLong() {
		//SmartDashboard.putString("Time Left", (Timer.getMatchTime() >= 0.0) ? Utils.secToMinAndSec(Timer.getMatchTime()) : "-1");
		
		SmartDashboard.putNumber("Seconds Left", Timer.getMatchTime());
		
		SmartDashboard.putNumber("Switch Delay", Constants.kSwitchWait);
		SmartDashboard.putNumber("Scale Delay", Constants.kScaleWait);
		
		SmartDashboard.putNumber("Yaw", Robot.drive.getYaw());
		SmartDashboard.putNumber("Pitch",Robot.drive.ypr[1]);
		SmartDashboard.putNumber("Roll", Robot.drive.ypr[2]);
		
		SmartDashboard.putNumber("Ultrasonic Distance", Robot.intake.ultrasonic.getRangeInches());
		
		SmartDashboard.putNumber("Potentiometer Value", Robot.arm.getPos());
		
		SmartDashboard.putNumber("Left Encoder Value", Robot.drive.m_left_encoder.getDistance());
		SmartDashboard.putNumber("Right Encoder Value", Robot.drive.m_right_encoder.getDistance());
		
		SmartDashboard.putBoolean("Arm PID Enabled?", Robot.arm.getPIDController().isEnabled());
		
		
		SmartDashboard.putBoolean("ArmPos 0", (Robot.arm.index() == 0));
		SmartDashboard.putBoolean("ArmPos 1", (Robot.arm.index() == 1));
		SmartDashboard.putBoolean("ArmPos 2", (Robot.arm.index() == 2));
		SmartDashboard.putNumber("PID arm",Robot.arm.output);
		//SmartDashboard.putNumber("Zeropoint", Robot.arm.zeroPoint);
		//SmartDashboard.putNumber("Potentiometer TRUE value", Robot.arm.armPot.get());
		//SmartDashboard.putNumber("Target", Robot.arm.target);
		
		
		SmartDashboard.putBoolean("Arm at Top?",Robot.arm.switch_top.get());
	}
}

