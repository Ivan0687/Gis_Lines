package ua.gis.lines.model.unused;

import ua.gis.lines.model.Tower;
import ua.gis.lines.model.base.WithId;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "spans")
public class Span extends WithId implements Comparable<Span> {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "begin_tower_id")
    private Tower begin;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "end_tower_id")
    private Tower end;

    //TODO
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "junctions_has_fittings", joinColumns = @JoinColumn(name = "junction_id"))
//    @MapKeyJoinColumn(name = "fitting_id")
//    @Column(name = "fittings_quantity")
//    private Map<Fitting, Integer> fittings = new HashMap<>();

//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "links", joinColumns = @JoinColumn(name = "span_id"))
//    @MapKeyColumn(name = "phase")
//    @Column()
//    private Map<Phase, Set<Link>> links = new HashMap<>();

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "span_id")
    private Set<Link> linksSet = new HashSet<>();

    public Tower getBegin() {
        return begin;
    }

    public void setBegin(Tower begin) {
        this.begin = begin;
    }

    public Tower getEnd() {
        return end;
    }

    public void setEnd(Tower end) {
        this.end = end;
    }

//    public Map<Phase, Set<Link>> getLinks() {
//        return links;
//    }
//
//    public void setLinks(Map<Phase, Set<Link>> links) {
//        this.links = links;
//    }


    public Set<Link> getLinksSet() {
        return linksSet;
    }

    public void setLinksSet(Set<Link> linksSet) {
        this.linksSet = linksSet;
    }

    @Override
    public String toString() {
        return "Span{" + super.toString() +
                ", begin=" + begin.getId() +
                ", end=" + end.getId() +
                ", linksSet=" + linksSet +
                "} " ;
    }

    @Override
    public int compareTo(Span o) {
        int result;
        result = getBegin().compareTo(o.getBegin());
        if (result != 0) return result;
        result = getEnd().compareTo(o.getEnd());
        if (result != 0) return result;
        result = Integer.compare(getId(), o.getId());
        return result;
    }
}
