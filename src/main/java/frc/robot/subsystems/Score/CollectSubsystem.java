// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Score;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CollectSubsystem extends SubsystemBase {
SparkMax collectMotor = new SparkMax(Constants.COLLECT_MOTOR_ID, SparkMax.MotorType.kBrushed);
DigitalInput gamePieceIn = new DigitalInput(Constants.GAME_PIECE_SENSOR_ID);

  public CollectSubsystem() {
    SparkMaxConfig collectorConfig = new SparkMaxConfig();
    collectorConfig.idleMode(IdleMode.kBrake);
    collectorConfig.inverted(false);
 
    collectMotor.configure(collectorConfig, 
    ResetMode.kResetSafeParameters, 
    PersistMode.kPersistParameters);

  }

  public void setPower(double power) {
    collectMotor.set(power);
  }
  
  public void stopMotor() {
    collectMotor.stopMotor();
  }

  public boolean isGamePieceIn() {
    return !gamePieceIn.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
