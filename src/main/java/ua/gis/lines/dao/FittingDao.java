package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Fitting;

/**
 * Data access object for {@link Fitting}
 * @author Boiko Ival
 */

public interface FittingDao extends JpaRepository<Fitting, Integer> {
}
