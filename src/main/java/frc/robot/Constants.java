// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DutyCycle;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

// Motor IDs
public static final int COLLECT_MOTOR_ID = 5;
public static final int INPUT_MOTOR_ID = 6;
public static final int BOOST_DOWN_MOTOR_ID = 7;
public static final int BOOST_UP_MOTOR_ID = 8;
public static final int ANGULAR_MOTOR_ID = 9;

// Sensor IDs
public static final int GAME_PIECE_SENSOR_ID = 0;
public static final int ANGULAR_ENCODER_ID = 0;

// Input constants
public static final double INPUT_MAX_OUTPUT = 0.5;
public static final double BOOST_POWER = 0.5;
public static final double ANG_MAX_OUTPUT = 0.3;

public static final double RAMP_RATE = 0.05;
public static final int DEBOUNCE_COUNT = 4;
public static final double ANG_TOLERANCE_DEG = 1;

// Angular PID constants
public static final double ANG_KP = 0.015;
public static final double ANG_KI = 0.0;
public static final double ANG_KD = 0.0008;

// Angular Preferences Keys
public static final String ANG_PREF_OFFSET = "AngularOffsetDeg";
public static final String ANG_PREF_TARGET = "AngularTargetAngle";
public static final String ANG_PREF_MIN_ANGLE = "AngularMinAngle";
public static final String ANG_PREF_MAX_ANGLE = "AngularMaxAngle";
public static final int SYSTEM = 0;
public static final int SYSTEM_CONTROLLER_ID = 0;






}
