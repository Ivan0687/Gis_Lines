package ua.gis.lines.model;

import java.util.Set;

public class PowerLine extends WithId{

    private Set<Span> spans;

    public Set<Span> getSpans() {
        return spans;
    }

    public void setSpans(Set<Span> spans) {
        this.spans = spans;
    }
}
