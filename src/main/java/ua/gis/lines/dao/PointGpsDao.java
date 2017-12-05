package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.base.PointGPS;

public interface PointGpsDao extends JpaRepository<PointGPS, Integer> {
}
