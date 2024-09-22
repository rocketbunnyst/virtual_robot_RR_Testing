package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class TestMecDrive extends LinearOpMode {

    MecanumDrive drive;

    public void runOpMode(){

        drive = new MecanumDrive(hardwareMap, new Pose2d(0,0,0));

        waitForStart();

        while (opModeIsActive()){
            double px = -gamepad1.left_stick_y;
            double py = -gamepad1.left_stick_x;
            double pa = -gamepad1.right_stick_x;
            PoseVelocity2d vel = drive.updatePoseEstimate();
            telemetry.addData("Pose: ", "x: %.1f  y: %.1f  h: %.1f",
                    drive.pose.position.x, drive.pose.position.y, Math.toDegrees(drive.pose.heading.toDouble()));
            telemetry.addData("Vel: ", "vx: %.1f  vy: %.1f  va: %.1f", vel.linearVel.x,
                    vel.linearVel.y, vel.angVel);
            drive.setDrivePowers(new PoseVelocity2d(new Vector2d(px, py), pa));
            telemetry.update();
        }


    }
}
