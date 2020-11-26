package threads;

import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	private EclipseGUI eGUI;
	private int r;
	private int g;
	private int b;
	private int steps;
	
	public DayCycleThread(EclipseGUI eGUIP, int rP, int gP, int bP) {
		setDaemon(true);
		eGUI = eGUIP;
		r = rP;
		g = gP;
		b = bP;
		double distance=eGUIP.getSun().getLayoutX()-eGUIP.getSun().getRadius()*2;
		
	}
	
	public void run() {
		while(true) {
			if(eGUI.getMoon().getLayoutX()==184) {
				
			}
			eGUI.getBackground().setStyle("-fx-background-color: rgb("+r+","+g+","+b+")");
			changeRGB();
		}
	}
	
	public void changeRGB() {
		if(r==0) {
			
		}
	}
}
