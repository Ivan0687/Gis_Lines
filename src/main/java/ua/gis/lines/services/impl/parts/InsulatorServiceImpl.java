package ua.gis.lines.services.impl.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.parts.InsulatorDao;
import ua.gis.lines.model.parts.Insulator;
import ua.gis.lines.services.InsulatorService;
import ua.gis.lines.services.impl.AbstractBasicServiceImpl;

import java.util.List;

@Service
public class InsulatorServiceImpl extends AbstractBasicServiceImpl<Insulator> implements InsulatorService {

    @Autowired
    public InsulatorServiceImpl(JpaRepository<Insulator, Integer> dao) {
        super(dao);
    }
}
