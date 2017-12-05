package ua.gis.lines.model;

import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.parts.TowerMark;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "towers")
public class Tower extends WithId implements Comparable<Tower> {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tower_center_gps_coordinates_id")
    private PointGPS gps;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tower_mark_id")
    private TowerMark mark;

    @OneToMany(fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    @JoinColumn(name = "tower_id")
    private Set<Junction> junctions = new HashSet<>();

    public PointGPS getGps() {
        return gps;
    }

    public void setGps(PointGPS gps) {
        this.gps = gps;
    }

    public TowerMark getMark() {
        return mark;
    }

    public void setMark(TowerMark mark) {
        this.mark = mark;
    }

    public Set<Junction> getJunctions() {
        return junctions;
    }

    public void setJunctions(Set<Junction> junctions) {
        this.junctions = junctions;
    }

    @Override
    public String toString() {
        return "Tower{" + super.toString()+
                ", gps=" + gps +
                ", mark=" + mark +
                ", junctions=" + junctions +
                "} " ;
    }

    @Override
    public int compareTo(Tower o) {
        return Integer.compare(getId(), o.getId());
    }
}
