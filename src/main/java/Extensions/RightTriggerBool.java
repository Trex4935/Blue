// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package Extensions;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;
import frc.robot.RobotContainer;

/** Add your docs here. */
public class RightTriggerBool extends Trigger {
    // Overriding the tigger get method
    @Override
    public boolean get() {
        if (RobotContainer.controller.getRawAxis(Constants.rtTrigger) >= 0.25)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
