package ua.gis.lines.model.parts;

import ua.gis.lines.model.base.WithId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wires")
public class Wire extends WithId {

    @Column
    private String mark;

    @Column(name = "weight_per_meter")
    private double weightPerMeter;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getWeightPerMeter() {
        return weightPerMeter;
    }

    public void setWeightPerMeter(double weightPerMeter) {
        this.weightPerMeter = weightPerMeter;
    }

    @Override
    public String toString() {
        return "Wire{" + super.toString() +
                ", mark = '" + mark + '\'' +
                ", weightPerMeter = " + weightPerMeter +
                "} " ;
    }
}
