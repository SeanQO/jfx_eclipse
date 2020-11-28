package ui;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import model.Moon;
import threads.MoonThread;
import threads.SliderThread;

public class EclipseGUI {
    private Moon m;
    private boolean isBouncing;
    private boolean brightness;

    @FXML
    private AnchorPane background;

    @FXML
    private Circle sun;

    @FXML
    private Circle moon;

    @FXML
    private Slider slider;

    @FXML
    private Color color;

    @FXML
    private Rectangle sky;

    @FXML
    private Circle star;

    @FXML
    private Circle star1;

    @FXML
    private Circle star2;

    @FXML
    private Circle star3;

    @FXML
    private Circle star4;

    @FXML
    private Circle vesicle;

    @FXML
    private Circle vesicle1;

    @FXML
    private Circle vesicle2;

    @FXML
    private Circle vesicle3;

    public EclipseGUI() {

    }

    @FXML
    void startButton() {
        isBouncing = true;
        SliderThread sThread = new SliderThread(this);
        sThread.start();
        MoonThread bt = new MoonThread(this, m);
        m.setMoving(true);
        //m.setMax(background.getWidth());
        bt.start();
    }

    @FXML
    void stopButton() {
        isBouncing = false;
        m.setMoving(false);
    }

    public void star() {
        brightness = !brightness;
        star.setVisible(brightness);
        star2.setVisible(brightness);
    }

    public boolean isBouncing() {
        return isBouncing;
    }

    public Slider getSlider() {
        return slider;
    }

    public void updateBall() {
        moon.setLayoutX(m.getX());
        vesicle.setLayoutX(m.getX()-20);
        vesicle1.setLayoutX(m.getX());
        vesicle2.setLayoutX(m.getX());
        vesicle3.setLayoutX(m.getX()+10);

        if (moon.getLayoutX() >= sun.getLayoutX() - sun.getRadius() && moon.getLayoutX() <= sun.getLayoutX()) {
            color = color.darker();
            star1.setVisible(true);
            star3.setVisible(true);
            star4.setVisible(true);
            star();
        } else {
            color = color.brighter();
            star.setVisible(false);
            star1.setVisible(false);
            star2.setVisible(false);
            star3.setVisible(false);
            star4.setVisible(false);
        }
        sky.setFill(color);
    }

    public void updateSpeed(long sleep) {
        m.setSleep(sleep);
    }

    public void initialize() {
        m = new Moon(moon.getLayoutX(), 50, 5, background.getWidth(), moon.getRadius());
        color = (Color) sky.getFill();
        star.setVisible(false);
        star1.setVisible(false);
        star2.setVisible(false);
        star3.setVisible(false);
        star4.setVisible(false);
    }
}