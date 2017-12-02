package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Insulator;

public interface InsulatorDao extends JpaRepository<Insulator, Integer> {
}
