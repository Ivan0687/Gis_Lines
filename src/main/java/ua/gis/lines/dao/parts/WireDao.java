package ua.gis.lines.dao.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.parts.Wire;

/**
 * Data access object for {@link Wire}
 * @author Boiko Ivan
 */

public interface WireDao extends JpaRepository<Wire, Integer> {
}
