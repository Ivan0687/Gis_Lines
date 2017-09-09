package ua.gis.lines.model;

import java.util.Set;

public class TransmitLine extends WithId{

    private Set<Tower> towers;
    private PowerLine powerLine;

    public Set<Tower> getTowers() {
        return towers;
    }

    public void setTowers(Set<Tower> towers) {
        this.towers = towers;
    }

    public PowerLine getPowerLine() {
        return powerLine;
    }

    public void setPowerLine(PowerLine powerLine) {
        this.powerLine = powerLine;
    }
}
