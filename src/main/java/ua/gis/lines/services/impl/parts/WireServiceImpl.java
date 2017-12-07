package ua.gis.lines.services.impl.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.parts.WireDao;
import ua.gis.lines.model.parts.Wire;
import ua.gis.lines.services.WireService;
import ua.gis.lines.services.impl.AbstractBasicServiceImpl;

import java.util.List;

@Service
public class WireServiceImpl extends AbstractBasicServiceImpl<Wire> implements WireService {

    @Autowired
    public WireServiceImpl(JpaRepository<Wire, Integer> dao) {
        super(dao);
    }
}
