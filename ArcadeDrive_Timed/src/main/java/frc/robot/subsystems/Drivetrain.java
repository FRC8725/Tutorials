package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;

public class Drivetrain {
    private WPI_VictorSPX leftfront, leftback, rightfront, rightback;
    private MotorControllerGroup leftGroup, rightGroup;
    private DifferentialDrive m_Drive;

    public Drivetrain() {
        // 初始化
        leftfront = new WPI_VictorSPX(RobotMap.DRIVE_LEFTFRONT);
        leftback = new WPI_VictorSPX(RobotMap.DRIVE_LEFTBACK);
        rightfront = new WPI_VictorSPX(RobotMap.DRIVE_RIGHTFRONT);
        rightback = new WPI_VictorSPX(RobotMap.DRIVE_RIGHTBACK);
        leftGroup = new MotorControllerGroup(leftfront, leftback);
        rightGroup  = new MotorControllerGroup(rightfront, rightback);
        m_Drive = new DifferentialDrive(leftGroup,rightGroup);
        leftGroup.setInverted(true);
    }

    public void drive(double lspeed, double rspeed) {
        m_Drive.tankDrive(lspeed, rspeed);
    }

}
