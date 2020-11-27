package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.Moon;
import threads.DayCycleThread;
import thread.MoonThread;

public class EclipseGUI {
    private Moon m;
    private Stage st;
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


    public EclipseGUI(Stage primaryStage) {
        st = primaryStage;
    }

    @FXML
    void startButton(ActionEvent event) {
    	isBouncing=true;
    	new DayCycleThread(this, 243, 245, 127).start();
    }

    @FXML
    void stopButton(ActionEvent event) {
    	isBouncing=false;
    }
    
    public void moveMoon() {
        MoonThread bt = new MoonThread(this,m);
        m.setMoving(true);
        m.setMax(st.getWidth());
        bt.start();
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

    public void updateBall(){
        moon.setLayoutX(m.getX());
    }

    public void initialize(){
        m = new Moon(moon.getLayoutX(),50,5,st.getWidth(),moon.getRadius());
    }

    public void setSt(Stage st) {
        this.st = st;
    }

}