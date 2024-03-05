package es.neesis.annotations;

import es.neesis.annotations.applications.Ahorcado;
import es.neesis.annotations.services.IPalabras;
import es.neesis.annotations.services.GeneradorPalabras;

import java.util.Scanner;
public class ApplicationRunner {

    public static void main(String[] args) {
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
                    Ahorcado juego = new Ahorcado(palabra);
                    juego.jugar();
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
