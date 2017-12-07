package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.TransmitLine;
import ua.gis.lines.services.TransmitLineService;

@Service
public class TransmitLineServiceImpl extends AbstractBasicServiceImpl<TransmitLine> implements TransmitLineService {

    @Autowired
    public TransmitLineServiceImpl(JpaRepository<TransmitLine, Integer> dao) {
        super(dao);
    }
}
