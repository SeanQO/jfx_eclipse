package threads;

import model.Moon;
import ui.EclipseGUI;

public class MoonThread extends Thread {
    private EclipseGUI eGUI;
    private Moon moon;

    public MoonThread(EclipseGUI eGUI, Moon moon) {
        this.eGUI = eGUI;
        this.moon = moon;
    }

    @Override
    public void run() {
        while (moon.isMoving()){
            moon.move();
            //eGUI.updateBall();
            //System.out.println(ball.getSleep());
            try {
                Thread.sleep(moon.getSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
