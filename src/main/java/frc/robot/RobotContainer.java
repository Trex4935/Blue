// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import Extensions.RightTriggerBool;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.AimShooterDown;
import frc.robot.commands.AimShooterUp;
import frc.robot.commands.DriveWithControllerCommand;
import frc.robot.commands.ShooterTriggerCommand;
import frc.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  // Commands and Subsystems
  public final Drivetrain driveTrain;
  public final Shooter shooter;
  public static XboxController controller;
  private final DriveWithControllerCommand driveWithController;
  private final AimShooterDown aimShooterDown;
  private final AimShooterUp aimShooterUp;
  private final ShooterTriggerCommand shooterTrigger;

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {

    // Drivetrain
    driveTrain = new Drivetrain();
    driveWithController = new DriveWithControllerCommand(driveTrain);
    driveWithController.addRequirements(driveTrain);
    driveTrain.setDefaultCommand(driveWithController);

    controller = new XboxController(Constants.xboxControllerPort);

    shooter = new Shooter();
    aimShooterDown = new AimShooterDown(shooter);
    aimShooterUp = new AimShooterUp(shooter);
    shooterTrigger = new ShooterTriggerCommand(shooter);

    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller, XboxController.Button.kA.value).whileTrue(aimShooterDown);
    new JoystickButton(controller, XboxController.Button.kB.value).whileTrue(aimShooterUp);
//  new RightTriggerBool().whileActiveContinuous(shooterTrigger);
    new JoystickButton(controller, XboxController.Button.kRightBumper.value).whileTrue(shooterTrigger);

    

    // new JoystickButton(controller,
    // XboxController.Button.kX.value).whenPressed(shooterBackup);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return aimShooterDown;
  }
}
