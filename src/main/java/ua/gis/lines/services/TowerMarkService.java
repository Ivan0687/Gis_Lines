package ua.gis.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.parts.TowerMarkDao;
import ua.gis.lines.model.parts.TowerMark;

import java.util.List;

@Service
public class TowerMarkService {

    private final TowerMarkDao dao;

    @Autowired
    public TowerMarkService(TowerMarkDao dao) {
        this.dao = dao;
    }

    @Transactional
    public TowerMark save(TowerMark mark){

        return dao.save(mark);
    }

    @Transactional(readOnly = true)
    public List<TowerMark> readAll(){
        return dao.findAll();
    }
}
