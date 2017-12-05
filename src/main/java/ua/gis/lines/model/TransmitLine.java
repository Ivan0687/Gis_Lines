package ua.gis.lines.model;

import ua.gis.lines.model.base.WithId;

import javax.persistence.*;
import java.util.Set;
import java.util.TreeSet;

@Entity
@Table(name = "transmit_lines")
public class TransmitLine extends WithId {

    @Column
    private int voltage;

    @Column
    private String begin;

    @Column
    private String end;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transmit_lines_has_towers",
            joinColumns = @JoinColumn(name = "transmit_line_id"),
            inverseJoinColumns = @JoinColumn(name = "tower_id"))
    private Set<Tower> towers = new TreeSet<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "transmit_line_id")
    private Set<Span> spans = new TreeSet<>();

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Set<Tower> getTowers() {
        return towers;
    }

    public void setTowers(Set<Tower> towers) {
        this.towers = towers;
    }

    public Set<Span> getSpans() {
        return spans;
    }

    public void setSpans(Set<Span> spans) {
        this.spans = spans;
    }
}
