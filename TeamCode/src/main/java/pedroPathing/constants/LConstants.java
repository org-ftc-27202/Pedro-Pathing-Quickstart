package pedroPathing.constants;

import com.pedropathing.localization.*;
import com.pedropathing.localization.constants.*;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;

public class LConstants {
    static {

        TwoWheelConstants.forwardTicksToInches = .002;
        TwoWheelConstants.strafeTicksToInches = .002;
        TwoWheelConstants.forwardY = -1.5;
        TwoWheelConstants.strafeX = -2.5;
        TwoWheelConstants.forwardEncoder_HardwareMapName = "rightRear";
        TwoWheelConstants.strafeEncoder_HardwareMapName = "leftFront";
        TwoWheelConstants.forwardEncoderDirection = Encoder.FORWARD;
        TwoWheelConstants.strafeEncoderDirection = Encoder.FORWARD;
        TwoWheelConstants.IMU_HardwareMapName = "imu";
        TwoWheelConstants.IMU_Orientation = new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.RIGHT, RevHubOrientationOnRobot.UsbFacingDirection.UP);
    }
}




