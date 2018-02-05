// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc746.Robot7462018.subsystems;

import org.usfirst.frc746.Robot7462018.RobotMap;
import org.usfirst.frc746.Robot7462018.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


/**
 *
 */
public class DriveTrain extends Subsystem {

	 	private final SpeedController talonLeft1 = RobotMap.driveTraintalonLeft1;
	    private final SpeedController talonLeft2 = RobotMap.driveTraintalonLeft2;
	    private final SpeedControllerGroup leftMotors = RobotMap.driveTrainleftMotors;
	    private final SpeedController talonRight1 = RobotMap.driveTraintalonRight1;
	    private final SpeedController talonRight2 = RobotMap.driveTraintalonRight2;
	    private final SpeedControllerGroup rightMotors = RobotMap.driveTrainrightMotors;
	    private final DifferentialDrive drive1 = RobotMap.driveTrainDifferentialDrive1;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new tankDrive());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    

	public void stop() {
		drive1.curvatureDrive(0, 0, false);
	}
	
	public void getArcadeDrive(double throttle, double twist, boolean squared) {
		drive1.arcadeDrive(throttle, twist, true);
	}
	
	public void ArcadeDrive(Joystick driver) {
		getArcadeDrive(-driver.getAxis(AxisType.kThrottle), -driver.getAxis(AxisType.kTwist), true);
	}

	public void driveStraight(double throttle) {
		drive1.arcadeDrive(throttle, 0);

	}
	
	public void setTankDrive(double leftSide, double rightSide, boolean squared) {
		drive1.tankDrive(leftSide, rightSide, squared);
	}
		

	public void drive(Joystick driver) {
		setTankDrive(-driver.getY(), -driver.getAxis(AxisType.kThrottle), true);
	}
}

