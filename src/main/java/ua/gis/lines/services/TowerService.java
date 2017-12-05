package ua.gis.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gis.lines.dao.TowerDao;
import ua.gis.lines.model.Tower;

import java.util.List;

@Service
public class TowerService {

    private final TowerDao dao;

    @Autowired
    public TowerService(TowerDao dao) {
        this.dao = dao;
    }

    public List<Tower> readAll(){
        return dao.findAll();
    }

}
