package sampleapplication.domain;

import java.io.Serializable;

public class Volume implements Serializable {

    private static final long serialVersionUID = 1L;

    public Volume() {
        value = 0;
    }

    public Volume(double value) {
        this.value = value;
    }

    private double value;

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
