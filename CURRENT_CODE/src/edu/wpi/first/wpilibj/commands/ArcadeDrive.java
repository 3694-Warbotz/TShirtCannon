
package edu.wpi.first.wpilibj.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.robot.OI;
import edu.wpi.first.wpilibj.robot.Robot;

public class ArcadeDrive {
    //create drive function
    public static void drive(Victor left, Victor right) {
        left = Robot.driveTrain.leftDrive; //set left victor to real left victor
        right = Robot.driveTrain.rightDrive; //set right victor to real right victor
        
        double throttle = OI.leftStick.getY(); //set the throttle value to y-axis
        double turn = OI.leftStick.getX(); //set the turn value to the x-axis
        left.set(throttle + turn); //set the left motor to the throttle value added to the turn value
        right.set(throttle - turn); //set the right motor tp the throttle value subracted by the turn value
        
    }
}
