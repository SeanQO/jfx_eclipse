package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.DayCycle;
import model.Moon;
import threads.MoonThread;
import threads.SliderThread;

public class EclipseGUI {
    private Moon m;
    private DayCycle d;
    private boolean isBouncing;
    private boolean brightness;
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

    @FXML
    private Color color;

    @FXML
    private Rectangle sky;

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
    }


    @FXML
    void stopButton(ActionEvent event) {
    	isBouncing=false;
    	m.setMoving(false);
    }

    public Color getColor() {
        return color;
    }

    public Rectangle getSky() {
        return sky;
    }

    public void star(){
        brightness = !brightness;
        star.setVisible(brightness);
    }

    public void star1(){
        brightness = !brightness;
        star1.setVisible(brightness);
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
    
    public Slider getSlider() {
    	return slider;
    }

    public void updateBall(){
        moon.setLayoutX(m.getX());
        if(moon.getLayoutX() >= sun.getLayoutX() - sun.getRadius() && moon.getLayoutX() <= sun.getLayoutX()) {
            color = color.darker();
        }
        else {
            color = color.brighter();
        }
        sky.setFill(color);
        star();
    }
    
    public void updateSpeed(long sleep) {
    	m.setSleep(sleep);
    }

    public void initialize(){
        m = new Moon(moon.getLayoutX(),50,5,background.getWidth(),moon.getRadius());
        color = (Color)sky.getFill();
    }

}