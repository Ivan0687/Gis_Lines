package ua.gis.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.SpanDao;
import ua.gis.lines.model.Span;

@Service
public class SpanService {

    private final SpanDao dao;

    @Autowired
    public SpanService(SpanDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public Span read(int id){
        return dao.findOne(id);
    }
}
