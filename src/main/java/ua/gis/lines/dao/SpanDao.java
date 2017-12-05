package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Span;

public interface SpanDao extends JpaRepository<Span, Integer> {
}
