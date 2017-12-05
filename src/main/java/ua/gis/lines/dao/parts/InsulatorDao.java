package ua.gis.lines.dao.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.parts.Insulator;

public interface InsulatorDao extends JpaRepository<Insulator, Integer> {
}
