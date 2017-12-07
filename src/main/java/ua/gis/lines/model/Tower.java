package ua.gis.lines.model;

import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.enums.TowerType;
import ua.gis.lines.model.parts.TowerMark;
import ua.gis.lines.model.unused.Junction;

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

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TowerType type;

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

    public TowerType getType() {
        return type;
    }

    public void setType(TowerType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tower{" + super.toString()+
                ", gps=" + gps +
                ", mark=" + mark +
                "} " ;
    }

    @Override
    public int compareTo(Tower o) {
        return Integer.compare(getId(), o.getId());
    }
}
