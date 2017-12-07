package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.services.GpsService;

@Service
public class GpsServiceImpl extends AbstractBasicServiceImpl<PointGPS> implements GpsService {

    @Autowired
    public GpsServiceImpl(JpaRepository<PointGPS, Integer> dao) {
        super(dao);
    }
}
