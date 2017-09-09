package ua.gis.lines.applications;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gis.lines.configurations.DatabaseConfiguration;
import ua.gis.lines.dao.PointGpsDao;
import ua.gis.lines.model.Junction;
import ua.gis.lines.model.PointGPS;
import ua.gis.lines.services.GpsService;
import ua.gis.lines.services.JunctionService;

import java.util.List;

public class databaseApplication {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(DatabaseConfiguration.class)){
            System.out.println("-------------------------------------------------------------------------------------");

            JunctionService junctionService = context.getBean(JunctionService.class);

            List<Junction> junctions = junctionService.findAll();

            for (Junction junction : junctions) {
                System.out.println(junction);
            }
            System.out.println("-------------------------------------------------------------------------------------");

            GpsService gpsService = context.getBean(GpsService.class);

            List<PointGPS> points = gpsService.points();

            for (PointGPS point : points) {
                System.out.println(point);
            }

            System.out.println("-------------------------------------------------------------------------------------");
        }
    }
}
