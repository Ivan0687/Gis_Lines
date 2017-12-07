package ua.gis.lines.dao.parts;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.parts.TowerMark;

public interface TowerMarkDao extends JpaRepository<TowerMark, Integer>{
}
