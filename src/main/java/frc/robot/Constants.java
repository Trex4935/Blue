// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.InvertType;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

	public static final Boolean inversion = true;
	
	// Left side
	// Left front
	public static final int leftFrontA = 11;
	public static final int leftFrontB = 12;
	// Left Read
	public static final int leftRearA = 13;
	public static final int leftRearB = 14;

	// Right Side
	// Right Front
	public static final int rightFrontA = 21;
	public static final int rightFrontB = 22;
	// Right Rear
	public static final int rightRearA = 23;
	public static final int rightRearB = 24;
	

	public static final int rightTankAxis = 0;
	public static final int leftTankAxis = 0;
	public static final int xboxControllerPort = 0;

	public static Double speedlimitCurrent = .75;}
