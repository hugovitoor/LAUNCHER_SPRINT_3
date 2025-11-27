package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.DefaultDriveCommand;
import frc.robot.commands.DriveDistanceCommand;
import frc.robot.commands.GoToAprilTagCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimeLight;

public class RobotContainer {

    private final DriveSubsystem driveSubsystem = new Drivetrain();
    private final ThroughBore rightEncoder = new ThroughBore();

    private final LimeLight llfront = new LimeLight();
    private final LimeLight llback = new LimeLight();

    private final Joystick ljoystick = new Joystick(Constants.Joystick.lJoystick);
    private final Joystick sjoystick = new Joystick(Constants.Joystick.sJoystick);

    private final DefaultDriveCommand defaultDriveCommand = new DefaultDriveCommand(driveSubsystem, ljoystick);
    private final SendableChooser<Command> chooser = new SendableChooser<>();

    public RobotContainer() {
        configureDefaultCommand();
        configureAutonomous();
    }

    private void configureDefaultCommand() {
        drivetrain.setDefaultCommand(defaultDriveCommand);
    }

    private void configureAutonomous() {
        chooser.setDefaultOption("Angulador", new DriveDistanceCommand(drivetrain, rightEncoder)); 
        chooser.addOption("Caçar-bola", new GoToAprilTagCommand(drivetrain, limelight));
        chooser.addOption("Caçar-bola e angulador", )
        SmartDashboard.putData("Auto Selector", chooser);
    }

    public Command getAutonomousCommand() {
        return chooser.getSelected();
    }

    public Drivetrain getDriveSubsystem() {
        return driveSubsystem;
    }

    public LimeLight getLimelight() {
        return limelight;
    }

    public Command getTeleopCommand() {
        return null;
    }
}