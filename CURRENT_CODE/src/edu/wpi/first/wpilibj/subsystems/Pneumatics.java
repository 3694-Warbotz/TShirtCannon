
package edu.wpi.first.wpilibj.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.robot.RobotMap;

public class Pneumatics {
   //Define Objects
   public static Compressor compressor = new Compressor(RobotMap.compressor_pressure_port, RobotMap.compressor_relay); //Create a compressor object with the ports defined in RobotMap()
   public static Solenoid one = new Solenoid(RobotMap.soleOne); //Define Solenoid #1
   public static Solenoid two = new Solenoid(RobotMap.soleTwo); //Define Solenoid #2
   public static Solenoid three = new Solenoid(RobotMap.soleThree); //Define Solenoid #3
   public static Solenoid four = new Solenoid(RobotMap.soleFour); //Define Solenoid #4
 
   //Void for running the compressor
   public static void start() {
       compressor.start(); //start the compressor, which creates instances of the relay and the digital port. Will automatically check if pressure exceeds limit set by the high pressure switch, it will shut off.
    }
   public static void fireOne() { //Command to fire solenoid #1
       one.set(true);
       two.set(false);
       three.set(false);
       four.set(false);
   }
   public static void fireTwo() { //Command to fire solenoid #2
       two.set(true);
       one.set(false);
       three.set(false);
       four.set(false);
   }
   public static void fireThree() { //Command to fire solenoid #3
       three.set(true);
       one.set(false);
       two.set(false);
       four.set(false);
   }
   public static void fireFour() { //Command to fire solenoid #4
       four.set(true);
       one.set(false);
       two.set(false);
       three.set(false);
   }
}
