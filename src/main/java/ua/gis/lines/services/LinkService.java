package ua.gis.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.dao.LinkDao;
import ua.gis.lines.model.Link;

import java.util.List;

@Service
public class LinkService {

    private final LinkDao dao;

    @Autowired
    public LinkService(LinkDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public List<Link> readAll(){
        return dao.findAll();
    }
}
