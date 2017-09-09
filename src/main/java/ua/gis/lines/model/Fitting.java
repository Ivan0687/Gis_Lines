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

    //@ManyToMany(fetch = FetchType.EAGER, mappedBy = "fittings")
    //private Set<Junction> junctions = new HashSet<>();

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

//    public Set<Junction> getJunctions() {
//        return junctions;
//    }

//    public void setJunctions(Set<Junction> junctions) {
//        this.junctions = junctions;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Fitting fitting = (Fitting) o;
//
//        if (mark != null ? !mark.equals(fitting.mark) : fitting.mark != null) return false;
//        return junctions != null ? junctions.equals(fitting.junctions) : fitting.junctions == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = mark != null ? mark.hashCode() : 0;
//        result = 31 * result + (junctions != null ? junctions.hashCode() : 0);
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Fitting{" +
//                "mark='" + mark + '\'' +
//                ", junctions=" + junctions.size() +
//                '}';
//    }
}
