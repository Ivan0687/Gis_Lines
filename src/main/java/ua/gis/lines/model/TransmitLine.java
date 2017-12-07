package ua.gis.lines.model;

import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.unused.Span;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "transmit_lines")
public class TransmitLine extends WithId {

    @Column
    private int voltage;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_line_id")
    private TransmitLine master;

    @OneToOne
    @JoinColumn(name = "begin_id")
    private Hub begin;

    @OneToOne
    @JoinColumn(name = "end_id")
    private Hub end;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "transmit_lines_has_towers", joinColumns = @JoinColumn(name = "transmit_line_id"))
    @MapKeyColumn(name = "number")
    private Map<Integer, Tower> towers;

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public TransmitLine getMaster() {
        return master;
    }

    public void setMaster(TransmitLine master) {
        this.master = master;
    }

    public Hub getBegin() {
        return begin;
    }

    public void setBegin(Hub begin) {
        this.begin = begin;
    }

    public Hub getEnd() {
        return end;
    }

    public void setEnd(Hub end) {
        this.end = end;
    }

    public Map<Integer, Tower> getTowers() {
        return towers;
    }

    public void setTowers(Map<Integer, Tower> towers) {
        this.towers = towers;
    }

    @Override
    public String toString() {
        return "TransmitLine{" + super.toString()+
                ", voltage=" + voltage +
                ", master=" + master +
                "," + begin +
                "-" + end +
                ", towers=" + towers +
                "} " ;
    }
}
