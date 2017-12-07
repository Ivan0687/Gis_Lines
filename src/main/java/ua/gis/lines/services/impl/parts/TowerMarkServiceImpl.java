package ua.gis.lines.services.impl.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.parts.TowerMark;
import ua.gis.lines.services.TowerMarkService;
import ua.gis.lines.services.impl.AbstractBasicServiceImpl;

@Service
public class TowerMarkServiceImpl extends AbstractBasicServiceImpl<TowerMark> implements TowerMarkService {

    @Autowired
    public TowerMarkServiceImpl(JpaRepository<TowerMark, Integer> dao) {
        super(dao);
    }
}
