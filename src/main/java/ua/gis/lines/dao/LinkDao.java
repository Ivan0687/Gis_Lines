package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Link;

public interface LinkDao extends JpaRepository<Link, Integer> {
}
