package ua.gis.lines.model;

import javax.persistence.*;

@Entity
@Table(name = "spans")
public class Span extends WithId{

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "begin_junction_id")
    private Junction begin;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_junction_id")
    private Junction end;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "wire_id")
    private Wire wire;

    @Transient
    private double length;


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
