package ua.gis.lines.model;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Junction entity
 * @author Boiko Ivan
 */

@Entity
@Table(name = "junctions")
public class Junction extends WithId{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "gps_coordinates_id")
    private PointGPS gps;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "junctions_has_fittings", joinColumns = @JoinColumn(name = "junction_id"))
    @MapKeyJoinColumn(name = "fitting_id")
    @Column(name = "fittings_quantity")
    private Map<Fitting, Integer> fittings = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "junctions_has_insulators", joinColumns = @JoinColumn(name = "junction_id"))
    @MapKeyJoinColumn(name = "insulator_id")
    @Column(name = "insulators_quantity")
    private Map<Insulator, Integer> insulators = new HashMap<>();

    public PointGPS getGps() {
        return gps;
    }

    public void setGps(PointGPS gps) {
        this.gps = gps;
    }

    public Map<Fitting, Integer> getFittings() {
        return fittings;
    }

    public void setFittings(Map<Fitting, Integer> fittings) {
        this.fittings = fittings;
    }

    public Map<Insulator, Integer> getInsulators() {
        return insulators;
    }

    public void setInsulators(Map<Insulator, Integer> insulators) {
        this.insulators = insulators;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Junction junction = (Junction) o;

        if (gps != null ? !gps.equals(junction.gps) : junction.gps != null) return false;
        if (fittings != null ? !fittings.equals(junction.fittings) : junction.fittings != null) return false;
        return insulators != null ? insulators.equals(junction.insulators) : junction.insulators == null;
    }

    @Override
    public int hashCode() {
        int result = gps != null ? gps.hashCode() : 0;
        result = 31 * result + (fittings != null ? fittings.hashCode() : 0);
        result = 31 * result + (insulators != null ? insulators.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Junction{" +
                "gps=" + gps.getId() +
                ", fittings=" + fittings.keySet().size() +
                '}';
    }
}
