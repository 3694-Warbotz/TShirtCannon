
package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class Robot extends IterativeRobot {
    
    //define motors
    public Victor leftDrive = new Victor(Ports.leftDrive); //left victor is on PWM port 1
    public Victor rightDrive = new Victor(Ports.rightDrive); //right victor is on PWM port 2
    public Victor turrettElevate = new Victor(Ports.turrettElevate); //elevator victor is on PWM port 9
    public Victor turrettTurn = new Victor(Ports.turrettTurn); //turn victor is on PWM port 10
    
    //define OperatorInterface objects
    public Joystick leftStick = new Joystick(1); //leftstick is on PC port 1
    public Joystick rightStick = new Joystick(2); //rightstick is on PC port 2
    public JoystickButton fireOne = new JoystickButton(leftStick, 2); //fireone is button 2 on the left stick
    public JoystickButton fireTwo = new JoystickButton(leftStick, 3); //firetwo is button 3 on the leftstick
    public JoystickButton fireThree = new JoystickButton(leftStick, 4); //firethree is button 4 on the leftstick
    public JoystickButton fireFour = new JoystickButton(leftStick, 5); //firefour is button 5 on the leftstick
    
    //define compressors
    public Compressor leftCompressor = new Compressor(Ports.leftcompressor_digitalInput, Ports.leftCompressor_relay); //left side compressor is on digital input port 1 with a Spike relay on PWM 3
    public Compressor rightCompressor = new Compressor(Ports.rightCompressor_digitalInput, Ports.rightCompressor_relay); //right side compressor is on digital input port 2 with a Spike relay on PWM 4
    
    //define solenoids
    public Relay soleOne = new Relay(Ports.soleOne); //soleone is on PWM port 5
    public Relay soleTwo = new Relay(Ports.soleTwo); //soletwo is on PWM port 6
    public Relay soleThree = new Relay(Ports.soleThree); //solethree is on PWM port 7
    public Relay soleFour = new Relay(Ports.soleFour); //solefour is on PWM port 8
    
    //Define limit switches
    public DigitalInput turnLeft = new DigitalInput(Ports.turnLeft);
    public DigitalInput turnRight = new DigitalInput(Ports.turnRight);
    public DigitalInput elevateUpper = new DigitalInput(Ports.elevateUpper);
    public DigitalInput elevateLower = new DigitalInput(Ports.elevateLower);
   
    public void robotInit() {
        leftCompressor.start(); //start the left compressor
        rightCompressor.start(); //start the right compressor
    }

    public void autonomousPeriodic() {

    }

    public void teleopPeriodic() {
        leftDrive.set(leftStick.getY()); //set the left motor to the leftstick Y-axis
        rightDrive.set(rightStick.getY()); //set the right motor to the rightstick Y-axis
            
        if (elevateUpper.get() == true) { //if the upper limit switch is pressed
            turrettElevate.set(-.15);
            Timer.delay(0.25);
        }
        else if (elevateLower.get() == true) { //if the lower limit switch is pressed
            turrettElevate.set(.15);
            Timer.delay(0.25);
            }
        else if (turnRight.get() == true) { //if the right limit switch is pressed
            turrettTurn.set(-.15);
            Timer.delay(0.25);
            }
        else if (turnLeft.get() == true) { //if the left limit switch is pressed
            turrettTurn.set(.15);
            Timer.delay(0.25);
            }
        else {
            turrettTurn.set(rightStick.getX()); //set the turn motor to the x-axis on rightstick
            turrettElevate.set(rightStick.getY()); //set the elevate motor to the y-axis of the rightstick
        }
            
        if (fireOne.get() == true) { //if fireone is pressed
            soleOne.set(Relay.Value.kOn); //set the relay value to on
            Timer.delay(0.5); //for .5 secs
        }
        else if (fireTwo.get() == true) { //if firetwo is pressed
            soleTwo.set(Relay.Value.kOn); //set the relay value to on
            Timer.delay(0.5); //wait .5 secs
            }
        else if (fireThree.get() == true) { //if firethree is pressed
            soleFour.set(Relay.Value.kOn); //set the relay value to on
            Timer.delay(0.5); //wait .5 secs
        }
        else if (fireFour.get() == true) { //if firefour is pressed
            soleFour.set(Relay.Value.kOn); //set the relay value to on
            Timer.delay(0.5); //wait .5 secs
        }
        else {
            soleFour.set(Relay.Value.kOff);
            soleThree.set(Relay.Value.kOff);
            soleTwo.set(Relay.Value.kOff);
            soleOne.set(Relay.Value.kOff);
        }
            
    }
 
    public void testPeriodic() { //for testing crio functions

    }
}
