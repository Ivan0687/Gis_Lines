package ua.gis.lines.dao.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.parts.Fitting;

/**
 * Data access object for {@link Fitting}
 * @author Boiko Ival
 */

public interface FittingDao extends JpaRepository<Fitting, Integer> {

}
