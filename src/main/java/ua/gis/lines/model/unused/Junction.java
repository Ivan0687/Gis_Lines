package ua.gis.lines.model.unused;

import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.enums.Phase;
import ua.gis.lines.model.parts.Fitting;
import ua.gis.lines.model.parts.Insulator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Junction entity
 * @author Boiko Ivan
 */

@Entity
@Table(name = "junctions")
public class Junction extends WithId {

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

    @Column(name = "phase")
    @Enumerated(EnumType.ORDINAL)
    private Phase phase;

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

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Junction)) return false;
        if (!super.equals(o)) return false;

        Junction junction = (Junction) o;

        if (getGps() != null ? !getGps().equals(junction.getGps()) : junction.getGps() != null) return false;
        return getPhase() == junction.getPhase();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getGps() != null ? getGps().hashCode() : 0);
        result = 31 * result + (getPhase() != null ? getPhase().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Junction{" + super.toString() +
                ", gps = " + gps +
                ", fittings = " + fittings.keySet().size() +
                ", insulators = " + insulators.keySet().size() +
//                ", phase = " + phase.toString() +
                "} " ;
    }
}
