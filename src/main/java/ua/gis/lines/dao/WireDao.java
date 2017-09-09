package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Wire;

/**
 * Data access object for {@link Wire}
 * @author Boiko Ivan
 */

public interface WireDao extends JpaRepository<Wire, Integer> {
}
