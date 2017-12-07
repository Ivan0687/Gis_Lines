package ua.gis.lines.applications;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.gis.lines.configurations.DatabaseConfiguration;
import ua.gis.lines.services.TestService;

public class databaseApplication {

    public static void main(String[] args) {

        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(DatabaseConfiguration.class)) {
            System.out.println("-------------------------------------------------------------------------------------");

            TestService test = context.getBean(TestService.class);

            test.initDatabase();

            System.out.println("-------------------------------------------------------------------------------------");



        }
    }
}
