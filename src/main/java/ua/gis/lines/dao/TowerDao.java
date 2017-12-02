package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Tower;

public interface TowerDao extends JpaRepository<Tower, Integer> {
}
