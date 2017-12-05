package ua.gis.lines.model.parts;

import ua.gis.lines.model.base.WithId;
import ua.gis.lines.model.enums.TowerMaterial;
import ua.gis.lines.model.enums.TowerType;

import javax.persistence.*;

@Entity
@Table(name = "tower_marks")
public class TowerMark extends WithId {

    @Column
    private String mark;
    @Column
    private double height;
    @Column
    private double weight;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TowerType type;

    @Column(name = "material")
    @Enumerated(EnumType.STRING)
    private TowerMaterial material;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWight() {
        return weight;
    }

    public void setWight(double wight) {
        this.weight = wight;
    }

    public TowerType getType() {
        return type;
    }

    public void setType(TowerType type) {
        this.type = type;
    }

    public TowerMaterial getMaterial() {
        return material;
    }

    public void setMaterial(TowerMaterial material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "TowerMark{" + super.toString() +
                ", mark='" + mark + '\'' +
                ", height=" + height +
                ", wight=" + weight +
                ", type=" + type +
                ", material=" + material +
                "} " ;
    }
}
