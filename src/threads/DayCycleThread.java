package threads;

import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	private EclipseGUI eGUI;
	private int r;
	private int g;
	private int b;
	
	public DayCycleThread(EclipseGUI eGUIP, int rP, int gP, int bP) {
		setDaemon(true);
		eGUI = eGUIP;
		r = rP;
		g = gP;
		b = bP;
	}
	
	public void run() {
		while(true) {
			if() {
				
			}
			eGUI.getBackground().setStyle("-fx-background-color: rgb(253, 255, 117)");
			
		}
	}
}
