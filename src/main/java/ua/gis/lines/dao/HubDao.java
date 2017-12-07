package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.Hub;

public interface HubDao extends JpaRepository<Hub, Integer> {
}
