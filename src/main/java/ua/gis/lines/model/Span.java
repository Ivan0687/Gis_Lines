package ua.gis.lines.model;

import javax.persistence.*;

@Entity
@Table(name = "spans")
public class Span extends WithId{

    @Column
    private Junction begin;

    @Column
    private Junction end;

    @Transient
    private double length;

    private Wire wire;

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

    public double getLength() {
        return length;
    }
}
