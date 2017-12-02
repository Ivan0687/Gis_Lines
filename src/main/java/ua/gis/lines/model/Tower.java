package ua.gis.lines.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "towers")
public class Tower extends WithId{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tower_center_gps_coordinates_id")
    private PointGPS gps;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tower_mark_id")
    private TowerMark mark;

    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "tower_id")
    private Set<Junction> junctions;

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
}
