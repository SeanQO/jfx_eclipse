package threads;

import ui.EclipseGUI;

public class SliderThread extends Thread{
	private EclipseGUI eGui;
	
	public SliderThread(EclipseGUI eGui) {
		setDaemon(true);
		this.eGui = eGui;
		
	}
	
	@Override
    public void run() {
        while (eGui.isBouncing()){
        	
        	//adding one to avoid reaching 0, causes malfunction 
            double sliderValue =  100 - (eGui.getSlider().getValue() - 1);
        	
            eGui.updateSpeed((long)sliderValue);
            
        }
    }
	
}