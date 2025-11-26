package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Score.LimeLight;
import frc.robot.subsystems.Angulator;
import frc.robot.subsystems.Shooter;

public class AimAndShootHighTag extends Command {

    private final LimeLight ll;
    private final Angulator angulator;
    private final Shooter shooter;

    private final double cameraHeight = 0.65;
    private final double targetHeight = 1.32;
    private final double cameraAngle = 25;
    
    private final double k0 = 18;   // base do ângulo do angulador
    private final double k1 = 5.2;  // ganho por metro

    private final double v0 = 2600;  // velocidade mínima do shooter
    private final double v1 = 800;   // ganho por metro


    public AimAndShootHighTag(LimeLight ll, Angulator angulator, Shooter shooter) {
        this.ll = ll;
        this.angulator = angulator;
        this.shooter = shooter;
        addRequirements(angulator, shooter);
    }

    @Override
    public void initialize() {}

    @Override
    public void execute() {
        if (!ll.frontHasTarget()) {
            System.out.println("Nenhuma AprilTag detectada!");
            return;
        }

        double ty = ll.getFrontTY();

        double angleTotal = Math.toRadians(cameraAngle + ty);
        double distance = (targetHeight - cameraHeight) / Math.tan(angleTotal);
        double targetAngle = k0 + (k1 * distance);
        double targetVelocity = v0 + (v1 * distance);

        angulator.setAngle(targetAngle);
        shooter.setVelocity(targetVelocity);

        System.out.println("TY = " + ty 
            + " | Distância = " + distance 
            + " | Angulo = " + targetAngle 
            + " | Velocidade = " + targetVelocity);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
