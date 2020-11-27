package model;

public class Moon {

    private double x ;
    private long sleep;
    private int step;
    private int direction;
    public static int LEFT = -1;
    public static int RIGHT = 1;
    private double max;
    private double radius;
    private boolean moving;

    public Moon(double x, long sleep, int step, double max, double radius) {
        this.x = x;
        this.sleep = sleep;
        this.step = step;
        this.max = max;
        this.radius = radius;
        direction = LEFT;
        moving = false;
    }
    public void move(){
        x = x + direction*step;
        System.out.println("x: " + x);
        System.out.println("max: " + max);
        if (x-radius<0){
            x=radius;
            direction = RIGHT;
        }
        if ((x + radius) > max){
            x = max - radius;
            direction = LEFT;
        }
    }

    public double getX() {
        return x;
    }

    public long getSleep() {
        return sleep;
    }

    public int getStep() {
        return step;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setMax(double max) {
        this.max = max;
    }
}
