package threads;

import javafx.application.Platform;
import model.DayCycle;
import model.Moon;
import ui.EclipseGUI;

public class DayCycleThread extends Thread{
	private EclipseGUI eGUI;
	private DayCycle dayCycle;
	private Moon moon;
	
	public DayCycleThread(EclipseGUI eGUIP, DayCycle dayCycle) {
		setDaemon(true);
		eGUI = eGUIP;
		this.dayCycle = dayCycle;
	}
	
	public void run() {

		//while (moon.isMoving()){
		while(eGUI.getMoon().getLayoutX() < 184 || dayCycle.getG() == 9  ){
				dayCycle.subtraction();
			eGUI.getBackground().setStyle("-fx-background-color: rgb("+dayCycle.getR()+","+dayCycle.getG()+","+dayCycle.getB()+")");


		}//else if(eGUI.getMoon().getLayoutX() > 184){
				//dayCycle.sum();
			//eGUI.getBackground().setStyle("-fx-background-color: rgb("+dayCycle.getR()+","+dayCycle.getG()+","+dayCycle.getB()+")");
		//}

			//dayCycle.changeColor();
			try {
				Thread.sleep(dayCycle.getSleep());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}

	}
}
