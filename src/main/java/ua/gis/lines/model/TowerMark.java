package ua.gis.lines.model;

import javax.persistence.*;

@Entity
@Table(name = "tower_marks")
public class TowerMark extends WithId{

    private String mark;
    private double height;
    private double wight;

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
        return wight;
    }

    public void setWight(double wight) {
        this.wight = wight;
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
}
