package frc.robot;

public final class Constants {

// Motor IDs
public static final int COLLECT_MOTOR_ID = 5;
public static final int INPUT_MOTOR_ID = 6;
public static final int BOOST_DOWN_MOTOR_ID = 7;
public static final int BOOST_UP_MOTOR_ID = 8;

// Sensor IDs
public static final int GAME_PIECE_SENSOR_ID = 0;
public static final double INPUT_MAX_OUTPUT = 0;

    public static final class LimeLight {
      public static final String limelightFront = "limelight-front";
      public static final String limelightBack = "limelight-back";

        public static final double kP_Distance = 0.04;
        public static final double kP_Aim = 0.02;
        public static final double targetArea = 4.0;
        public static final double maxSpeed = 0.25;
        public static final double minSpeed = 0.05;
        public static final double deadbandDistance = 0.3;
        public static final double deadbandAim = 10.0;
        public static final double minTurnCommand = 0.02;
        public static final double initialSpeed = 0.3;
    }

    public static final class Drivetrain {
        public static final int frenteLeft = 1;
        public static final int trasLeft = 2;
        public static final int frenteRight = 3;
        public static final int trasRight = 4;

        public static final boolean leftInvertido = false;
        public static final boolean rightInvertido = true;

        public static final double deadzone = 0.04;
    }

    public static final class Joystick {
        public static final int sJoystick = 3;
        public static final int lJoystick = 0;

        public static final int eixoX = 0;
        public static final int eixoY = 1;
        public static final int eixoX2 = 4;
        public static final int eixoY2 = 5;

        public static final int botaoA = 1;
        public static final int botaoB = 2;
        public static final int botaoX = 3;
        public static final int botaoY = 4;

        public static final int L1 = 5;
        public static final int R1 = 6;
        public static final int L2 = 2;
        public static final int R2 = 3;

        public static final double speedA = 0.25;
        public static final double speedB = 0.5;
        public static final double speedX = 1.0;
    }

    public static final class Angular {
        public static boolean isMovingToTarget = false;
        public static double targetPosition = 0.0;

        public static final double posZero = 0.0;
        public static final double posNoventa = 90.0;
        private static final double toleranciamin = Constants.Arm.toleranciaMin;  
        private static final double toleranciamax = Constants.Arm.toleranciaMax;
        private static final double maxoutput = Constants.Arm.maxOutput;  
    }

    public static final class Encoder {
        public static final int encoderId = 4;
    }
}