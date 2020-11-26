package threads;

import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	EclipseGUI eGUI;
	
	public DayCycleThread(EclipseGUI eGUIP) {
		setDaemon(true);
		eGUI = eGUIP;
	}
	
	public void run() {
		while(true) {
			eGUI.getBackground().setStyle("-fx-background-color: rgb(253, 255, 117)");
			
		}
	}
}
