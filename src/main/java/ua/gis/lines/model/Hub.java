package ua.gis.lines.model;

import ua.gis.lines.model.base.WithId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "hubs")
public class Hub extends WithId{

    @Column
    private String name;

    public Hub() {
    }

    public Hub(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
