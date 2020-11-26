package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import threads.DayCycleThread;

public class EclipseGUI {
	
	public final static double STEP = 5;

    @FXML
    private AnchorPane background;

    @FXML
    private Circle sun;

    @FXML
    private Circle moon;

    @FXML
    private Circle star4;

    @FXML
    private Circle star3;

    @FXML
    private Circle star1;

    @FXML
    private Circle star2;

    @FXML
    private Circle star;


    private boolean isBouncing;

    @FXML
    void startButton(ActionEvent event) {
    	isBouncing=true;
    	new DayCycleThread(this, 243, 245, 127).start();
    }

    @FXML
    void stopButton(ActionEvent event) {
    	isBouncing=false;
    }
    
    public void moveBall() {
    	
    }
    
    public boolean isBouncing() {
    	return isBouncing;
    }
    
    public AnchorPane getBackground() {
    	return background;
    }
    
    public Circle getMoon() {
    	return moon;
    }
    
    public Circle getSun() {
    	return sun;
    }

}