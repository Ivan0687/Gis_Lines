package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Junction;

/**
 * Data access object for {@link Junction}
 * @author Boiko Ivan
 */

public interface JunctionDao extends JpaRepository<Junction, Integer> {
}
