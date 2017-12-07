package ua.gis.lines.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.gis.lines.model.TransmitLine;

public interface TransmitLineDao extends JpaRepository<TransmitLine, Integer>{
}
