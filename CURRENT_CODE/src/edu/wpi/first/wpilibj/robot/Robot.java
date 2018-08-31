
package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.commands.Solenoids;
import edu.wpi.first.wpilibj.commands.TankDrive;
import edu.wpi.first.wpilibj.commands.runTurrett;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.subsystems.Pneumatics;
import edu.wpi.first.wpilibj.subsystems.Turrett;

public class Robot extends IterativeRobot {
    
    //Create Objects
    public static DriveTrain driveTrain; //Create the DriveTrain subsystem object
    public static OI OI; //Create the OperatorInterface object
    public static Solenoids solenoids; //Create the Solenoids command object
    public static Pneumatics pneumatics; //Create the pneumatics subsystem object
    public static Turrett turrett; //Create Turrett subsystem
    public static runTurrett shoot; //Create runTurrett command object
    
    
    //Runs once on robot start
    public void robotInit() {
        //Instantiate Objects
        driveTrain = new DriveTrain(); //Instantiate DriveTrain
        OI = new OI(); //Instantiate the Operator Interface
        solenoids = new Solenoids(); //Instantiate Solenoids command
        pneumatics = new Pneumatics(); //Instantiate Pneumatics subsystem
        turrett = new Turrett(); //Instantiate turrett command
        shoot = new runTurrett(); //Instantiate runTurrett command
    }

    //runs continuously during autonomous
    public void autonomousPeriodic() {

    }

    //runs continuously during teleop
    public void teleopPeriodic() {
        pneumatics.compressorStop(); //if not enabled, then don't run the compressors
        while (isEnabled() && isOperatorControl()) { //while the robot is enabled
            TankDrive.drive(); //Drive the robot 
            runTurrett.run(); //run the runTurrett command
            Pneumatics.compressorStart(); //Start the compressor 
            while (OI.safety.get() == true) { //while the safety button is pressed
                solenoids.solenoidFire(); //Fire the solenoids based on the Solenoids() command
            }
            if (Pneumatics.isRunning == false) { //if no solenoids are set to be fired
                Pneumatics.soleTimer.stop(); //stop the timer
                Pneumatics.soleTimer.reset(); //reset the timer
            }
        }
    }
    //runs continuously during 'test' mode. DO NOT USE!!!
    public void testPeriodic() {
    
    }
    
}
