package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.TowerMark;

public interface TowerMarkDao extends JpaRepository<TowerMark, Integer> {
}
