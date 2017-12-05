package ua.gis.lines.model.parts;

import ua.gis.lines.model.base.WithId;

import javax.persistence.*;

/**
 * Fitting entity
 * @author Boiko Ivan
 */

@Entity
@Table(name = "fittings")
public class Fitting extends WithId {

    @Column
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
