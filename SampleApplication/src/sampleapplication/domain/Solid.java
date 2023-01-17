package sampleapplication.domain;

import java.io.Serializable;

public class Solid implements Serializable {

    private static final long serialVersionUID = 1L;

    public Solid() {
    }

    public Solid(double length, double hight, double width) {
        this.length = length;
        this.hight = hight;
        this.width = width;
    }

    private double length;
    private double hight;
    private double width;

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHight() {
        return hight;
    }

    public void setHight(double hight) {
        this.hight = hight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
