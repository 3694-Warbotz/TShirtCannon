
package edu.wpi.first.wpilibj.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.robot.RobotMap;

public class Pneumatics {
   //Define Objects
   public static Compressor compressorOne = new Compressor(RobotMap.compressorOne_pressure_port, RobotMap.compressorOne_relay); //Create a compressor object with the ports defined in RobotMap()
   public static Compressor compressorTwo = new Compressor(RobotMap.compressorTwo_pressure_port, RobotMap.compressorTwo_relay); //Create a compressor object with the ports defined in RobotMap()
   public static Solenoid one = new Solenoid(RobotMap.soleOne); //Define Solenoid #1
   public static Solenoid two = new Solenoid(RobotMap.soleTwo); //Define Solenoid #2
   public static Solenoid three = new Solenoid(RobotMap.soleThree); //Define Solenoid #3
   public static Solenoid four = new Solenoid(RobotMap.soleFour); //Define Solenoid #4
   public static Timer soleTimer = new Timer();
   public static boolean isRunning = false;
   public static boolean oneFired;
   public static boolean twoFired;
   public static boolean threeFired;
   public static boolean fourFired;
   
//Void for running the compressor
   public static void compressorStart() {
       compressorOne.start(); //start the compressor, which creates instances of the relay and the digital port. Will automatically check if pressure exceeds limit set by the high pressure switch, it will shut off.
       compressorTwo.start(); //start the compressor, which creates instances of the relay and the digital port. Will automatically check if pressure exceeds limit set by the high pressure switch, it will shut off.
   }
   public static void compressorStop() {
       compressorOne.stop(); //turn the compressor off
       compressorTwo.stop(); //turn the compressor off
   }
   public static void fireOne() { //Command to fire solenoid #1
       soleTimer.start(); //start the timer
       //set all solenoids to be off
       one.set(false);
       two.set(false);
       three.set(false);
       four.set(false);
       while (soleTimer.get() <= 0.5) { 
           one.set(true);
       }
       isRunning = true;
       oneFired = true;
   }
   public static void fireTwo() { //Command to fire solenoid #2
       soleTimer.start(); //start the timer
       //set all solenoids to be off
       one.set(false);
       two.set(false);
       three.set(false);
       four.set(false);
       while (soleTimer.get() <= 0.5) {
           two.set(true);
       }
       isRunning = true;
       twoFired = true;
   }
   public static void fireThree() { //Command to fire solenoid #3
       soleTimer.start();
       one.set(false);
       two.set(false);
       three.set(false);
       four.set(false);
       while (soleTimer.get() <= 0.5) {
           three.set(true);
       }
       isRunning = true;
       threeFired = true;
   }
   public static void fireFour() { //Command to fire solenoid #4
       soleTimer.start();
       one.set(false);
       two.set(false);
       three.set(false);
       four.set(false);
       while (soleTimer.get() <= 0.5) {
           four.set(true);
       }
       isRunning = true;
       fourFired = true;
   }
}
