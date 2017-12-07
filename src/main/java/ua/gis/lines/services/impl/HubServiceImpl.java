package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.gis.lines.model.Hub;
import ua.gis.lines.services.HubService;

@Service
public class HubServiceImpl extends AbstractBasicServiceImpl<Hub> implements HubService {

    @Autowired
    public HubServiceImpl(JpaRepository<Hub, Integer> dao) {
        super(dao);
    }
}
