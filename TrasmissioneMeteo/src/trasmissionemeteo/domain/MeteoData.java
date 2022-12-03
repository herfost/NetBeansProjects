package trasmissionemeteo.domain;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import trasmissionemeteo.persistence.IPersistenceObject;

public class MeteoData implements IPersistenceObject<String> {

    private final String uid;
    private double temperature;
    private double umidity;

    public MeteoData(String uid, double temperature, double umidity) {
        this.uid = uid;
        this.temperature = temperature;
        this.umidity = umidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getUmidity() {
        return umidity;
    }

    public void setUmidity(double umidity) {
        this.umidity = umidity;
    }

    @Override
    public String getKey() {
        return uid;
    }

    @Override
    public Object getClone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(MeteoData.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final MeteoData other = (MeteoData) obj;
        if (!Objects.equals(this.uid, other.uid)) {
            return false;
        }
        
        if (!Objects.equals(this.umidity, other.getUmidity())) {
            return false;
        }
        
        return Objects.equals(this.temperature, other.getTemperature());
    }

    @Override
    public String toString() {
        return "MeteoData {" + "uid=" + uid + ", temperature=" + temperature + ", umidity=" + umidity + " }";
    }
}
