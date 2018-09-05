
package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Robot extends IterativeRobot {
    
    //define motors
    public Victor leftDrive; //left motor object
    public Victor rightDrive; //right motor object
    public Victor turrettElevate; //elevation motor on the turrett
    public Victor turrettTurn; //turn motor on the turrett
    
    //define OperatorInterface objects
    public Joystick leftStick; //left-hand joystick
    public Joystick rightStick; //right-hand joystick
    public JoystickButton soleSafety; //safety for firing the solenoids
    public JoystickButton fireOne; //button for firing solenoid 1
    public JoystickButton fireTwo; //button for firing solenoid 2
    public JoystickButton fireThree; //button for firing solenoid 3
    public JoystickButton fireFour; //button for firing solenoid 
    public JoystickButton turrettSafety; //safety for the turrett
    
    //define compressors
    public Compressor leftCompressor; //left-hand compressor
    public Compressor rightCompressor; //right-hand compressor
    
    //define solenoids
    public Relay soleOne; //Spike relay for Solenoid #1
    public Relay soleTwo; //Spike relay for Solenoid #2
    public Relay soleThree; //Spike relay for Solenoid #3
    public Relay soleFour; //Spike relay for Solenoid #4

    public void robotInit() {
        leftDrive = new Victor(1); //left victor is on PWM port 1
        rightDrive = new Victor(2); //right victor is on PWM port 2
        
        turrettElevate = new Victor(9); //elevator victor is on PWM port 9
        turrettTurn = new Victor(10); //turn victor is on PWM port 10
        
        leftStick = new Joystick(1); //leftstick is on PC port 1
        rightStick = new Joystick(2); //rightstick is on PC port 2
        soleSafety = new JoystickButton(leftStick, 1); //safety is button 1 on the leftstick
        fireOne = new JoystickButton(leftStick, 2); //fireone is button 2 on the left stick
        fireTwo = new JoystickButton(leftStick, 3); //firetwo is button 3 on the leftstick
        fireThree = new JoystickButton(leftStick, 4); //firethree is button 4 on the leftstick
        fireFour = new JoystickButton(leftStick, 5); //firefour is button 5 on the leftstick
        turrettSafety = new JoystickButton(rightStick, 1); //turrettsafety is button 1 on the rightstick
        
        leftCompressor = new Compressor(1, 3); //left side compressor is on digital input port 1 with a Spike relay on PWM 3
        rightCompressor = new Compressor(2, 4); //right side compressor is on digital input port 2 with a Spike relay on PWM 4
        
        soleOne = new Relay(5); //soleone is on PWM port 5
        soleTwo = new Relay(6); //soletwo is on PWM port 6
        soleThree = new Relay(7); //solethree is on PWM port 7
        soleFour = new Relay(8); //solefour is on PWM port 8
    }

    public void autonomousPeriodic() {
        leftCompressor.stop();
        rightCompressor.stop();
    }

    public void teleopPeriodic() {
        
            //stop the compressors when not enabled
            rightCompressor.stop();
            leftCompressor.stop();
        
        while (isOperatorControl() && isEnabled())  //while the robot is enabled
          
            leftDrive.set(leftStick.getY()); //set the left motor to the leftstick Y-axis
            rightDrive.set(rightStick.getY()); //set the right motor to the rightstick Y-axis
            leftCompressor.start(); //start the left compressor
            rightCompressor.start(); //start the right compressor
            
            while (turrettSafety.get() == true) { //while the turrettsafety button is pressed
                turrettTurn.set(rightStick.getX()); //set the turn motor to the x-axis on rightstick
                turrettElevate.set(rightStick.getY()); //set the elevate motor to the y-axis of the rightstick
                leftDrive.set(0.0); //set the left motor to be 0 speed
                rightDrive.set(0.0); //set the rigtht motor to be 0 speed
            }
            while (soleSafety.get() == true) { // while the safety button is pressed
                if (fireOne.get() == true) { //if fireone is pressed
                    soleOne.set(Relay.Value.kOn); //set the relay value to on
                        Timer.delay(0.5); //for .5 secs
                    soleOne.set(Relay.Value.kOff); //then turn it off
                }
                if (fireTwo.get() == true) { //if firetwo is pressed
                    soleTwo.set(Relay.Value.kOn); //set the relay value to on
                        Timer.delay(0.5); //wait .5 secs
                    soleTwo.set(Relay.Value.kOff); //then turn it off
                }
                if (fireThree.get() == true) { //if firethree is pressed
                    soleFour.set(Relay.Value.kOn); //set the relay value to on
                        Timer.delay(0.5); //wait .5 secs
                    soleFour.set(Relay.Value.kOff); //then turn it off
                }
                if (fireFour.get() == true) { //if firefour is pressed
                    soleFour.set(Relay.Value.kOn); //set the relay value to on
                        Timer.delay(0.5); //wait .5 secs
                    soleFour.set(Relay.Value.kOff); //then turn it off
                }
            }
        }
    
    
    public void testPeriodic() {
    
    }
    
}
