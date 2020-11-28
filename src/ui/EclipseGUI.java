package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import model.DayCycle;
import model.Moon;
import threads.DayCycleThread;
import threads.MoonThread;
import threads.SliderThread;

public class EclipseGUI {
    private Moon m;
    private DayCycle d;
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
    
    @FXML
    private Slider slider;


    private boolean isBouncing;


    public EclipseGUI() {
        
    }

    @FXML
    void startButton(ActionEvent event) {
    	isBouncing=true;
    	SliderThread sThread = new SliderThread(this);
    	sThread.start();
        MoonThread bt = new MoonThread(this,m);
        m.setMoving(true);
        m.setMax(background.getWidth());
        bt.start();
        DayCycleThread dt = new DayCycleThread(this,d);
        dt.start();
    }

    @FXML
    void stopButton(ActionEvent event) {
    	isBouncing=false;
    	m.setMoving(false);
    }

    public void dayCycle(){
        int r = 0;
        int g = 0;

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
    
    public Slider getSlider() {
    	return slider;
    }

    public void updateBall(){
        moon.setLayoutX(m.getX());
    }
    
    public void updateSpeed(long sleep) {
    	m.setSleep(sleep);
    }

    public void initialize(){
        m = new Moon(moon.getLayoutX(),50,5,background.getWidth(),moon.getRadius());
        d = new DayCycle(125,255,117,1000);

    }


}