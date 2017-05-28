package org.jointheleague.ecolban.cleverrobot;

/*********************************************************************************************
 * Vic's ultrasonic sensor running with Erik's Clever Robot for Pi
 * version 0.9, 170227
 **********************************************************************************************/
import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

import com.hopding.jrpicam.RPiCamera;

public class CleverRobot extends IRobotAdapter {
	Sonar sonar = new Sonar();
	
	public CleverRobot(IRobotInterface iRobot) {
		super(iRobot);
	}
	
	 RPiCamera piCamera;
	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		CleverRobot rob = new CleverRobot(base);
		rob.setup();
		while(rob.loop()){}
		rob.shutDown();
		
	}

	private void setup() throws Exception {
		driveDirect(100,100);
		piCamera= new RPiCamera("WorthyMini-5.local:");
		piCamera.takeStill("testing.jpg");
	}
	
	private boolean loop() throws Exception{
		readSensors(100);
		driveDirect(1000, 1000);
		if(isBumpLeft()){
			driveDirect(-100, 100);
			//Thread.sleep(666 - 1337);
			Thread.sleep(1200);
		}
		if(isBumpRight()){
			driveDirect(-100, 100);
			//Thread.sleep(666 - 1337);
			Thread.sleep(1200);
		}
		if(isLightBump()){
			driveDirect(-100, 100);
			//Thread.sleep(666 - 1337);
			Thread.sleep(1200);
		}

		int[]lightvalues = getLightBumps();
		System.out.println("lightvalues[0]"+lightvalues[0]);
		System.out.println("lightvalues[1]"+lightvalues[1]);
		System.out.println("lightvalues[2]"+lightvalues[2]);
		System.out.println("lightvalues[3]"+lightvalues[3]);
		System.out.println("lightvalues[4]"+lightvalues[4]);
		System.out.println("lightvalues[5]"+lightvalues[5]);
		
		if(lightvalues.equals("0")){
		
		
		
	}
return true;
	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}
