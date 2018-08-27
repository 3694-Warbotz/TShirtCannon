
package edu.wpi.first.wpilibj.robot;

public class RobotMap {
    //Ports for the drive motors
    public static final int leftDrive = 0;
    public static final int rightDrive = 1;
    
    //Ports for compressor
    public static final int compressor_relay = 2; //Spike relay input for controlling the compressor
    public static final int compressor_pressure_port = 3; //Digital input for checking the accumulator pressure
    
    //Ports for solenoids -- SOLENOID NUMBERS ARE FROM RIGHT TO LEFT ON THE ACTUAL CANNON
    public static final int soleOne = 1; //Port on breakout board for solenoid one
    public static final int soleTwo = 2; //Port on breakout board for solenoid two
    public static final int soleThree = 2; //Port on breakout board for solenoid three
    public static final int soleFour = 2; //Port on breakout board for solenoid four
}
