// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
  // Motors
  WPI_TalonSRX leftFront;
  WPI_TalonSRX rightFront;
  WPI_TalonSRX leftRear;
  WPI_TalonSRX rightRear;

  // Controllers
  SpeedControllerGroup rightSide;
  SpeedControllerGroup leftSide;

  // Drives
  DifferentialDrive drive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // Setup each of the motors for use later
    // Going to set any whole game settings here as well (like motor inversion)
    leftFront = new WPI_TalonSRX(Constants.leftFrontCanID);
    leftFront.setInverted(Constants.inversion);

    rightFront = new WPI_TalonSRX(Constants.rightFrontCanID);
    rightFront.setInverted(Constants.inversion);

    leftRear = new WPI_TalonSRX(Constants.leftRearCanID);
    leftRear.setInverted(Constants.inversion);

    rightRear = new WPI_TalonSRX(Constants.rightRearCanID);
    rightRear.setInverted(Constants.inversion);

    // create the speed controller groups for use in the differential drive
    // each one should be a pairing of the motors on a given side of the robot
    rightSide = new SpeedControllerGroup(rightFront, rightRear);
    leftSide = new SpeedControllerGroup(leftFront, leftRear);

    // create the drive object that will control the differential drive
    // It needs both a set of left and right motors
    // file:///C:/Users/Public/wpilib/2021/documentation/java/edu/wpi/first/wpilibj/drive/DifferentialDrive.html
    drive = new DifferentialDrive(rightSide, leftSide);

  }

  @Override
  public void periodic() {
    
  }

  // Method to control the drive with the controller
  // controller = Input controller
  // speedLimiter = value to limit the speed of the motors
  // if else statement to swap between arcade and tank
  public void driveWithController(XboxController controller, double speedLimiter) {
    drive.tankDrive(controller.getRawAxis(Constants.rightTankAxis) * speedLimiter * -1,
       controller.getRawAxis(Constants.leftTankAxis) * speedLimiter * -1);

}
  // Method to just stop the drive
  public void stopDriveTrain() {
    drive.stopMotor();
  }
}