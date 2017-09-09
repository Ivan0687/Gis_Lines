package ua.gis.lines.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.JunctionDao;
import ua.gis.lines.model.Junction;

import java.util.List;

@Service
public class JunctionService {

    private final JunctionDao junctionDao;

    public JunctionService(JunctionDao junctionDao) {
        this.junctionDao = junctionDao;
    }

    @Transactional(readOnly = true)
    public List<Junction> findAll(){
        return junctionDao.findAll();
    }

    @Transactional(readOnly = true)
    public Junction findById(Integer id){
        junctionDao.getOne(id);
        return junctionDao.findOne(id);
    }

}