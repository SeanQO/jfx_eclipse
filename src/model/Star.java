package model;

public class Star {
	
    private long sleep;
    private boolean shining;
    
    public Star(long sleep) {
		this.sleep = sleep;
		shining = false;
		
	}
    
    public void twinkle() {
    	
    	shining = !shining;
    }
    
    // si la estrella no esta brillando, se le asignan los colores del background.
    public boolean isShining() {
    	
		return shining;
	}
    
    public long getSleep() {
    	return sleep;
    }
    
}
