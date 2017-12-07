package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.Tower;
import ua.gis.lines.services.TowerService;

@Service
public class TowerServiceImpl extends AbstractBasicServiceImpl<Tower> implements TowerService {

    @Autowired
    public TowerServiceImpl(JpaRepository<Tower, Integer> dao) {
        super(dao);
    }
}
