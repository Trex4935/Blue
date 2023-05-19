// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Drivetrain extends SubsystemBase {
  // Motors
  WPI_TalonSRX leftFrontA;
  WPI_TalonSRX leftFrontB;
  WPI_TalonSRX leftRearA;
  WPI_TalonSRX leftRearB;
  WPI_TalonSRX rightFrontA;
  WPI_TalonSRX rightFrontB;
  WPI_TalonSRX rightRearA;
  WPI_TalonSRX rightRearB;

  // Controllers
  MotorControllerGroup rightSide;
  MotorControllerGroup leftSide;

  // Drives
  DifferentialDrive drive;

  /** Creates a new Drivetrain. */
  public Drivetrain() {

    // Setup each of the motors for use later
    // Going to set any whole game settings here as well (like motor inversion)
    leftFrontA = new WPI_TalonSRX(Constants.leftFrontA);
    leftFrontA.setInverted(false);

    leftFrontB = new WPI_TalonSRX(Constants.leftFrontB);
    leftFrontB.setInverted(false);

    leftRearA = new WPI_TalonSRX(Constants.leftRearA);
    leftRearA.setInverted(false);

    leftRearB = new WPI_TalonSRX(Constants.leftRearB);
    leftRearB.setInverted(false);

    rightFrontA = new WPI_TalonSRX(Constants.rightFrontA);
    rightFrontA.setInverted(Constants.inversion);

    rightFrontB = new WPI_TalonSRX(Constants.rightFrontB);
    rightFrontB.setInverted(Constants.inversion);

    rightRearA = new WPI_TalonSRX(Constants.rightRearA);
    rightRearA.setInverted(Constants.inversion);

    rightRearB = new WPI_TalonSRX(Constants.rightRearB);
    rightRearB.setInverted(Constants.inversion);
    
    // create the speed controller groups for use in the differential drive
    // each one should be a pairing of the motors on a given side of the robot
    rightSide = new MotorControllerGroup(rightFrontA,rightFrontB,rightRearA,rightRearB);
    leftSide = new MotorControllerGroup(leftFrontA, leftFrontB, leftRearA, leftRearB);
    //rightSide = new MotorControllerGroup(rightFront, rightRear);
    //leftSide = new MotorControllerGroup(leftFront, leftRear);

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