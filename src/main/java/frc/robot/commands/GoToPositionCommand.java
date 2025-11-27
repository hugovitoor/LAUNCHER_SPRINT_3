package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.AngularSubsystem;
import frc.robot.subsystems.InputSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class GoToPositionCommand extends Command { // OK, n mexe

    private final Arm arm;
    private final Encoder encoder;
    private final AngularSubsystem angular;
    private final InputSubsystem sensor;
    private final Joystick controle;

    private boolean isMovingToTarget = Constants.Angular.isMovingToTarget;
    private double targetPosition = Constants.Angular.targetPosition;
    
    private static final double poszero = Constants.Angular.posZero;    
    private static final double posnov = Constants.Angular.posNoventa; 
    private static final double toleranciamin = Constants.Angular.toleranciaMin;  
    private static final double toleranciamax = Constants.Angular.toleranciaMax;
    private static final double maxoutput = Constants.Angular.maxOutput;  
    private static final double manual = Constants.Angular.manualMove; 

    public GoToPositionCommand(InputSubsystem sensor, Encoder encoder, Joystick controle, AngularSubsystem angular) {
        this.sensor = sensor;
        this.encoder = encoder;
        this.controle = controle;
        this.angular = angular;
        addRequirements(angular);
    }

    @Override
    public void initialize() {
        SmartDashboard.putString("Angular/Status", "Pronto!");
    }

    @Override
    public void execute() {
        double L2 = controle.getRawAxis(Constants.Joystick.L2);
        double R2 = controle.getRawAxis(Constants.Joystick.R2);

        double current = encoder.getPosition();

        if (L2 > toleranciamin && current > toleranciamin) {
            angular.move(manual);
            return;
        }

        if (R2 > toleranciamin && current < toleranciamax) {
            angular.move(-manual);
            return;
        }

        if (controle.getRawButtonPressed(botaoY)) {
            targetPosition = posnov;
            isMovingToTarget = true;
        }

        if (controle.getRawButtonPressed(botaoB)) {
            targetPosition = poszero;
            isMovingToTarget = true;
        }

        if (isMovingToTarget) {
            moveToTarget();
        } else {
            angular.stop();
        }
    }

    private void moveToTarget() {

        double current = encoder.getPosition();
        double error = targetPosition - current;

        if (Math.abs(error) <= toleranciamin) {
            angular.stop();
            isMovingToTarget = false;
            SmartDashboard.putString("Arm/Status", "Alvo atingido!");
            return;
        }

        double output = (error < 0) ? maxoutput : -maxoutput;

        angular.move(output);

        SmartDashboard.putNumber("Angular/Error", error);
        SmartDashboard.putNumber("Angular/Output", output);
        SmartDashboard.putString("Angular/Status", "Movendo para alvo");
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        angular.stop();
    }
}