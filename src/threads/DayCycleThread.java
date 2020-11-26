package threads;

import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	EclipseGUI eGUI;
	
	public DayCycleThread(EclipseGUI eGUIP) {
		setDaemon(true);
		eGUI = eGUIP;
	}
	
	public void run() {
		
	}
}
