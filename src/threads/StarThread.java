package threads;

import ui.EclipseGUI;

public class StarThread extends Thread{
	private EclipseGUI eGUI;
	public StarThread(EclipseGUI eGUIP) {
		setDaemon(true);
		eGUI=eGUIP;
	}
	
	
}
