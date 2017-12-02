package ua.gis.lines.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Fitting entity
 * @author Boiko Ivan
 */

@Entity
@Table(name = "fittings")
public class Fitting extends WithId{

    @Column
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
