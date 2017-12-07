package ua.gis.lines.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.gis.lines.model.Hub;
import ua.gis.lines.model.Tower;
import ua.gis.lines.model.TransmitLine;
import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.enums.TowerMaterial;
import ua.gis.lines.model.enums.TowerType;
import ua.gis.lines.model.parts.TowerMark;
import ua.gis.lines.services.*;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    private final TowerMarkService towerMarkService;

    private final GpsService gpsService;
    private final TowerService towerService;

    private final HubService hubService;

    private final TransmitLineService lineService;

    @Autowired
    public TestServiceImpl(TowerMarkService towerMarkService, GpsService gpsServic, TowerService towerService, HubService hubService, TransmitLineService lineService) {
        this.towerMarkService = towerMarkService;
        this.gpsService = gpsServic;
        this.towerService = towerService;
        this.hubService = hubService;
        this.lineService = lineService;
    }

    @Override
    @Transactional
    public void initDatabase() {

        TowerMark towerMark;
        PointGPS gps1;
        PointGPS gps2;

        Tower tower1;
        Tower tower2;

        Hub hub1;
        Hub hub2;

        TransmitLine line;

        if (towerMarkService.isEmpty()){

            towerMark = new TowerMark();
            towerMark.setMark("Y-60");
            towerMark.setHeight(25);
            towerMark.setWeight(2.5);
            towerMark.setMaterial(TowerMaterial.METAL);
            towerMarkService.save(towerMark);

            if (gpsService.isEmpty()){

                gps1 = new PointGPS();
                gps1.setLatitude(50.534934);
                gps1.setLongitude(30.661316);
                gpsService.save(gps1);

                gps2 = new PointGPS();
                gps2.setLatitude(50.501277);
                gps2.setLongitude(30.614936);
                gpsService.save(gps2);

                if (towerService.isEmpty()){
                    tower1 = new Tower();
                    tower1.setGps(gps1);
                    tower1.setMark(towerMark);
                    tower1.setType(TowerType.ANCHOR);
                    towerService.save(tower1);

                    tower2 = new Tower();
                    tower2.setGps(gps2);
                    tower2.setMark(towerMark);
                    tower2.setType(TowerType.ANCHOR);
                    towerService.save(tower2);

                    if (hubService.isEmpty()){
                        hub1 = new Hub("PS TEC-6");
                        hubService.save(hub1);

                        hub2 = new Hub("PS Troika");
                        hubService.save(hub2);

                        if (lineService.isEmpty()){
                            line = new TransmitLine();

                            line.setVoltage(110);

                            line.setBegin(hub1);
                            line.setEnd(hub2);

                            Map<Integer, Tower> towers = new HashMap<>();
                            towers.put(1, tower1);
                            towers.put(36, tower2);
                            line.setTowers(towers);

                            lineService.save(line);

                        }
                    }
                }
            }
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (TowerMark mark : towerMarkService.getAll()) {
            System.out.println(mark);
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (PointGPS gps : gpsService.getAll()) {
            System.out.println(gps);
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (Tower tower : towerService.getAll()) {
            System.out.println(tower);
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (Hub hub : hubService.getAll()) {
            System.out.println(hub);
        }

        System.out.println("-------------------------------------------------------------------------------------");

        for (TransmitLine transmitLine : lineService.getAll()) {
            System.out.println(transmitLine);
        }

        System.out.println("-------------------------------------------------------------------------------------");


        throw new RuntimeException();
    }


}
