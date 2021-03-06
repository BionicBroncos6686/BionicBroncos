package org.usfirst.frc.team6686.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	RobotDrive myRobot = new RobotDrive(3, 2, 1, 0);
	public static Joystick stick = new Joystick(0);
	Timer timer = new Timer();
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		myRobot.setExpiration(0.5);
	}
	
	//Mistake
	
	/*public void autonomous(){
		System.out.println("Robot.autonomous()");
		
		myRobot.setSafetyEnabled(false);
		myRobot.arcadeDrive(0.5, 0.0);
		Timer.delay(2.0);
		myRobot.arcadeDrive(-0.5, 0.0);
		Timer.delay(2.0);
		myRobot.arcadeDrive(0.0, 0.0);
	}
	*/

	/**
	 * This function is run once each time the robot enters autonomous mode
	 */
	@Override
	public void autonomousInit() {
		timer.reset();
		timer.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		// Drive for 2 seconds
		if (timer.get() < 1.5) {
			myRobot.arcadeDrive(0.8, 0.0); // drive forwards half speed
		}
		else{
			myRobot.arcadeDrive(0, 0);
		}
	}

	/**
	 * This function is called once each time the robot enters tele-operated
	 * mode
	 */
	@Override
	public void teleopInit() {
		timer.reset();
		timer.start();
		System.out.println("TELEOP INITIATED!");
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		//Stick Turning:
		
		
		//Forward (and Forward Turns)
		if(stick.getRawAxis(1) < -0.5)
		{
			if(stick.getRawAxis(0) < 0.5 && stick.getRawAxis(0) > -0.5){
				myRobot.arcadeDrive(stick.getRawAxis(1) * -1, 0);
			}
			else if(stick.getRawAxis(0) > 0.5){
				myRobot.arcadeDrive(stick.getRawAxis(1) * -1, -0.5); //Right
			}
			else if(stick.getRawAxis(0) < -0.5){
				myRobot.arcadeDrive(stick.getRawAxis(1) * -1, 0.5); //Right
			}
		}
		//Back (and Back Turns)
		else if(stick.getRawAxis(1) > 0.5)
		{
			if(stick.getRawAxis(0) < 0.5 && stick.getRawAxis(0) > -0.5){
				myRobot.arcadeDrive((stick.getRawAxis(1) * -1), 0);
			}
			else if(stick.getRawAxis(0) > 0.5){
				myRobot.arcadeDrive(stick.getRawAxis(1) * -1, -0.5); //Right
			}
			else if(stick.getRawAxis(0) < -0.5){
				myRobot.arcadeDrive(stick.getRawAxis(1) * -1, 0.5); //Right
			}
		}
		//Just Right
		else if(stick.getRawAxis(0) > 0.5)
		{
			myRobot.arcadeDrive(0.65, -0.65);
		}
		//Just Left
		else if(stick.getRawAxis(0) < -0.5)
		{
			myRobot.arcadeDrive(-0.65, 0.65);
		}
		
		
		else{
			myRobot.arcadeDrive(0, 0);
		}
	}

	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		LiveWindow.run();
	}
}
