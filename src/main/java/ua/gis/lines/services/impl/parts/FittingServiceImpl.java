package ua.gis.lines.services.impl.parts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.parts.Fitting;
import ua.gis.lines.services.FittingService;
import ua.gis.lines.services.impl.AbstractBasicServiceImpl;

@Service
public class FittingServiceImpl extends AbstractBasicServiceImpl<Fitting> implements FittingService {

    @Autowired
    public FittingServiceImpl(JpaRepository<Fitting, Integer> dao) {
        super(dao);
    }
}
