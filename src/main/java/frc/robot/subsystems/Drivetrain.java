// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import frc.robot.Constants.DriveTrainConstants;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax frontLeft = new CANSparkMax(DriveTrainConstants.frontLeft, MotorType.kBrushless);
  private CANSparkMax frontRight = new CANSparkMax(DriveTrainConstants.frontRight, MotorType.kBrushless);
  private CANSparkMax middleLeft = new CANSparkMax(DriveTrainConstants.middleLeft, MotorType.kBrushless);
  private CANSparkMax middleRight = new CANSparkMax(DriveTrainConstants.middleRight, MotorType.kBrushless);
  private CANSparkMax backLeft = new CANSparkMax(DriveTrainConstants.backLeft, MotorType.kBrushless);
  private CANSparkMax backRight = new CANSparkMax(DriveTrainConstants.backRight, MotorType.kBrushless);

  /** Creates a new ExampleSubsystem. */
  public Drivetrain() {
    
  }

  public void setMotors(double rightVelocity, double leftVelocity){
    double stickDriftThreshold = 0.15;
    
    if (rightVelocity <= stickDriftThreshold){
      rightVelocity = 0;
    }
    if (leftVelocity < stickDriftThreshold){
      leftVelocity = 0;
    }

    frontRight.set(rightVelocity);
    middleRight.set(rightVelocity);
    backRight.set(rightVelocity);
    frontLeft.set(leftVelocity);
    middleLeft.set(leftVelocity);
    backLeft.set(leftVelocity);
  }

}
