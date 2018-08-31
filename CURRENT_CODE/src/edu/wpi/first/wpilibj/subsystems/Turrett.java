
package edu.wpi.first.wpilibj.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.robot.RobotMap;


public class Turrett {
    public static Victor elevation = new Victor(RobotMap.turrett_elevate); //height motor on the turrett
    public static Victor turn = new Victor(RobotMap.turrett_turn); //turn motor on the turrett
}
