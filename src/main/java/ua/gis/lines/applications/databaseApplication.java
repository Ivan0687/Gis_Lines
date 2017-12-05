package ua.gis.lines.applications;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gis.lines.configurations.DatabaseConfiguration;
import ua.gis.lines.model.Junction;
import ua.gis.lines.model.Link;
import ua.gis.lines.model.Span;
import ua.gis.lines.model.Tower;
import ua.gis.lines.model.base.PointGPS;
import ua.gis.lines.model.enums.TowerMaterial;
import ua.gis.lines.model.enums.TowerType;
import ua.gis.lines.model.parts.TowerMark;
import ua.gis.lines.services.*;

import java.util.List;

public class databaseApplication {

    public static void main(String[] args) {

        try(AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext(DatabaseConfiguration.class)){
            System.out.println("-------------------------------------------------------------------------------------");

            JunctionService junctionService = context.getBean(JunctionService.class);
            TowerMarkService towerMarkService = context.getBean(TowerMarkService.class);
            LinkService linkService = context.getBean(LinkService.class);
            SpanService spanService = context.getBean(SpanService.class);
            TowerService towerService = context.getBean(TowerService.class);

            System.out.println("-------------------------------------------------------------------------------------");

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

            List<TowerMark> towerMarks = towerMarkService.readAll();

            for (TowerMark towerMark : towerMarks) {
                System.out.println(towerMark);
            }

            System.out.println("-------------------------------------------------------------------------------------");

            List<Link> links = linkService.readAll();

            for (Link link : links) {
                System.out.println(link);
            }

            System.out.println("-------------------------------------------------------------------------------------");

            List<Tower> towers = towerService.readAll();

            for (Tower tower : towers) {
                System.out.println(tower);
            }

            System.out.println("-------------------------------------------------------------------------------------");

            Span span = spanService.read(1);

            System.out.println(span);

            System.out.println("-------------------------------------------------------------------------------------");

        }
    }
}
