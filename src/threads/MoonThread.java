package threads;

import ui.EclipseGUI;

public class MoonThread extends Thread {
    private EclipseGUI eGUI;

    public MoonThread(EclipseGUI eGUI) {
        this.eGUI = eGUI;
    }

    @Override
    public void run() {
        super.run();
    }
}
