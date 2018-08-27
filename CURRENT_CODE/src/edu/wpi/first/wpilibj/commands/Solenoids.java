
package edu.wpi.first.wpilibj.commands;

import edu.wpi.first.wpilibj.robot.Robot;

public class Solenoids {
    public static void solenoidFire() { //Command to fire the solenoids based on button input
       
        if(Robot.OI.soleOne.get() == true) { //if button #1 is being pressed
            Robot.pneumatics.fireOne(); //fireone() command from the pneumatics subsystem
        }
        if(Robot.OI.soleTwo.get() == true) { //if button #2 is being pressed
            Robot.pneumatics.fireTwo(); //firetwo() command from pneumatics subsystem
        }
        if(Robot.OI.soleThree.get() == true) { //if button #3 is being pressed
            Robot.pneumatics.fireThree(); //firethree() command from pneumatics subsystem
        }
        if(Robot.OI.soleFour.get() == true) { //if button #4 is being pressed
            Robot.pneumatics.fireFour(); //firefour() command from pneumatics subsystem
        }
    }
}
