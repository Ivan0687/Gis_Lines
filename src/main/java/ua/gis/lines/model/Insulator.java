package ua.gis.lines.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Insulator entity
 * @author Boiko Ivan
 */

@Entity
@Table(name = "insulators")
public class Insulator extends WithId{

    @Column
    private String mark;

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
