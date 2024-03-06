package es.neesis.annotations.applications;

import es.neesis.annotations.services.AhorcadoService;
import es.neesis.annotations.services.GeneradorPalabras;
import es.neesis.annotations.services.IAhorcadoService;
import es.neesis.annotations.services.IPalabras;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Ahorcado {

    private final IAhorcadoService ahorcadoService;


    public Ahorcado(IAhorcadoService ahorcadoService) {
        this.ahorcadoService = ahorcadoService;
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        String opcion;

        do{
            System.out.println("Juego del ahorcado, elija una opcion");
            System.out.println("1. Juego nuevo");
            System.out.println("2. Salir");

            opcion = sc.nextLine();

            switch (opcion){
                case "1":
                    IPalabras palabra = new GeneradorPalabras();
                    AhorcadoService juego = new AhorcadoService(palabra);
                    ahorcadoService.jugar();
                    break;
                case "2":
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;

            }

        }while(!opcion.equals("2"));

        sc.close();

    }

}
