package ua.gis.lines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "gps_coordinates")
public class PointGPS extends WithId {

    @Column
    private double latitude;
    @Column
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointGPS)) return false;

        PointGPS pointGPS = (PointGPS) o;

        if (Double.compare(pointGPS.getLatitude(), getLatitude()) != 0) return false;
        return Double.compare(pointGPS.getLongitude(), getLongitude()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getLatitude());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getLongitude());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PointGPS{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
