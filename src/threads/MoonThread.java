package thread;

import model.Moon;
import ui.EclipseGUI;

public class MoonThread extends Thread{
    private EclipseGUI moonGUI;
    private Moon moon;

    public MoonThread(EclipseGUI moonGUI, Moon moon) {
        this.moonGUI = moonGUI;
        this.moon = moon;
    }

    @Override
    public void run() {
        while (moon.isMoving()){
            moon.move();
            moonGUI.updateBall();
            //System.out.println(ball.getSleep());
            try {
                Thread.sleep(moon.getSleep());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
