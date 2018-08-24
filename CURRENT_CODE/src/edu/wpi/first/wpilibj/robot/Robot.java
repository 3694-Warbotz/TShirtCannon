
package edu.wpi.first.wpilibj.robot;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.commands.ArcadeDrive;
import edu.wpi.first.wpilibj.commands.TankDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.subsystems.DriveTrain;

public class Robot extends IterativeRobot {
    
    //Create Objects
    public static DriveTrain driveTrain; //Create the DriveTrain object
    public static OI OI; //Create the OperatorInterface object
    
    //Drive Chooser
    private SendableChooser teleopChooser; //Create a SendableChooser for choosing drive
    Command teleopChosen; //Create a teleop command
    
    
    //Runs once on robot start
    public void robotInit() {
        //Instantiate Objects
        driveTrain = new DriveTrain(); //Instantiate DriveTrain
        OI = new OI(); //Instantiate the Operator Interface
        teleopChooser = new SendableChooser(); //Instantiate the sendable chooser
        teleopChosen = (Command) teleopChooser.getSelected(); //instantiate the command to be equivalent to the selection for teleop driving
        
        //Create the choices for the teleopChooser
        teleopChooser.addDefault("Tank Drive", new TankDrive()); //Add tank driving as the default choice for drive
        teleopChooser.addObject("Arcade Drive", new ArcadeDrive()); //Add arcade driving as another choice for drive
        SmartDashboard.putData("Teleop", teleopChooser); //Post the data from the teleopChooser to the smartdashboard
    }

    //runs continuously during autonomous
    public void autonomousPeriodic() {

    }

    //runs continuously during teleop
    public void teleopPeriodic() {
        teleopChosen.start(); //start the teleop command
    }
    
    //runs continuously during 'test' mode. DO NOT USE!!!
    public void testPeriodic() {
    
    }
    
}
