package threads;

import model.Star;
import ui.EclipseGUI;

public class StarThread extends Thread{
	private EclipseGUI eGUI;
	private Star star;
	
	public StarThread(EclipseGUI eGUIP, Star star) {
		setDaemon(true);
		eGUI=eGUIP;
		this.star = star;
	}
	
	public void run() {
		while (eGUI.isNigth()) {
			
			star.twinkle();
			try {
                Thread.sleep(star.getSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			
		}
	}
}
