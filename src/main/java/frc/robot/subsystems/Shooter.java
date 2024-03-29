// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Shooter extends SubsystemBase {
  /** Creates a new Shooter. */
  WPI_TalonSRX shooterAim;
  Solenoid shooterSolenoid;
  Solenoid shooterMag;

  public Shooter() {

    shooterAim = new WPI_TalonSRX(Constants.shooterMotor);
    shooterAim.setInverted(Constants.inversion);

    shooterSolenoid = new Solenoid(1, PneumaticsModuleType.CTREPCM, 1);
    shooterMag = new Solenoid(1,PneumaticsModuleType.CTREPCM, 0);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // Move the shooter up
  public void aimShooterUp() {
    shooterAim.set(Constants.aimSpeed);

  }

  // move the shooter down
  public void aimShooterDown() {
    shooterAim.set(-Constants.aimSpeed);
  }

  // stop the aiming motor
  public void aimShooterStop() {
    shooterAim.stopMotor();
  }

  // shoot with delay
  public void pewPew() {
    System.out.println("-- Command Out --");
    // Open Air vavle to shoot ball
    shooterSolenoid.set(true);
    Timer.delay(0.3);
    // Close vavle 
    shooterSolenoid.set(false);
    // Open reload slot
    shooterMag.set(false);
    Timer.delay(0.4);
    // Close reload slot
    shooterMag.set(true);
  }

  public void shooterTrigger() {
    shooterSolenoid.set(true);
  }

  public void shooterTriggerStop() {
    shooterSolenoid.set(false);
    shooterMag.set(false);
    // shooterMag.set(true);
  }

  public void shooterReload() {
    shooterMag.set(false);
  }

}
