package frc.robot.subsystems;

import edu.wpi.first.hal.simulation.RoboRioDataJNI;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import frc.robot.Constants;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;


public class Drivetrain extends SubsystemBase {
    private final static Drivetrain INSTANCE = new Drivetrain();

    @SuppressWarnings("WeakerAccess")
    public static Drivetrain getInstance() {
        return INSTANCE;
    }

    private CANSparkMax leftFront, leftBack, rightFront, rightBack;
    private final MotorControllerGroup leftMotorGroup, rightMotorGroup;
    private final DifferentialDrive m_DiffertialDrive;

    private double scale;

    public Drivetrain() {
        leftFront = new CANSparkMax(RobotMap.DRIVE_LEFTFRONT, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftBack = new CANSparkMax(RobotMap.DRIVE_LEFTBACK, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightFront = new CANSparkMax(RobotMap.DRIVE_RIGHTFRONT, CANSparkMaxLowLevel.MotorType.kBrushless);
        rightBack = new CANSparkMax(RobotMap.DRIVE_RIGHTBACK, CANSparkMaxLowLevel.MotorType.kBrushless);
        leftMotorGroup = new MotorControllerGroup(leftFront, leftBack);
        rightMotorGroup = new MotorControllerGroup(rightFront, rightBack);
        m_DiffertialDrive = new DifferentialDrive(leftMotorGroup, rightMotorGroup);
        scale = Constants.Drivetrain.SCALE;
    }

    public void configureSystem() {
        leftFront.setInverted(true);
        leftBack.setInverted(true);
        rightFront.setInverted(false);
        rightBack.setInverted(false);
        leftFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
        leftBack.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rightFront.setIdleMode(CANSparkMax.IdleMode.kCoast);
        rightBack.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }

    public void TankDrive(double leftSpeed, double rightSpeed) {
        m_DiffertialDrive.tankDrive(leftSpeed * scale, rightSpeed * scale);
        m_DiffertialDrive.feed();
    }

    public void stopDrive() {
        m_DiffertialDrive.tankDrive(0, 0);
    }
}
