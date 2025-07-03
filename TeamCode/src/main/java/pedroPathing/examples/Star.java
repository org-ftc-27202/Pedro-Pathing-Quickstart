package pedroPathing.examples;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.pedropathing.util.Constants;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.pedropathing.follower.Follower;
import com.pedropathing.pathgen.BezierCurve;
import com.pedropathing.pathgen.PathChain;
import com.pedropathing.pathgen.Point;

import pedroPathing.constants.FConstants;
import pedroPathing.constants.LConstants;

@Config
@Autonomous (name = "Circle", group = "Examples")
public class Star extends OpMode {
    private Telemetry telemetryA;

    public static double RADIUS = 5;

    private Follower follower;
    private PathChain star;

    @Override
    public void init() {
        follower = new Follower(hardwareMap, FConstants.class, LConstants.class);

        star = follower.pathBuilder()
                .addPath(new BezierCurve(new Point(0,0, Point.CARTESIAN), new Point(0,RADIUS, Point.CARTESIAN), new Point(RADIUS, RADIUS, Point.CARTESIAN)))
                .addPath(new BezierCurve(new Point(RADIUS, RADIUS, Point.CARTESIAN), new Point(0,RADIUS, Point.CARTESIAN), new Point(0,2*RADIUS, Point.CARTESIAN)))
                .addPath(new BezierCurve(new Point(0,2*RADIUS, Point.CARTESIAN), new Point(0,RADIUS, Point.CARTESIAN), new Point(-RADIUS, RADIUS, Point.CARTESIAN)))
                .addPath(new BezierCurve(new Point(-RADIUS, RADIUS, Point.CARTESIAN), new Point(0,RADIUS, Point.CARTESIAN), new Point(0,0, Point.CARTESIAN)))
                .build();

        follower.followPath(star);

        telemetryA = new MultipleTelemetry(this.telemetry, FtcDashboard.getInstance().getTelemetry());
        telemetryA.addLine("This will run in a roughly star shape of radius " + RADIUS
                + ", starting on the right-most edge. So, make sure you have enough "
                + "space to the left, front, and back to run the OpMode.");
        telemetryA.update();
    }

    @Override
    public void loop() {
        follower.update();
        if (follower.atParametricEnd()) {
            follower.followPath(star);
        }

        follower.telemetryDebug(telemetryA);
    }
}
