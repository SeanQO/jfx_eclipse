package model;

public class DayCycle {
    private double r;
    private double g;
    private double b;
    private long sleep;
    private Moon moon;

    public DayCycle(double r, double g, double b, long sleep) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.sleep = sleep;
    }

    public long getSleep() {
        return sleep;
    }

    public void setSleep(long sleep) {
        this.sleep = sleep;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public void subtraction(){
            r--;
            g--;
            b--;

    }

    public void sum(){
            r++;
            g++;
            b++;
    }
}
