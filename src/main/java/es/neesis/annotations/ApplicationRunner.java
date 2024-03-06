package es.neesis.annotations;

import es.neesis.annotations.applications.Ahorcado;
import es.neesis.annotations.configuration.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ApplicationRunner {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Ahorcado ahorcadoApp = context.getBean(Ahorcado.class);

        ahorcadoApp.run();
    }

}
