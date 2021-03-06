package org.discobots.powerup.commands.autonomous.subcommands;
 
import org.discobots.powerup.Robot;
import org.discobots.powerup.lib.DummyPIDOutput;
import org.discobots.powerup.lib.PIDSourceGyro;
import org.discobots.powerup.utils.Debugger;
 
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
 
public class ArcadeGyroTurn extends Command {
 
  private double turningThreshold;
  private double turningSetpoint;
 
  private DummyPIDOutput turningGyroPIDOutput;
  private PIDController turningGyroPID;
  private PIDSourceGyro turningGyroPIDSource;
  
  private double kP;
  private double kI;
  private double kD;
  private double preError;
  private double error;
  double integral;
  boolean right;
  
  public ArcadeGyroTurn(double turningSetpoint, double turningThreshold, double kP, double kI, double kD, boolean right) {
    this(turningSetpoint, turningThreshold, kP, kI, kD, 50.0, right);
  }
  
  public ArcadeGyroTurn(double turningSetpoint, double turningThreshold, double kP, double kI, double kD, double period) {
    this(turningSetpoint, turningThreshold, kP, kI, kD, period, false);
  }
  
  public ArcadeGyroTurn(double turningSetpoint, double turningThreshold, double kP, double kI, double kD, double period, boolean right) {
    if(right) {
      this.turningSetpoint = Robot.drive.getYaw()+turningSetpoint;
    } else {
      this.turningSetpoint = Robot.drive.getYaw()-turningSetpoint;
    }
    this.right = right;
    turningGyroPIDOutput = new DummyPIDOutput();
    turningGyroPIDSource =  new PIDSourceGyro();
    turningGyroPID = new PIDController(kP, kI, kD, turningGyroPIDSource, turningGyroPIDOutput, period);
    turningGyroPID.setOutputRange(-0.7, 0.7);
    this.error = 0.0;
    this.kP = kP;
    this.kI = kI;
    this.kD = kD;
    this.integral = 0;
    this.preError = 0;
    
  }
  
  @Override
  protected void initialize() {
    turningGyroPID.enable();
    turningGyroPID.setSetpoint(turningSetpoint);
  }
  
  @Override
  protected void execute() {
    error = Math.abs(turningSetpoint - Robot.drive.getYaw());
    
    this.integral = this.integral + (error * 0.004);
       // determine the amount of change from the last time checked
      double derivative = (error - preError) / 0.004; 
       // calculate how much to drive the output in order to get to the 
       // desired setpoint. 
    double output = (this.kP * error) + (this.kI * integral) + (this.kD * derivative);
       // remember the error for the next time around.
    preError = error; 
    
    /*if(output > 0.5) {
    	output = 0.5;
    } else if (output < -0.5) {
    	output = -0.5;
    }*/
    
    if(right)
    	Robot.drive.arcadeDrive(0, output);
    else
    	Robot.drive.arcadeDrive(0, -output);
    
    Debugger.getInstance().log("PID output: " + output, "PID-OUTPUT");
    Debugger.getInstance().log("Error TURNING: " + turningGyroPID.getError(), "PID-ERROR");
    Debugger.getInstance().log("Current Heading " + Robot.drive.getYaw(), "YAW");
    Debugger.getInstance().log("Setpoint: "  + turningSetpoint, "PID-SETPOINT");
  }
  
  @Override
  protected boolean isFinished() {
    // TODO Auto-generated method stub
    return   (turningGyroPID.getError() < Math.abs(turningThreshold));
  }
  
  // Called once after isFinished returns true
  @Override
  protected void end() {
    turningGyroPID.disable();
    Robot.drive.arcadeDrive(0, 0);
  }
    
  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
 
}