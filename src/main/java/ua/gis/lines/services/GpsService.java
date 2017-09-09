package ua.gis.lines.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.gis.lines.dao.PointGpsDao;
import ua.gis.lines.model.PointGPS;

import java.util.List;

@Service
public class GpsService {

    private final PointGpsDao gpsDao;

    @Autowired
    public GpsService(PointGpsDao gpsDao) {
        this.gpsDao = gpsDao;
    }

    public List<PointGPS> points(){
        return gpsDao.findAll();
    }
}
