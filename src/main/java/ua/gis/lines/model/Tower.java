package ua.gis.lines.model;

import java.util.Set;

public class Tower extends WithId{

    private TowerMark mark;

    private Set<Junction> junctions;

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
