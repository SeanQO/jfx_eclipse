package threads;

import javafx.application.Platform;
import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	private EclipseGUI eGUI;
	private int r;
	private int g;
	private int b;
	private int steps;
	private int changeInR;
	private int changeInG;
	private int changeInB;
	private int[] RGB;
	
	
	public DayCycleThread(EclipseGUI eGUIP, int rP, int gP, int bP) {
		setDaemon(true);
		eGUI = eGUIP;
		r = rP;
		g = gP;
		b = bP;
		RGB = new int[3];
		RGB[0] = r;
		RGB[1] = g;
		RGB[2] = b;
		double distance=eGUI.getSun().getLayoutX()-eGUI.getSun().getRadius()*2;
		steps = (int)(distance/EclipseGUI.STEP);
		changeInR=r/steps;
		changeInG=g/steps;
		changeInB=b/steps;
	}
	
	public void run() {
		double positionOfTheMoon = eGUI.getMoon().getLayoutX();
		double positionOfTheSun = eGUI.getSun().getLayoutX();
		if(positionOfTheMoon>=positionOfTheSun && (r<RGB[0] || g<RGB[1] || b<RGB[2])) {
			clearSky();
		}else if(positionOfTheMoon>=eGUI.getSun().getRadius()*2 && positionOfTheMoon<positionOfTheSun) {
			darkenSky();
		}
		Platform.runLater(new Thread() {
			public void run() {
				//eGUI.updateBackgroung(r, g, b);
			}
		});
		eGUI.getBackground().setStyle("-fx-background-color: rgb("+r+","+g+","+b+")");
	}
	
	public void darkenSky() {
		r-=changeInR;
		g-=changeInG;
		b-=changeInB;
		if(r<0) {
			r=0;
		}
		if(g<0) {
			g=0;
		}
		if(b<0) {
			b=0;
		}
	}
	
	public void clearSky() {
		r+=changeInR;
		g+=changeInG;
		b+=changeInB;
		if(r>RGB[0]) {
			r=RGB[0];
		}
		if(g>RGB[1]) {
			g=RGB[1];
		}
		if(b>RGB[2]) {
			b=RGB[2];
		}	
	}
}
