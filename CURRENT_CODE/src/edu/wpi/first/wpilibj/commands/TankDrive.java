
package edu.wpi.first.wpilibj.commands;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.robot.OI;
import edu.wpi.first.wpilibj.robot.Robot;

public class TankDrive {
    //create a drive function
    public static void drive (Victor left, Victor right) {
        left = Robot.driveTrain.leftDrive; //set left victor to the real left victor
        right = Robot.driveTrain.rightDrive; //set the right victor to be the real right victor
        
        left.set(OI.leftStick.getY()); //set the left victor to the y axis if left joystick
        right.set(OI.rightStick.getY()); //set the right victor to the y axis of the right joystick
    }
}
