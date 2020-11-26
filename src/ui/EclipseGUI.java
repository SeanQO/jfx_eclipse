package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

public class EclipseGUI {

    @FXML
    private AnchorPane background;

    @FXML
    private Circle sun;

    @FXML
    private Circle moon;
    
    private boolean isBouncing;

    @FXML
    void startButton(ActionEvent event) {
    	isBouncing=true;
    }

    @FXML
    void stopButton(ActionEvent event) {
    	isBouncing=false;
    }
    
    public boolean isBouncing() {
    	return isBouncing;
    }

}