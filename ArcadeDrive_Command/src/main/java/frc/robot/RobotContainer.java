package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.DriveArcade;
import frc.robot.subsystems.Drivetrain;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
  // initialize the Subsystems
  private final Drivetrain drivetrain = Drivetrain.getInstance();

  private static final GamepadJoystick gamepadJoystick = new GamepadJoystick(0);

  // initialize the Commands
  private final DriveArcade driveArcade = new DriveArcade(
          drivetrain,
          gamepadJoystick::get_LStickY,
          gamepadJoystick::get_RStickY
  );

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer()
  {
    drivetrain.setDefaultCommand(driveArcade);

    // Configure the button bindings
    configureButtonBindings();
  }

  private void configureButtonBindings()
  {
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    // An ExampleCommand will run in autonomous
    return new SequentialCommandGroup();
  }
}