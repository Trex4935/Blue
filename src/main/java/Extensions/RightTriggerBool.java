// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package Extensions;

import frc.robot.Constants;
import frc.robot.RobotContainer;

/** Add your docs here. */
public class RightTriggerBool {
    // Overriding the tigger get method
    
    public static boolean getRightTrigger() {
        if (RobotContainer.controller.getRawAxis(Constants.rtTrigger) >= 0.25)
        {
            return true;
        }
        else {
            return false;
        }
    }
}
