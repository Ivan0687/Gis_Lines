package ua.gis.lines.model.unused;

import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.enums.Phase;
import ua.gis.lines.model.parts.Wire;

import javax.persistence.*;

@Entity
@Table(name = "links")
public class Link extends WithId {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "begin_junction_id")
    private Junction begin;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_junction_id")
    private Junction end;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wire_id")
    private Wire wire;

    @Column(name = "phase")
    @Enumerated(EnumType.STRING)
    private Phase phase;


    public Junction getBegin() {
        return begin;
    }

    public void setBegin(Junction begin) {
        this.begin = begin;
    }

    public Junction getEnd() {
        return end;
    }

    public void setEnd(Junction end) {
        this.end = end;
    }

    public Wire getWire() {
        return wire;
    }

    public void setWire(Wire wire) {
        this.wire = wire;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public double getWeight(){ return getLength() * getWire().getWeightPerMeter();}

    public double getLength() {
        return calculateDistanceGps(getBegin().getGps(), getEnd().getGps());
    } //TODO

    public double calculateDistanceGps(PointGPS begin, PointGPS end){
        return 0; //TODO
    }

    @Override
    public String toString() {
        return "Link{" + super.toString() +
                ", begin=" + begin.getId() +
                ", end=" + end.getId() +
                ", wire=" + wire.getMark() +
                ", phase=" + phase +
                "} ";
    }
}
