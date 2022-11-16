package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.Drivetrain;

import java.util.function.DoubleSupplier;

public class DriveArcade extends CommandBase {

    private final Drivetrain drivetrain;
    DoubleSupplier LSpeed, RSpeed;

    public DriveArcade(Drivetrain drivetrain, DoubleSupplier LSpeed, DoubleSupplier RSpeed) {
        this.drivetrain = drivetrain;
        this.LSpeed = LSpeed;
        this.RSpeed = RSpeed;
        addRequirements(drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.configureSystem();
        drivetrain.stopDrive();
    }

    @Override
    public void execute() {
        drivetrain.TankDrive(LSpeed.getAsDouble(), RSpeed.getAsDouble());
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.stopDrive();
    }
}